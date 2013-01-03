package Control;

import Model.Disciplina;
import Model.Horario;
import Model.Professor;
import antlr.collections.List;

public class ControleHorario {

	Horario horario;
	
	public ControleHorario(){
		
	}
	
	public List getDisciplina(){
		return null;
		
	}
	
	public Horario getProfessor(Disciplina d, Horario h){
		List profDisponiveis = Professor.getAll();
		
		return h;
	}
	
	public void cadastrar(Disciplina d, Professor p){
		
	}
}
