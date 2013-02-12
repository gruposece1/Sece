package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CAluno;
import br.unb.sece.control.CPadrao;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Responsavel;
import br.unb.sece.view.VAluno;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;

public class TesteControleAluno {

	private CAluno CAluno;
	private Aluno aluno;
	private Responsavel responsavel;
	private ArrayList<Responsavel> listaResponsavel;
	private VAluno panel;
	
	@Before
	public void setUp(){
		
		CAluno = new CAluno();
		aluno = new Aluno();
		responsavel = new Responsavel();
		
		listaResponsavel = new ArrayList<Responsavel>();
		
		responsavel.setCEP("213453");
		responsavel.setCpf("123432");
		
		listaResponsavel.add(responsavel);
		
		aluno = new Aluno();
		aluno.setNome("dasdsa");
		aluno.setDtNascimento("11/09/2005");
		aluno.setMatricula("1234");
		aluno.setSexo("Masculino");
		aluno.setResponsaveis(listaResponsavel);
		
		panel = new VAluno();
		panel.criarPainel();
		((VCadAluno) panel.getPanel()).getTxtNome().setText("Teste");
		((VCadAluno) panel.getPanel()).getTxtMatricula().setText("Teste");
		((VCadAluno) panel.getPanel()).getTxtNascimento().setText("Teste");
		((VCadAluno) panel.getPanel()).setResponsavel(listaResponsavel);
		
	}
	
	@Test
	public void testarObjeto() {
		
		assertNotNull(CAluno);
	}

	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{
		
		
		aluno.setNome("");
		
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosMatricula() throws Exception{
		
		
		aluno.setMatricula("");
		
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosNascimento() throws Exception{
		
		
		aluno.setDtNascimento("");
		
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosResponsaveis() throws Exception{
		
		ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
		
		responsaveis = listaResponsavel;
		
		responsaveis.clear();
		
		aluno.setResponsaveis(responsaveis);
		
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testarNumeroResponsaveis() throws Exception{
		
		ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
		
		responsaveis = listaResponsavel;
		
		Responsavel responsavel = new Responsavel();
				
		responsaveis.add(responsavel);
		responsaveis.add(responsavel);
		
		aluno.setResponsaveis(responsaveis);
		
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
	}
	
	@Test
	public void testarNomeColunas(){
		
		assertNotNull(CAluno.gerarNomeColunas());
	}
	
	@Test
	public void testarDadosValidos(){
		
		CAluno.setAluno(aluno);
		
		try {
			CAluno.verificarDados();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}

	@Test
	public void testarExclusao(){
		
		try {
			CAluno.excluir(aluno);
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarSalvar(){
		
		try {
			CAluno.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarModeloTabela(){
		
		try
		{
			CAluno.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosNulo() throws Exception{
		
		VCadAluno aluno = null;
		
		CAluno.receberDados(aluno, 1);
		
	}
	
	@Test (expected = AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{
		
		
		CAluno.receberDados(aluno, 1);
		
	}
	
	@Test
	public void testarPanelPadrao()
	{
		assertNotNull(CAluno.getPanelPadrao(panel));
	}
	
	@Test
	public void testarReceberDadosInsercao() throws Exception{
		
		
		
		try
		{
			CAluno.receberDados(panel, CPadrao.OPERACAO_INSERIR);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testarReceberDadosAlterar() throws Exception{
		
		
		CAluno.receberObjetoAlterar(aluno);
		
		try
		{
			CAluno.receberDados(panel, CPadrao.OPERACAO_ALTERAR);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
}
