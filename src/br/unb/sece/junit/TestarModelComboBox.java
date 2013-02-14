package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.model.Disciplina;
import br.unb.sece.util.ModelComboBox;

public class TestarModelComboBox {

	private ModelComboBox ModelComboBox;
	private ModelComboBox modelDisciplinas;
	private Disciplina d;
	
	@Before
	public void setUp() {

		ModelComboBox = new ModelComboBox();
		
		d = new Disciplina();
		this.modelDisciplinas = new ModelComboBox(d.getAll(), "getId", "getNome");
		
	}
	
	@Test
	public void testarGerarElementosErro()
	{
		ArrayList<Object> elementos = new ArrayList<Object>();
		elementos.add(ModelComboBox);
	
		
		ModelComboBox = new ModelComboBox(elementos, "a", "shgfd");
	}	
	
	@Test
	public void getElementIndex()
	{
		try
		{
			this.modelDisciplinas.getElementAt(0);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void getSizeMapeamento()
	{
		try
		{
			this.modelDisciplinas.getSize();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void setSelectedoItem(){
		
		String objeto ="1 - Matematica";
		
		try
		{
			this.modelDisciplinas.setSelectedItem(objeto);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void getSelectedItemNulo()
	{
		try
		{
			this.modelDisciplinas.getSelectedItem();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void getSelectedItem()
	{
		String objeto ="1 - Matematica";
		
		this.modelDisciplinas.setSelectedItem(objeto);
		
		try
		{
			this.modelDisciplinas.getSelectedItem();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void getTextObjectErrado()
	{
		ArrayList<Object> elementos = new ArrayList<Object>();
		elementos.add(d);
	
		
		ModelComboBox = new ModelComboBox(d.getAll(), "getId", "shgfd");
		
		this.ModelComboBox.getElementAt(0);
	}
		

}

