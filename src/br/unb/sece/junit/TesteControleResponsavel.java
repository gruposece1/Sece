package br.unb.sece.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CPadrao;
import br.unb.sece.control.CResponsavel;
import br.unb.sece.model.DAO.ResponsavelDAO;
import br.unb.sece.view.VResponsavel;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Responsavel;
import br.unb.sece.view.VResponsavel;
import br.unb.sece.view.panelcadastropadrao.VCadFuncionario;
import br.unb.sece.view.panelcadastropadrao.VCadResponsavel;


public class TesteControleResponsavel {
	private CResponsavel CResponsavel;
	private Responsavel responsavel;
	private VResponsavel panel;
	
	@Before
	public void setUp(){
		
		CResponsavel = new CResponsavel();
		responsavel = new Responsavel();
		
		responsavel.setNome("cleiton");
		responsavel.setCEP("72800000");
		responsavel.setCpf("03508984164");
		responsavel.setEmail("sece@gmail.com");

		
		panel = new VResponsavel();
		panel.criarPainel();
		
		//ARRUMAR
		
	((VCadResponsavel) panel.getPanel()).getTextField().setText("Teste");
	((VCadResponsavel) panel.getPanel()).getTextField_1().setText("Teste");
	((VCadResponsavel) panel.getPanel()).getTextField_2().setText("Teste");
	((VCadResponsavel) panel.getPanel()).getTextField_3().setText("Teste");

	
	}	
	
	@Test
	public void testarInstancia() {

		assertNotNull(CResponsavel);
	}
	
	
	@Test
	public void testarDadosValidos(){
		
		CResponsavel.setResponsavel(responsavel);
		
		try {
			CResponsavel.verificarDados();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}

	@Test
	public void testarExclusao(){
		
		try {
			CResponsavel.excluir(responsavel);
		} catch (Exception e) {
			fail("Ocorreu erro");
			//e.printStackTrace();
		}
	}
	
	/*@Test
	public void testarSalvar(){
		
		try {
			CSerie.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}*/
	
	@Test
	public void testarModeloTabela(){
		
		try{
			CResponsavel.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{
		
		
		responsavel.setNome("");
		
		CResponsavel.setResponsavel(responsavel);
		
		CResponsavel.verificarDados();
		
		
	}
	
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosNulo() throws Exception{
		
		VCadResponsavel Responsavel = null;
	
		CResponsavel.receberDados(responsavel,2);
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{
		
		CResponsavel.receberDados(responsavel,1);	
	}
	
	
	
	@Test
	public void testarPanelPadrao()
	{
		assertNotNull(CResponsavel.getPanelPadrao(panel));
	}
	
	@Test
	public void testarReceberDadosInsercao() throws Exception{
		
		
		
		try{
			CResponsavel.receberDados(panel, CPadrao.OPERACAO_INSERIR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testarReceberDadosAlterar() throws Exception{
		
		
		CResponsavel.receberObjetoAlterar(responsavel);
		
		try{
			CResponsavel.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}

}
