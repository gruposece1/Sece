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
import br.unb.sece.view.panelcadastropadrao.VCadFuncionario;

public class TesteCProfessor {

	private CFuncionario CFuncionario;
	private Funcionario funcionario;
	private VFuncionario panel;
	
	/*
	private CProfessor CProfessor;
	private Professor professor;
	private VProfessor panel;
	*/
	
	@Before
	public void setUp(){
		
		CFuncionario = new CFuncionario();
		funcionario = new Funcionario();
		
		/*
		CProfessor = new CProfessor();
		professor = new professor(); */
		
		funcionario.setCpf("23453543");
		funcionario.setNome("Funcionario");
		funcionario.setSenha("Senha");
		funcionario.setSexo("Sexo");
		funcionario.setTipoFuncionario("Cargo");
		funcionario.setTelefone("Telefone");
		
		/*
		professor.setCpf("23453543");
		professor.setNome("Funcionario");
		professor.setSenha("Senha");
		professor.setSexo("Sexo");
		professor.setTipoFuncionario("Cargo");
		professor.setTelefone("Telefone"); */
	
		
		panel = new VFuncionario();
		panel.criarPainel();
		((VCadFuncionario) panel.getPanel()).getTxtNome().setText("Teste");
		((VCadFuncionario) panel.getPanel()).getTxtTelefone().setText("Teste");
		((VCadFuncionario) panel.getPanel()).getTxtCPF().setText("Teste");
		((VCadFuncionario) panel.getPanel()).getTxtSenha().setText("Teste");
		
		/*
		panel = new VProfessor();
		panel.criarPainel();
		((VCadProfessor) panel.getPanel()).getTxtNome().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtTelefone().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtCPF().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtSenha().setText("Teste"); */
	}	
	
	@Test
	public void testarInstancia() {

		assertNotNull(CFuncionario);
		//assertNotNull(CProfessor);
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{
		
		
		funcionario.setNome("");
		
		CFuncionario.setFuncionario(funcionario);
		
		CFuncionario.verificarDados();
		
		/*
		professor.setNome("");
		
		CProfessor.setFuncionario(funcionario);
		
		CProfessor.verificarDados(); */
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosCPF() throws Exception{
		
		
		funcionario.setCpf("");
		
		CFuncionario.setFuncionario(funcionario);
		
		CFuncionario.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosTelefone() throws Exception{
		
		
		funcionario.setTelefone("");
		
		CFuncionario.setFuncionario(funcionario);
		
		CFuncionario.verificarDados();
		
		/*
		professor.setTelefone("");
		
		CProfessor.setFuncionario(funcionario);
		
		CProfessor.verificarDados();
		*/
		
	}
	
	@Test
	public void testarDadosValidos(){
		
		CFuncionario.setFuncionario(funcionario);
		//CProfessor.setProfessor(professor);
		
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
		
		/*
		try {
			CProfessor.excluir(professor);
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
		
		*/
	}
	
	@Test
	public void testarSalvar(){
		
		try {
			CFuncionario.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
		
		/*
		try {
			CProfessor.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
		*/
		
		
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
		
		/*
		try
		{
			CProfessor.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}
		*/
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosNulo() throws Exception{
		
		VCadFuncionario funcionario = null;
		
		CFuncionario.receberDados(funcionario, 1);
		
		/*
		VCadProfessor professor = null;
		
		CProfessor.receberDados(professor, 1);
		*/
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{
		
		
		CFuncionario.receberDados(funcionario, 1);
		//CProfessor.receberDados(professor, 1);
		
	}
	
	@Test
	public void testarPanelPadrao(){
		assertNotNull(CFuncionario.getPanelPadrao(panel));
		// assertNotNull(CProfessor.getPanelPadrao(panel));
	}
	
	@Test
	public void testarReceberDadosInsercao() throws Exception{
		
		try{
			CFuncionario.receberDados(panel, CPadrao.OPERACAO_INSERIR);
			//CProfessor.receberDados(panel, CPadrao.OPERACAO_INSERIR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testarReceberDadosAlterar() throws Exception{
		
		
		CFuncionario.receberObjetoAlterar(funcionario);
		//CProfessor.receberObjetoAlterar(professor);
		
		try{
			CFuncionario.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
			//CProfessor.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}

}
