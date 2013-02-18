package br.unb.sece.util.gradehoraria;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;
import br.unb.sece.model.Turno;

public class GradeHoraria {
	
	private Object[][] gradeDeHorarios;
	
	private HashMap<Disciplina,TurmaDisciplina> disciplinasTurma;
	
	public GradeHoraria(Serie serie, Turno turno){
		
		this.gerarGrade(serie, turno);
		
	}
	
	public void gerarGrade(Serie serie, Turno turno){
		
		assert(serie != null);
		assert(turno != null);
		
		float duracao = (turno.getFim() - turno.getInicio())/serie.getQtdeHorarios();
		gradeDeHorarios = new Object[serie.getQtdeHorarios()][serie.getQtdeDias()]; 
		Date data = new Date();
	
		
		float inicio = turno.getInicio();
		int init = (int)inicio;		
		
		data.setHours(init);
		
		inicio = (inicio - (int)inicio)*100;
		
		data.setMinutes((int) inicio);
		
		GregorianCalendar gc = new GregorianCalendar();  
		gc.setTime(data);  
		  
		//SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");  		
		
		//System.out.println("Numero de série: " + serie.getQtdeDias());
		this.preencherGrade(serie.getQtdeDias(), serie.getQtdeHorarios(), gc, duracao);
	}
	
	private void preencherGrade(int coluna, int linha, GregorianCalendar calendario, float duracao){
		
		for(int i =0; i<coluna; i++){
			GregorianCalendar aux = (GregorianCalendar) calendario.clone();
					
			for(int k=0; k<linha; k++){
				Horario horario = new Horario();
				
				horario.setHrInicial((Calendar) aux.clone());
				aux.add(Calendar.MINUTE, (int) (duracao*60));
				horario.setHrFinal((Calendar) aux.clone());
				horario.setDiaSemana(i);
				
				gradeDeHorarios[k][i] = horario;
				
				
				
			}
		}
	
	}
	
	public void verificarGrade() throws AtributoNuloException, AtributoInvalidoException{
		for(int i = 0 ; i < this.gradeDeHorarios.length; i++){
			Object[] linha = this.gradeDeHorarios[i];
			for(int j = 0; j < linha.length; j++){
				Horario obHorario = (Horario)linha[j];
				obHorario.verificar();
			}
		}
	}
	
	public void salvarGrade(Session session) throws AtributoNuloException, AtributoInvalidoException{
		for(int i = 0 ; i < this.gradeDeHorarios.length; i++){
			Object[] linha = this.gradeDeHorarios[i];
			for(int j = 0; j < linha.length; j++){
				Horario obHorario = (Horario)linha[j];
				TurmaDisciplina turmaDisciplina = this.disciplinasTurma.get(obHorario.getDisciplina());
				obHorario.setTurmaDisciplina(turmaDisciplina);
				obHorario.salvar(session);
			}
		}
	}
	
	public List getDisciplinasGrade(){
		HashMap<Disciplina,Integer> disciplinas =  new HashMap<Disciplina, Integer>();
		for(int i = 0 ; i < this.gradeDeHorarios.length; i++){
			Object[] linha = this.gradeDeHorarios[i];
			for(int j = 0; j < linha.length; j++){
				Horario obHorario = (Horario)linha[j];
				disciplinas.put(obHorario.getDisciplina(), 1);
			}
		}
		
		Set<Disciplina> disciplinasSet = disciplinas.keySet();
		Iterator iDisciplinasSet = disciplinasSet.iterator();
		ArrayList<Disciplina> listDisciplinas = new ArrayList<Disciplina>();
		while(iDisciplinasSet.hasNext()){
			Disciplina obDisciplina = (Disciplina) iDisciplinasSet.next();
			listDisciplinas.add(obDisciplina);
		}
		return listDisciplinas;
	}
	
	public void gerarTurmasDisciplinas(Turma turma, Session session){
		List listaDisciplinas = this.getDisciplinasGrade();
		this.disciplinasTurma = new HashMap<Disciplina,TurmaDisciplina>();
		for(int i = 0 ; i < listaDisciplinas.size(); i++){
			TurmaDisciplina turmaDisciplina = new TurmaDisciplina();
			turmaDisciplina.setTurma(turma);
			Disciplina obDisciplina = (Disciplina)listaDisciplinas.get(i);
			turmaDisciplina.setDisciplina(obDisciplina);
			turmaDisciplina.salvar(session);
			this.disciplinasTurma.put(obDisciplina, turmaDisciplina);
			
		}
	}
	
	public Object[][] getGradeDeHorarios() {
		return gradeDeHorarios;
	}

	public void setGradeDeHorarios(Object[][] gradeDeHorarios) {
		this.gradeDeHorarios = gradeDeHorarios;
	}

	public Horario getHorario (int linha, int coluna) throws NullPointerException {
		
		return (Horario)this.gradeDeHorarios[linha][coluna];
		
		
	}
}