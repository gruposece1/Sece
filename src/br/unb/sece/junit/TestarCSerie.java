package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CDisciplina;
import br.unb.sece.control.CSerie;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Serie;
import br.unb.sece.view.VAluno;
import br.unb.sece.view.VDisciplina;
import br.unb.sece.view.VSerie;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;


//nome, horario, dia, cadastrar, alterar, excluir
public class TestarCSerie {

	private CSerie CSerie;
	private Serie serie, serie2;
	private VSerie panel;
	
	@Before
	public void setUp(){
		CSerie = new CSerie();
		serie = new Serie();
		serie.setNome("gustavo");
		
		panel = new VSerie();
		panel.criarPainel();
		//((VCadCSerie) panel.getPanel()).getTextField().setText("Teste");
		
	}	
	
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(CSerie);
	}
	
	@Test
	public void testarDefinirTituloseMetodos() {
	
		try
		{
			CSerie.definirTitulosEMetodos();	
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}	
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosErrado() throws Exception{
		
		
		serie.setNome("");
		
		CSerie.setSerie(serie);
		
		CSerie.verificarDados();
		
	}
	
	@Test
	public void testarDadosValidos(){
		
		CSerie.setSerie(serie);
		
		try{
			CSerie.verificarDados();	
		}
		catch(Exception e){
			fail("Ocorreu um erro");
		}
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarRecebarDadosNulo() throws Exception{
		Object obj = null;
		
		CSerie.receberDados(obj, CSerie.OPERACAO_INSERIR);
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testarRecebarDadosInvalido() throws Exception{
		
		CSerie.receberDados(serie, CSerie.OPERACAO_INSERIR);
	}
	
	@Test
	public void testarReceberDadosInsercao()
	{
		try{
			CSerie.receberDados(panel, CSerie.OPERACAO_INSERIR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarReceberDadosAlterar(){
		
		CSerie.receberObjetoAlterar(serie);
		
		try{
			CSerie.receberDados(panel, CSerie.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarExclusao(){
		
		try {
			CSerie.excluir(serie);
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarSalvar(){

	
		try {
			CSerie.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarModeloTabela(){
		
		try{
			CSerie.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}

	}	
	
	
	
}
