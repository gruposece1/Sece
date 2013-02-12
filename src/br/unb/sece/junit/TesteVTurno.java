package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Turno;
import br.unb.sece.view.VTurno;

public class TesteVTurno {


	private VTurno vturno;
	private Turno turno;
	
	@Before
	public void setUp() throws BancoDeDadosException{
		vturno = new VTurno();
		turno = new Turno();
		
		turno.setInicio(1);
		turno.setFim(2);
		
	}
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(vturno);
	}
	
}
