package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Iterator;

import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
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
	
	public String[] getAllDisciplinas(){
		
		ArrayList<Disciplina> disciplinas = (ArrayList)disciplina.getAll();
		
		String[] nomes = new String[disciplinas.size()];
		
		for(int i=0; i<disciplinas.size(); i++){
			
			Disciplina disciplina = (Disciplina) disciplinas.get(i);
			nomes[i] = disciplina.getNome();
			
		}
		
		
			return nomes;
	}
	
	public int selectTurma(String nome)
	{
		Turma turma = new Turma();
		
		nome = nome.substring(4,nome.length());
		
		System.out.println(nome);
		
		
		for (Iterator<Turma> iter = turma.getAll().iterator(); iter. hasNext();)
		{	
			Turma t = iter.next();
			
			if(t.getNomeTurma().equals(nome))
			{	
				setTurma(t);
				return 0;
			}	
		}
		
		
		setTurma(null);
		
		return 1;
	}
	
	public int selectDisciplina(String nome)
	{
		
		Disciplina disciplina = new Disciplina();
		
		
		for (Iterator<Disciplina> iter = disciplina.getAll().iterator(); iter. hasNext();)
		{	
			Disciplina disciplinas = iter.next();
			
			if(disciplinas.getNome().equals(nome))
			{	
				setDisciplina(disciplinas);
				return 0;
			}	
		}
		
		
		setDisciplina(null);
		return 1;
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
