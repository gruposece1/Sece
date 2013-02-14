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

	private CProfessor CProfessor;
	private Professor professor;
	private VProfessor panel;
	

	@Before
	public void setUp(){
		
		CProfessor = new CProfessor();
		professor = new professor(); 
		
		
		/*
		professor.setCpf("23453543");
		professor.setNome("Funcionario");
		professor.setSenha("Senha");
		professor.setSexo("Sexo");
		professor.setTipoFuncionario("Cargo");
		professor.setTelefone("Telefone"); */
	
		panel = new VProfessor();
		panel.criarPainel();
		((VCadProfessor) panel.getPanel()).getTxtNome().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtTelefone().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtCPF().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtSenha().setText("Teste"); 
	}	
	
	@Test
	public void testarInstancia() {

		assertNotNull(CProfessor);
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{
		
		professor.setNome("");
		
		CProfessor.setFuncionario(funcionario);
		
		CProfessor.verificarDados(); 
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosCPF() throws Exception{
		
		
		professor.setCpf("");
		
		CProfessor.setFuncionario(professor);
		
		CProfessor.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosTelefone() throws Exception{
		
		
		professor.setTelefone("");
		
		CProfessor.setFuncionario(funcionario);
		
		CProfessor.verificarDados();
		
		
	}
	
	@Test
	public void testarDadosValidos(){
		
		CProfessor.setProfessor(professor);
		
		try {
			CProfessor.verificarDados();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}

	@Test
	public void testarExclusao(){
		
		try {
			CProfessor.excluir(funcionario);
		} catch (Exception e) {
			fail("Ocorreu erro");
			//e.printStackTrace();
		}
		
	}
	
	@Test
	public void testarSalvar(){
		
		try {
			CProfessor.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
		
		
		
	}
	
	@Test
	public void testarModeloTabela(){
		
		try
		{
			CProfessor.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}
		
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosNulo() throws Exception{
		
	
		VCadProfessor professor = null;
		
		CProfessor.receberDados(professor, 1);
		
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{
		
		CProfessor.receberDados(professor, 1);
		
	}
	
	@Test
	public void testarPanelPadrao(){
		 assertNotNull(CProfessor.getPanelPadrao(panel));
	}
	
	@Test
	public void testarReceberDadosInsercao() throws Exception{
		
		try{
			CProfessor.receberDados(panel, CPadrao.OPERACAO_INSERIR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testarReceberDadosAlterar() throws Exception{

		CProfessor.receberObjetoAlterar(professor);
		
		try{
			CProfessor.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}

}
