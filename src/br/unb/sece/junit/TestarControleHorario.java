package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CHorario;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.util.ModelComboBox;

public class TestarControleHorario {

	private CHorario CHorario;
	private ModelComboBox modelDisciplinas;
	private ModelComboBox modelProfessores;
	private Disciplina disciplina;
	
	@Before
	public void test() {

		CHorario = new CHorario();
		disciplina = new Disciplina();
		
		modelDisciplinas = new ModelComboBox(disciplina.getAll(), "getId", "getNome");
		modelProfessores = new ModelComboBox();
		
	}
	
	@Test
	public void testarInstancia()
	{
		assertNotNull(CHorario);
	}
	
	/*@Test
	public void testarModelDisciplinaNulo()
	{
		modelDisciplinas = null;
		
		CHorario.setModelDisciplinas(modelDisciplinas);
		
		try
		{
			CHorario.getModelDisciplinas();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
		
	}*/
	
	@Test
	public void testarModelDisciplina()
	{
		
		CHorario.setModelDisciplinas(modelDisciplinas);
		
		try
		{
			CHorario.getModelDisciplinas();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
		
	}
	
	
	@Test
	public void getModelProfessores()
	{
		String disciplina = "1 - Matemática";
		
		Horario obHorario = new Horario();
		obHorario.setHrFinal(Calendar.getInstance());
		obHorario.setHrInicial(Calendar.getInstance());
		CHorario.setObHorario(obHorario);
		
		CHorario.getModelDisciplinas().setSelectedItem(disciplina);
		
		try
		{
			CHorario.getModelProfessores();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
