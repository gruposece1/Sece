package Control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import Model.Disciplina;
import Model.Professor;
import Model.Serie;

public class CHorario {
	
	public List getNomeDisciplinas()
	{
		
		Disciplina disciplina=new Disciplina();
		
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
	
	

}
