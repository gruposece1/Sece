package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CFuncionario;
import br.unb.sece.control.CPadrao;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Funcionario;
import br.unb.sece.view.VFuncionario;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;
import br.unb.sece.view.panelcadastropadrao.VCadFuncionario;

public class TesteControleFuncionario {

	private CFuncionario CFuncionario;
	private Funcionario funcionario;
	private VFuncionario panel;
	
	@Before
	public void setUp(){
		
		CFuncionario = new CFuncionario();
		funcionario = new Funcionario();
		
		funcionario.setCPF("23453543");
		funcionario.setNome("Funcionario");
		funcionario.setSenha("Senha");
		funcionario.setSexo("Sexo");
		funcionario.setTipoFuncionario("Cargo");
		funcionario.setTelefone("Telefone");
		
		panel = new VFuncionario();
		panel.criarPainel();
		((VCadFuncionario) panel.getPanel()).getTxtNome().setText("Teste");
		((VCadFuncionario) panel.getPanel()).getTxtTelefone().setText("Teste");
		((VCadFuncionario) panel.getPanel()).getTxtCPF().setText("Teste");
		((VCadFuncionario) panel.getPanel()).getTxtSenha().setText("Teste");
	}	
	
	@Test
	public void testarInstancia() {

		assertNotNull(CFuncionario);
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{
		
		
		funcionario.setNome("");
		
		CFuncionario.setFuncionario(funcionario);
		
		CFuncionario.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosCPF() throws Exception{
		
		
		funcionario.setCPF("");
		
		CFuncionario.setFuncionario(funcionario);
		
		CFuncionario.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosTelefone() throws Exception{
		
		
		funcionario.setTelefone("");
		
		CFuncionario.setFuncionario(funcionario);
		
		CFuncionario.verificarDados();
		
		
	}
	
	@Test
	public void testarDadosValidos(){
		
		CFuncionario.setFuncionario(funcionario);
		
		try {
			CFuncionario.verificarDados();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}

	@Test
	public void testarExclusao(){
		
		try {
			CFuncionario.excluir(funcionario);
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarSalvar(){
		
		try {
			CFuncionario.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarModeloTabela(){
		
		try
		{
			CFuncionario.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosNulo() throws Exception{
		
		VCadFuncionario funcionario = null;
		
		CFuncionario.receberDados(funcionario, 1);
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{
		
		
		CFuncionario.receberDados(funcionario, 1);
		
	}
	
	@Test
	public void testarPanelPadrao()
	{
		assertNotNull(CFuncionario.getPanelPadrao(panel));
	}
	
	@Test
	public void testarReceberDadosInsercao() throws Exception{
		
		
		
		try
		{
			CFuncionario.receberDados(panel, CPadrao.OPERACAO_INSERIR);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testarReceberDadosAlterar() throws Exception{
		
		
		CFuncionario.receberObjetoAlterar(funcionario);
		
		try
		{
			CFuncionario.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}

}
