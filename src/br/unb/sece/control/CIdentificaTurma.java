package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Iterator;

import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;
import br.unb.sece.util.ModelComboBox;

public class CIdentificaTurma {

	 private ModelComboBox modelTurma = null;
	 
	 private ModelComboBox modelDisciplina = null;
	 
	 private ModelComboBox modelHorario = null;
	 
	 
	 public ModelComboBox getModelCBTurma(){
		 if(this.modelTurma == null){
			 this.modelTurma = new ModelComboBox(Turma.getAll(),"getIdTurma","getNomeTurma");
		 }
		 return this.modelTurma;
	 }
	 
	 public ModelComboBox getModelCBDisciplinas(Turma turma){
		 if(turma == null) throw new NullPointerException();
		 this.modelDisciplina = new ModelComboBox(TurmaDisciplina.getDisciplinas(turma),"getId","getNome");
		 return this.modelDisciplina;
	 }
	 
	 public ModelComboBox getModelCBHorario(Turma turma,Disciplina disciplina){
		 if(disciplina == null) throw new NullPointerException();
		 this.modelHorario = new ModelComboBox(Horario.getHorariosDaTurma(turma, disciplina),"getIdHorario","getDiaSemanaString");
		 return this.modelHorario;
	 } 
	 
	 public Turma getTurmaSelected() throws NullPointerException {
			final Turma obTurma = (Turma) this.modelTurma.getSelectedItemObject();
			
			if(obTurma == null)
				throw new NullPointerException();
			
			return obTurma;
	  }
	 
	 public Disciplina getDisciplinaSelected() throws NullPointerException {
			final Disciplina obDisciplina = (Disciplina) this.modelDisciplina.getSelectedItemObject();
			
			if(obDisciplina == null)
				throw new NullPointerException();
			
			return obDisciplina;
	}
	 
	 public Horario getHorarioSelected() throws NullPointerException {
			final Horario obHorario = (Horario) this.modelHorario.getSelectedItemObject();
			
			if(obHorario == null)
				throw new NullPointerException();
			
			return obHorario;
	}
		
	
}
