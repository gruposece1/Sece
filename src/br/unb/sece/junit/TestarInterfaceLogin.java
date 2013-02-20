package br.unb.sece.junit;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;


import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.timing.Timeout;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unb.sece.view.VLogin;

public class TestarInterfaceLogin {

	private FrameFixture window;
	
	@Before
	public void setUp() {
		
		/*login = GuiActionRunner.execute(new GuiQuery<VLogin>() {
	        protected VLogin executeInEDT() {
	          return new VLogin();  
	        }
	    });*/
		
		//panel.criarPainel();
		
		
	    window = new FrameFixture(new VLogin());
	    window.show(new Dimension(400,500)); // shows the frame to test
	}
		
	
	


	@Test
	public void testarCadastroNulo()
	{
		
		try
		{
			
			window.textBox("Nome").enterText("Erro");
			window.textBox("Senha").enterText("1");
			window.button("Entrar").click();
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireErrorMessage().requireMessage("Nome ou senha inválida");
			
			
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
		
	}
	
	@After public void tearDown() {
	    window.cleanUp();
	}




	
		
	
	
	
}
