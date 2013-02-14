package br.unb.sece.junit;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Professor;
import br.unb.sece.view.VProfessor;



public class TesteVProfessor {
    
	private VProfessor vprofessor;
	private Professor professor;
	
	@Before
	public void setUp() throws BancoDeDadosException{
		
		vprofessor = new VProfessor();
		professor = new Professor();
		
		
		//TEM QUE TERMINAR...
		/*
		turno.setInicio(1);
		turno.setFim(2); 
		*/
		
	} 
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(vprofessor);
	}

}
