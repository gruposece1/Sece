package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import br.unb.sece.exceptions.BancoDeDadosException; 
import br.unb.sece.model.Serie;
import br.unb.sece.view.VSerie;

public class TesteVSerie {
	
	private VSerie vserie;
	private Serie serie;
	
	@Before
	public void setUp() throws BancoDeDadosException{
		vserie = new VSerie();
		
		serie = new Serie();
		serie.setNome("gustavo");
		serie.setQtdeDias(1);
		serie.setQtdeHorarios(1);
		
	}
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(vserie);
	}
	
	
}