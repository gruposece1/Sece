package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CDisciplina;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.view.VAluno;
import br.unb.sece.view.VDisciplina;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;

public class TestarControleDisciplina {

	private CDisciplina CDisciplina;
	private Disciplina disciplina, disciplina2;
	private VDisciplina panel;
	
	@Before
	public void setUp(){
		
		CDisciplina = new CDisciplina();
		
		disciplina = new Disciplina();
		disciplina.setNome("Filosofia");
		
		panel = new VDisciplina();
		panel.criarPainel();
		((VCadDisciplina) panel.getPanel()).getTextField().setText("Teste");
		
	}	
		
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(CDisciplina);
	}
	
	@Test
	public void testarDefinirTituloseMetodos() {
	
		try
		{
			CDisciplina.definirTitulosEMetodos();	
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}	
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosErrado() throws Exception{
		
		
		disciplina.setNome("");
		
		CDisciplina.setDisciplina(disciplina);
		
		CDisciplina.verificarDados();
		
	}
	
	@Test
	public void testarDadosValidos()
	{
		
		CDisciplina.setDisciplina(disciplina);
		
		try
		{
			CDisciplina.verificarDados();	
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarRecebarDadosNulo() throws Exception
	{
		Object obj = null;
		
		CDisciplina.receberDados(obj, CDisciplina.OPERACAO_INSERIR);
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testarRecebarDadosInvalido() throws Exception
	{
		
		CDisciplina.receberDados(disciplina, CDisciplina.OPERACAO_INSERIR);
	}
	
	@Test
	public void testarReceberDadosInsercao()
	{
		try
		{
			CDisciplina.receberDados(panel, CDisciplina.OPERACAO_INSERIR);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarReceberDadosAlterar()
	{
		
		CDisciplina.receberObjetoAlterar(disciplina);
		
		try
		{
			CDisciplina.receberDados(panel, CDisciplina.OPERACAO_ALTERAR);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarExclusao(){
		
		try {
			CDisciplina.excluir(disciplina);
		} catch (Exception e) {
			//fail("Ocorreu erro");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testarSalvar(){

	
		try {
			CDisciplina.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarModeloTabela(){
		
		try
		{
			CDisciplina.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}

	}	
	
	
	
}
