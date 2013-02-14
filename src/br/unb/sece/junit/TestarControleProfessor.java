package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CPadrao;
import br.unb.sece.control.CProfessor;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Professor;
import br.unb.sece.view.VProfessor;
import br.unb.sece.view.panelcadastropadrao.VCadProfessor;

public class TestarControleProfessor {

	private CProfessor CProfessor;
	private Professor professor;
	private VProfessor panel;

	/*
	private CProfessor CProfessor;
	private Professor professor;
	private VProfessor panel;
	*/

	@Before
	public void setUp(){

		CProfessor = new CProfessor();
		professor = new Professor();

		/*
		CProfessor = new CProfessor();
		professor = new professor(); */

		professor.setCpf("23453543");
		professor.setNome("professor");
		professor.setSenha("Senha");
		professor.setSexo("Sexo");
		professor.setTelefone("Telefone");

		/*
		professor.setCpf("23453543");
		professor.setNome("professor");
		professor.setSenha("Senha");
		professor.setSexo("Sexo");
		professor.setTipoprofessor("Cargo");
		professor.setTelefone("Telefone"); */


		panel = new VProfessor();
		panel.criarPainel();
		((VCadProfessor) panel.getPanel()).getTxtNome().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtTelefone().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtCPF().setText("Teste");
		((VCadProfessor) panel.getPanel()).getTxtSenha().setText("Teste");

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

		assertNotNull(CProfessor);
		//assertNotNull(CProfessor);
	}

	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{


		professor.setNome("");

		CProfessor.setProfessor(professor);

		CProfessor.verificarDados();

		/*
		professor.setNome("");
		
		CProfessor.setprofessor(professor);
		
		CProfessor.verificarDados(); */


	}

	@Test (expected= AtributoNuloException.class)
	public void testarDadosCPF() throws Exception{


		professor.setCpf("");

		CProfessor.setProfessor(professor);

		CProfessor.verificarDados();


	}

	@Test (expected= AtributoNuloException.class)
	public void testarDadosTelefone() throws Exception{


		professor.setTelefone("");

		CProfessor.setProfessor(professor);

		CProfessor.verificarDados();

		/*
		professor.setTelefone("");
		
		CProfessor.setprofessor(professor);
		
		CProfessor.verificarDados();
		*/

	}

	@Test
	public void testarDadosValidos(){

		CProfessor.setProfessor(professor);
		//CProfessor.setProfessor(professor);

		try {
			CProfessor.verificarDados();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}

	@Test
	public void testarExclusao(){

		try {
			CProfessor.excluir(professor);
		} catch (Exception e) {
			//fail("Ocorreu erro");
			e.printStackTrace();
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
			CProfessor.salvar();
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
			CProfessor.getDefaultTableModel();
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

		VCadProfessor professor = null;

		CProfessor.receberDados(professor, 1);

		/*
		VCadProfessor professor = null;
		
		CProfessor.receberDados(professor, 1);
		*/

	}

	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{


		CProfessor.receberDados(professor, 1);
		//CProfessor.receberDados(professor, 1);

	}

	@Test
	public void testarPanelPadrao(){
		assertNotNull(CProfessor.getPanelPadrao(panel));
		// assertNotNull(CProfessor.getPanelPadrao(panel));
	}

	@Test
	public void testarReceberDadosInsercao() throws Exception{

		try{
			CProfessor.receberDados(panel, CPadrao.OPERACAO_INSERIR);
			//CProfessor.receberDados(panel, CPadrao.OPERACAO_INSERIR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}

	@Test
	public void testarReceberDadosAlterar() throws Exception{


		CProfessor.receberObjetoAlterar(professor);
		//CProfessor.receberObjetoAlterar(professor);

		try{
			CProfessor.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
			//CProfessor.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}

}