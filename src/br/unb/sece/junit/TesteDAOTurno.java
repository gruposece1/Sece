package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import br.unb.sece.model.Turno;
import br.unb.sece.model.DAO.TurnoDAO;

public class TesteDAOTurno {
	
	private TurnoDAO turnoDAO;
	private Turno turno;
	
	@Before
	public void setUp(){
		turnoDAO = new TurnoDAO();
		turno = new Turno();
	}
	
	@Test
	public void testarInstancia(){
		assertNotNull(turnoDAO);
	}
	
	@Test
	public void testarGetAll(){
	
		try{
			turnoDAO.listAll(turno.getClass());
		}
		catch(Exception e){
			//fail("Ocorreu um erro");
			e.printStackTrace();
		}
	}

}
