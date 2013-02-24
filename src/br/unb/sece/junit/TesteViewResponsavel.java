package br.unb.sece.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Responsavel;
import br.unb.sece.view.VResponsavel;

public class TesteViewResponsavel {
	
	private VResponsavel vresponsavel;
	private Responsavel responsavel;
	
	@Before
	public void setUp() throws BancoDeDadosException{
		vresponsavel = new VResponsavel();
		
		responsavel = new Responsavel();
		responsavel.setNome("Cleiton");
		responsavel.setCEP("72800000");
		responsavel.setEmail("sece@gmail.com");
		
	}
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(vresponsavel);
	}

}
