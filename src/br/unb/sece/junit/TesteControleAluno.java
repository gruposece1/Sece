package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CAluno;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Responsavel;

public class TesteControleAluno {

	private CAluno CAluno;
	private Aluno aluno;
	private Responsavel responsavel;
	ArrayList<Responsavel> listaResponsavel;
	
	@Before
	public void setUp(){
		
		CAluno = new CAluno();
		aluno = new Aluno();
		responsavel = new Responsavel();
		
		listaResponsavel = new ArrayList<Responsavel>();
		
		responsavel.setCEP("213453");
		responsavel.setCPF("123432");
		
		listaResponsavel.add(responsavel);
		
		aluno = new Aluno();
		aluno.setNome("dasdsa");
		aluno.setDtNascimento("11/09/2005");
		aluno.setMatricula("1234");
		aluno.setSexo("Masculino");
		aluno.setResponsaveis(listaResponsavel);
		
	}
	
	@Test
	public void testarObjeto() {
		
		assertNotNull(CAluno);
	}

	@Test (expected= AtributoNuloException.class)
	public void testarDadosNome() throws Exception{
		
		
		aluno.setNome("");
		
		CAluno = new CAluno();
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosMatricula() throws Exception{
		
		
		aluno.setMatricula("");
		
		CAluno = new CAluno();
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosNascimento() throws Exception{
		
		
		aluno.setDtNascimento("");
		
		CAluno = new CAluno();
		CAluno.setAluno(aluno);
		
		CAluno.verificarDados();
		
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosResponsaveis() throws Exception{
		
		ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
		
		responsaveis = listaResponsavel;
		
		responsaveis.clear();
		
		aluno.setResponsaveis(responsaveis);
		
		CAluno = new CAluno();
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
		
		CAluno = new CAluno();
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
			CAluno.excluir();
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
	
}
