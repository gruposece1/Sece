package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Horario;
import br.unb.sece.util.ModelComboBox;



public class CHorario {
	
	
	List disciplinas ;
	
	ModelComboBox modelDisciplinas = null;
	
	ModelComboBox modelProfessores = null;
	
	private Horario obHorario;
	
	
	public ModelComboBox getModelDisciplinas(){
		
		if(this.modelDisciplinas == null){
			
			Disciplina d = new Disciplina();
			this.modelDisciplinas = new ModelComboBox(d.getAll(), "getId", "getNome");
			
		}
		
		return this.modelDisciplinas;
	}
	
	public ModelComboBox getModelProfessores(){
		if(this.modelProfessores == null){
				Professor obProfessor = new Professor();
				this.modelProfessores = new ModelComboBox(this.getProfessoresDisponiveis(), "getIdPessoa", "getNome");
					
		}
		
		return this.modelProfessores;
	}
	
	
	public List getNomeDisciplinas()
	{
		
		Disciplina disciplina = new Disciplina();
		
		ArrayList nmDisciplina = new ArrayList();
			
		for (Iterator iter = disciplina.getAll().iterator(); iter. hasNext(); )
		{	
			Disciplina d = (Disciplina)iter.next();
			
			nmDisciplina.add(d.getNome());
			
		}
		
		return nmDisciplina;

	}
	
	public List getNomeProfessores()
	{
		
		Professor professor=new Professor();
		
		ArrayList professores = (ArrayList)professor.getAll();
		
		ArrayList nmProfessor = new ArrayList();
			
		for (Iterator iter = professores.iterator(); iter. hasNext(); )
		{	
			Professor d = (Professor)iter.next();
			
			nmProfessor.add(d.getNome());
			
		}
		
		return nmProfessor;

	}
	
	public  Disciplina GuardaDisciplina(String itemDisciplina){
		
		Disciplina disciplina = new Disciplina();
		
		ArrayList nmDisciplina = new ArrayList();
		
		for (Iterator iter = disciplina.getAll().iterator(); iter. hasNext();)
		{	
			Disciplina d = (Disciplina)iter.next();
			if(d.getNome().equals(itemDisciplina))
				return d;
			
		}
		
		
		return null;
	}
	
	public Professor getProfessorSelected() throws NullPointerException{
		Professor obProfessor = (Professor)this.modelProfessores.getSelectedItemObject();
		if(obProfessor == null){
			throw new NullPointerException();
		}
		return obProfessor;
	}
	
	public Disciplina getDisciplinaSelected() throws NullPointerException{
		Disciplina obDisciplina = (Disciplina)this.modelDisciplinas.getSelectedItemObject();
		if(obDisciplina == null){
			throw new NullPointerException();
		}
		return obDisciplina;
	}
	
	
	public List getProfessoresDisponiveis(){
		return Professor.getProfessoresDisponiveis(this.obHorario, (Disciplina)this.modelDisciplinas.getSelectedItemObject());
	}
	
	public Professor GuardaProfessores(String itemProfessor)
	{
		
		Professor professor=new Professor();
		
		ArrayList professores = (ArrayList)professor.getAll();
			
		for (Iterator iter = professores.iterator(); iter. hasNext(); )
		{	
			Professor f = (Professor)iter.next();
			if(f.getNome().equals(itemProfessor))
				return f;
			
		}
		
		return null;

	}

	public Horario getObHorario() {
		return obHorario;
	}

	public void setObHorario(Horario obHorario) {
		this.obHorario = obHorario;
	}
	
	
	
	

}
