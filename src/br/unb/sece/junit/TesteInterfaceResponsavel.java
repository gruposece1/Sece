package br.unb.sece.junit;

import static org.junit.Assert.fail;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import org.fest.swing.data.TableCell;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.timing.Timeout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unb.sece.view.VFuncionario;
import br.unb.sece.view.VResponsavel;

public class TesteInterfaceResponsavel {

	/*private FrameFixture window;
	
	@Before
	public void setUp() {
		
		/*login = GuiActionRunner.execute(new GuiQuery<VLogin>() {
	        protected VLogin executeInEDT() {
	          return new VLogin();  
	        }
	    });
		
		//panel.criarPainel();
		
		
	    window = new FrameFixture(new VResponsavel());
	    window.show(new Dimension(900,500)); // shows the frame to test
	}
		
	
	


	@Test
	public void testarCadastroCerto(){
		
		try{
			
			window.textBox("Nome").enterText("Responsavel");
			
			Thread.sleep(1000);
			
			window.textBox("CPF").enterText("2143");
			window.radioButton("Masculino").click();
			window.textBox("Endereco").enterText("ruacasimero");
			window.textBox("Email").enterText("sece@gmail.com");
			window.textBox("Telefone").enterText("84845542");
			window.textBox("Cep").enterText("72800000");
			window.button("Cadastrar").click();
			window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Dados Cadastrados");
			
			
		}
		catch(Exception e){
			//fail("Ocorreu um erro");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testarCadastroErrado(){
		window.button("Cadastrar").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireErrorMessage().requireMessage("Algum campo esta em branco");
	}
	
	@Test
	public void testarAlterarDado(){
		
			window.table().selectCell(TableCell.row(0).column(0));
			//window.table().selectCell(TableCell.row(0).column(1));
			//window.table().selectCell(TableCell.row(2).column(2));
			window.button("Alt").click();
			window.textBox("CPF").deleteText();
			window.textBox("CPF").enterText("Alterar");
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
	public void testarExcluirDado(){
		
			//window.table().selectCell(TableCell.row(0).column(0));
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
	}*/


}
