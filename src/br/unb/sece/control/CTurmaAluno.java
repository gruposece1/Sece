package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Turma;

public class CTurmaAluno {

	private Turma turma;
	
	public CTurmaAluno(){
		turma = new Turma();		
	}
	
	public static List getAll(){
		return  Aluno.getAll();
	}
	

}
