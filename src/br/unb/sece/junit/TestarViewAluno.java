package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.Responsavel;
import br.unb.sece.view.VAluno;

public class TestarViewAluno {
	
	private VAluno VAluno;
	private Aluno aluno;
	private Responsavel responsavel;
	private ArrayList<Responsavel> listaResponsavel;
	
	@Before
	public void setUp()
	{
		VAluno = new VAluno();
		
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
	public void testarInstancia(){
		
		assertNotNull(VAluno);
	}
	
	
}
