package br.unb.sece.util.gradehoraria;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.unb.sece.model.Horario;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turno;

public class GradeHoraria {
	
	private Object[][] gradeDeHorarios;
	
	public GradeHoraria(Serie serie, Turno turno){
		
		this.gerarGrade(serie, turno);
		
	}
	
	public void gerarGrade(Serie serie, Turno turno)
	{
		
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