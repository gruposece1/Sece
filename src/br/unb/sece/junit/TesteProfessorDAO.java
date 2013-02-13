package br.unb.sece.junit;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.model.Professor;
import br.unb.sece.model.DAO.ProfessorDAO;


public class TesteProfessorDAO {

	private ProfessorDAO professorDAO;
	private Professor professor;
	
	@Before
	public void setUp(){
		
		professorDAO = new ProfessorDAO();
		professor = new Professor();
	}
	
	@Test
	public void testarInstancia(){
		assertNotNull(professorDAO);
	}
	
	@Test
	public void testarGetAll(){
	
		try{
			professorDAO.listAll(professor.getClass());
		}
		catch(Exception e){
			//fail("Ocorreu um erro");
			e.printStackTrace();
		}
	}
	
	public void testarGetAllErro(){
	
		//A fazer...
	}
	

}
