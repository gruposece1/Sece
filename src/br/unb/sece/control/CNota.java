package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.Session;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.AlunoDisciplina;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Nota;
import br.unb.sece.model.RegistroNota;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;
import br.unb.sece.util.ModelComboBox;

public class CNota {
	
	private Turma turma;
	private Disciplina disciplina;
	private ModelComboBox modelDisciplinas = null;
	private ModelComboBox modelTurma = null;
	private TurmaDisciplina turmaDisciplina;
	private int bimestre;
	private AlunoDisciplina alunoDisciplina;
	
	public CNota(){
		
	}
	
	public ModelComboBox getModelDisciplinas() {
		if(this.modelDisciplinas == null) {
			this.modelDisciplinas = new ModelComboBox(turmaDisciplina.getDisciplinas(getTurma()), "getId", "getNome");
		}
		
		return this.modelDisciplinas;
	}
	
	public ModelComboBox getModelTurma() {
		
		if(this.modelTurma == null) {
			this.modelTurma = new ModelComboBox(Turma.getAll(), "getIdTurma", "getNomeTurma");
		}
		
		return this.modelTurma;
	}
	
	public Horario getHorario(){
		Horario h = new Horario();
		return h.horarioAtualTurma(turma);
	}
	
	
	public String[] getAllTurmas(){
		
		ArrayList<Turma> turmas = (ArrayList)Turma.getAll();
		
		String[] nomes = new String[turmas.size()];
		
		for(int i=0; i<turmas.size(); i++){
			
			Turma a = (Turma) turmas.get(i);
			nomes[i] = a.getNomeTurma();
			
		}
		
			return nomes;
	}
	

	
	public int selectTurma(String nome) throws NullPointerException
	{
		 
		final Turma turma = (Turma) this.modelTurma.getSelectedItemObject();
			
		if(turma == null)
		{	
			setTurma(null);
			throw new NullPointerException();
		}	
			
		setTurma(turma);
		
		
		return 0;
	}
	
	public int selectDisciplina(String nome)
	{
		
		final Disciplina disciplina = (Disciplina) this.modelDisciplinas.getSelectedItemObject();
		
		if(disciplina == null)
		{	
			setDisciplina(null);
			throw new NullPointerException();
		}	
			
		setDisciplina(disciplina);
		
		
		return 0;
		
		
	}


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public int getBimestre() {
		return bimestre;
	}

	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}
	
	
	
	public void salvarNota(double valorNota,Long idAluno, Nota nota){
		
		alunoDisciplina = this.retornarAluno(idAluno);
		
		if(this.getModelDisciplinas().getSelectedItem() == null || alunoDisciplina == null){
			throw new NullPointerException();
		}
		
		RegistroNota registroNota = new RegistroNota();
		
		registroNota.setAlunoDisciplina(alunoDisciplina);
		registroNota.setBimestre(getBimestre());
		registroNota.setValor(valorNota);
		registroNota.setNota(nota);
		
		
		
		registroNota.salvar();
	
	}
	
	public void salvarNota(AlunoDisciplina alunoDisciplina,double valorNota, Nota nota,int bimestre, Session session){
		
		
		RegistroNota registroNota = new RegistroNota();
		registroNota.setAlunoDisciplina(alunoDisciplina);
		registroNota.setBimestre(bimestre);
		registroNota.setValor(valorNota);
		registroNota.setNota(nota);
		
		if(session == null){
			registroNota.salvar();
		}else{
		
			registroNota.salvar(session);
		}
		
	}
	
	public void salvarNota(Long idAluno, Disciplina disciplina, HashMap<Integer, Double> notas, int bimestre, Session session){
		Aluno aluno = Aluno.getAluno(idAluno);
		this.salvar(aluno, disciplina, notas, bimestre,session);
		
	}
	
	public void salvar(Aluno aluno, Disciplina disciplina, HashMap<Integer, Double> notas, int bimestre, Session session){
		AlunoDisciplina alunoDisciplina = AlunoDisciplina.getAlunoDisciplina(aluno, disciplina);
		Double valorNota = notas.get(bimestre);
		Nota nota = Nota.getNota();
		this.salvarNota(alunoDisciplina, valorNota, nota, bimestre, session);
	}
	
	public AlunoDisciplina retornarAluno(Long idAluno)
	{
		return AlunoDisciplina.getAlunoDisciplina(Aluno.getAluno(idAluno), disciplina);
	}

}
