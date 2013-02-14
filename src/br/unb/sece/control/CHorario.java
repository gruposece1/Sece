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
	
	
	private List disciplinas ;
	
	private ModelComboBox modelDisciplinas = null;
	
	private ModelComboBox modelProfessores = null;
	
	private Horario obHorario;
	
	
	public ModelComboBox getModelDisciplinas(){
		
		if(this.modelDisciplinas == null){
			
			Disciplina d = new Disciplina();
			this.modelDisciplinas = new ModelComboBox(d.getAll(), "getId", "getNome");
			
		}
		
		return this.modelDisciplinas;
	}
	
	public ModelComboBox getModelProfessores(){
		try{
			this.modelProfessores = new ModelComboBox(this.getProfessoresDisponiveis(), "getIdPessoa", "getNome");
		}catch(NullPointerException ex){
			this.modelProfessores = new ModelComboBox(new ArrayList(),"getIdPessoa", "getNome");
			ex.printStackTrace();
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
	
	
	public List getProfessoresDisponiveis() throws NullPointerException {
		return Professor.getProfessoresDisponiveis(this.obHorario, this.getDisciplinaSelected());
	}
	
	

	public Horario getObHorario() {
		return obHorario;
	}

	public void setObHorario(Horario obHorario) {
		this.obHorario = obHorario;
	}

	public void setDisciplinas(List disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setModelDisciplinas(ModelComboBox modelDisciplinas) {
		this.modelDisciplinas = modelDisciplinas;
	}

	public void setModelProfessores(ModelComboBox modelProfessores) {
		this.modelProfessores = modelProfessores;
	}
	
	
	
	

}
