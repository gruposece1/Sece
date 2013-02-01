package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import br.unb.sece.control.CAluno;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Responsavel;

public class TesteAluno {
	
	private Aluno a;
	private CAluno controle;
	
	public void setUp()
	{
		
		
	}
	
	@Test
	public void test() {
		
		
		
		
	}
	
	@Test(expected= AtributoNuloException.class) public void verificarDados() throws Exception { 
		
		ArrayList<Responsavel> responsavel = new ArrayList<Responsavel>();
		
		a = new Aluno();
		a.setResponsaveis(responsavel);
		
		controle = new CAluno();
		controle.setAluno(a);
		
		controle.verificarDados();
		
	}
	

}
