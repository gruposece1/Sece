package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CNota;

public class TestarControleNota {

	private CNota CNota;
	
	@Before
	public void setUp()
	{
		CNota = new CNota();
	}
	
	@Test
	public void testarInstancia()
	{
		assertNotNull(CNota);
	}

	
	@Test
	public void testarGetAllTurmar() {
		
		try
		{
			CNota.getAllTurmas();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarGetAllDisciplinas(){
		
		try
		{
			CNota.getAllDisciplinas();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
		
	}
	
	@Test
	public void testarSelectTurmaCerto()
	{
		int verifica = CNota.selectTurma("Teste");
		
		assertEquals(verifica, 0);
	}
	
	@Test
	public void testarSelectTurmaErrado()
	{
		int verifica = CNota.selectTurma("Errado");
		
		assertEquals(verifica, 1);
	}

	@Test
	public void testarSelectDisciplinaCerto()
	{
		int verifica = CNota.selectDisciplina("Geografia");
		
		assertEquals(verifica, 0);
	}
	
	@Test
	public void testarSelectDisciplinaErrado()
	{
		int verifica = CNota.selectDisciplina("Errado");
		
		assertEquals(verifica, 1);
	}

}
