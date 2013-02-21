package br.unb.sece.junit;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.fest.swing.data.TableCell;


import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.timing.Timeout;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unb.sece.view.VTurno;;

public class TestarInterfaceTurno {

	private FrameFixture window;
	
	@Before
	public void setUp() {
		
		/*login = GuiActionRunner.execute(new GuiQuery<VLogin>() {
	        protected VLogin executeInEDT() {
	          return new VLogin();  
	        }
	    });*/
		
		//panel.criarPainel();
		
		
	    window = new FrameFixture(new VTurno());
	    window.show(new Dimension(900,500)); // shows the frame to test
	}
		
	
	


	@Test
	public void testarCadastroCerto()
	{
		
		try
		{
			
			window.textBox("Inicio").enterText("7");
			window.textBox("Fim").enterText("12");
			window.comboBox("Tipo").selectItem(0);
			window.button("Cadastrar").click();
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Dados Cadastrados");
			
			
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
		
	}
	
	@Test
	public void testarCadastroErrado()
	{
		window.button("Cadastrar").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireErrorMessage().requireMessage("Algum campo esta em branco");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testarAlterarDado()
	{
		try
		{
			window.table().selectCell(TableCell.row(2).column(0));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			window.button("Alt").click();
			window.textBox("Fim").deleteText();
			window.textBox("Fim").enterText("14");
			window.button("Cadastrar").click();
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Deseja realmente alterar o registro?");
			window.optionPane().okButton().click();
			
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Dados Alterados");
			window.optionPane().okButton().click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void testarExcluirDado()
	{
		
			window.table().selectCell(TableCell.row(2).column(0));
			window.button("Excluir").click();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Deseja realmente excluir o registro?");
			window.optionPane().okButton().click();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Dados Excluidos");
			window.optionPane().okButton().click();
		
	}
	
	@After public void tearDown() {
	    window.cleanUp();
	}




	
		
	
	
	
}
