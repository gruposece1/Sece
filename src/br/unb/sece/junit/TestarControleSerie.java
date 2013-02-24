package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CAluno;
import br.unb.sece.control.CPadrao;
import br.unb.sece.control.CSerie;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Serie;
import br.unb.sece.view.VSerie;
import br.unb.sece.view.panelcadastropadrao.VCadSerie;




public class TestarControleSerie {

	private CSerie CSerie;
	private Serie serie;
	private VSerie panel;
	
	@Before
	public void setUp(){
		
		CSerie = new CSerie();
		serie = new Serie();
		
		serie.setNome("cleiton");
		serie.setQtdeDias(1);
		serie.setQtdeHorarios(1);
		
		panel = new VSerie();
		panel.criarPainel();
		//setIndex
		((VCadSerie) panel.getPanel()).getTxtNome().setText("Teste");
		((VCadSerie) panel.getPanel()).getCBDias().setToolTipText("Teste");
		((VCadSerie) panel.getPanel()).getCBHorario().setToolTipText("Teste");

	}	
	
	@Test
	public void testarInstancia() {

		assertNotNull(CSerie);
	}
	
	
	@Test
	public void testarDadosValidos(){
		
		CSerie.setSerie(serie);
		
		try {
			CSerie.verificarDados();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}

	@Test
	public void testarExclusao(){
		
		try {
			CSerie.excluir(serie);
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
			CSerie.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{
		
		
		serie.setNome("");
		
		CSerie.setSerie(serie);
		
		CSerie.verificarDados();
		
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosNulo() throws Exception{
		
		VCadSerie serie = null;
	
		CSerie.receberDados(serie,1);
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{
		
		CSerie.receberDados(serie,1);	
	}
	
	
	
	@Test
	public void testarPanelPadrao()
	{
		assertNotNull(CSerie.getPanelPadrao(panel));
	}
	
	@Test
	public void testarReceberDadosInsercao() throws Exception{
		
		
		
		try{
			CSerie.receberDados(panel, CPadrao.OPERACAO_INSERIR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testarReceberDadosAlterar() throws Exception{
		
		
		CSerie.receberObjetoAlterar(serie);
		
		try{
			CSerie.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}

}