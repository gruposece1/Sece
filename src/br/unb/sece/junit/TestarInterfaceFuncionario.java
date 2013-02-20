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

import br.unb.sece.view.VFuncionario;
import br.unb.sece.view.VResponsavel;

public class TestarInterfaceFuncionario {

	private FrameFixture window;
	
	@Before
	public void setUp() {
		
		/*login = GuiActionRunner.execute(new GuiQuery<VLogin>() {
	        protected VLogin executeInEDT() {
	          return new VLogin();  
	        }
	    });*/
		
		//panel.criarPainel();
		
		
	    window = new FrameFixture(new VFuncionario());
	    window.show(new Dimension(900,500)); // shows the frame to test
	}
		
	
	


	@Test
	public void testarCadastroCerto()
	{
		
		try
		{
			
			window.textBox("Nome").enterText("Funcionario");
			window.radioButton("Masculino").click();
			window.textBox("CPF").enterText("2143");
			window.textBox("Telefone").enterText("86451342");
			window.textBox("Senha").enterText("Senha");
			window.comboBox("CBCargo").selectItem(0);
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
	}
	
	@Test
	public void testarAlterarDado()
	{
		
			window.table().selectCell(TableCell.row(0).column(0));
			window.button("Alt").click();
			window.textBox("Nome").deleteText();
			window.textBox("Nome").enterText("Alterar");
			window.button("Cadastrar").click();
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Deseja realmente alterar o registro?");
			window.optionPane().okButton().click();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Dados Alterados");
			window.optionPane().okButton().click();
		
	}
	
	@Test
	public void testarExcluirDado()
	{
		
			window.table().selectCell(TableCell.row(0).column(0));
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
