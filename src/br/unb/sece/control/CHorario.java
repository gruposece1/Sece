package br.unb.sece.control;

import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Professor;
import br.unb.sece.util.ModelComboBox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CHorario {
	
	private List disciplinas ;
	private ModelComboBox modelDisciplinas = null;
	private ModelComboBox modelProfessores = null;
	private Horario obHorario;
	
	public ModelComboBox getModelDisciplinas() {
		if(this.modelDisciplinas == null) {
			final Disciplina d = new Disciplina();
			this.modelDisciplinas = new ModelComboBox(d.getAll(), "getId", "getNome");
		}
		
		return this.modelDisciplinas;
	}
	
	public ModelComboBox getModelProfessores() {
		try{
			this.modelProfessores = new ModelComboBox(this.getProfessoresDisponiveis(), "getIdPessoa", "getNome");
		}catch(NullPointerException ex){
			this.modelProfessores = new ModelComboBox(new ArrayList(),"getIdPessoa", "getNome");
			ex.printStackTrace();
		}
		
		return this.modelProfessores;
	}
	
	
	public List getNomeDisciplinas() {
		final Disciplina disciplina = new Disciplina();
		final ArrayList nmDisciplina = new ArrayList();
			
		for (Iterator iter = disciplina.getAll().iterator(); iter. hasNext(); ){	
			final Disciplina d = (Disciplina) iter.next();
			
			nmDisciplina.add(d.getNome());
		}
		
		return nmDisciplina;
	}
	
	public Professor getProfessorSelected() throws NullPointerException {
		final Professor obProfessor = (Professor) this.modelProfessores.getSelectedItemObject();
		
		if(obProfessor == null)
			throw new NullPointerException();
		
		return obProfessor;
	}
	
	public Disciplina getDisciplinaSelected() throws NullPointerException{
		final Disciplina obDisciplina = (Disciplina) this.modelDisciplinas.getSelectedItemObject();
		
		if(obDisciplina == null)
			throw new NullPointerException();
		
		return obDisciplina;
	}
	
	public List getProfessoresDisponiveis() throws NullPointerException {
		return Professor.getProfessoresDisponiveis(this.obHorario, this.getDisciplinaSelected());
	}

	public Horario getObHorario() {
		return this.obHorario;
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
