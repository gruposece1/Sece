package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Iterator;

import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;
import br.unb.sece.util.ModelComboBox;

public class CNota {
	
	private Turma turma;
	private Disciplina disciplina=new Disciplina();
	private ModelComboBox modelDisciplinas = null;
	private ModelComboBox modelTurma = null;
	private TurmaDisciplina turmaDisciplina;
	
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
	
	
	


}
