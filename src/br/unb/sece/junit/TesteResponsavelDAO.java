package br.unb.sece.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.DAO.AlunoDAO;
import br.unb.sece.model.DAO.ResponsavelDAO;

public class TesteResponsavelDAO {
	
	private ResponsavelDAO responsavelDAO;
	private Responsavel responsavel;
	
	@Before
	public void setUp(){
		
		responsavelDAO = new ResponsavelDAO();
		responsavel = new Responsavel();
	}
	
	@Test
	public void testarInstancia(){
		assertNotNull(responsavelDAO);
	}
	
	@Test
	public void testarGetAll(){
	
		try
		{
			responsavelDAO.listAll(responsavel.getClass());
		}
		catch(Exception e)
		{
			//fail("Ocorreu um erro");
			e.printStackTrace();
		}
	}
	
	

}
