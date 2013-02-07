package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.DAO.AlunoDAO;

public class TesteAlunoDAO {

	private AlunoDAO alunoDAO;
	private Aluno aluno;
	
	@Before
	public void setUp(){
		
		alunoDAO = new AlunoDAO();
		aluno = new Aluno();
	}
	
	@Test
	public void testarInstancia(){
		assertNotNull(alunoDAO);
	}
	
	@Test
	public void testarGetAll(){
	
		try
		{
			alunoDAO.listAll(aluno.getClass());
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	
	public void testarGetAllErro(){
	
		//A fazer...
	}
	
	

}
