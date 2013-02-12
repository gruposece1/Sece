/**
 * 
 */
package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unb.sece.control.CAluno;
import br.unb.sece.control.CSerie;
import br.unb.sece.control.CTurno;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Turno;
import br.unb.sece.view.VAluno;
import br.unb.sece.view.VTurno;
import br.unb.sece.view.panelcadastropadrao.VCadTurno;

//nome, horario, dia, cadastrar, alterar, excluir
public class TesteCTurno {
	
	private CTurno CTurno;
	private Turno turno;
	private VTurno panel;

	@Before
	public void setUp(){
		
		CTurno = new CTurno();
		
		turno = new Turno();
		turno.setInicio(8);
		turno.setFim(12);
		turno.setTurno("Vespertino");
		
		panel = new VTurno();
		panel.criarPainel();
		
		
		
	}
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(CTurno);
	}
	

	@Test
	public void testDefinirTitulosEMetodos() {
		try
		{
			CTurno.definirTitulosEMetodos();	
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}	
	}

	@Test (expected= AtributoNuloException.class)
	public void testarDadosErrado() throws Exception{
		
		
		turno.setInicio(0);
		turno.setInicio(0);
		
		CTurno.setTurno(turno);
		
		CTurno.verificarDados();
		
	}
	
	
	@Test
	public void testarDadosValidos(){
		
		CTurno.setTurno(turno);
		
		try{
			CTurno.verificarDados();	
		}
		catch(Exception e){
			fail("Ocorreu um erro");
		}
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarRecebarDadosNulo() throws Exception{
		Object obj = null;
		
		CTurno.receberDados(obj, CTurno.OPERACAO_INSERIR);
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testarRecebarDadosInvalido() throws Exception{
		
		CTurno.receberDados(turno, CTurno.OPERACAO_INSERIR);
	}
	
	@Test
	public void testarReceberDadosInsercao()
	{
		try{
			CTurno.receberDados(panel, CTurno.OPERACAO_INSERIR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarReceberDadosAlterar(){
		
		CTurno.receberObjetoAlterar(turno);
		
		try{
			CTurno.receberDados(panel, CTurno.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarExclusao(){
		
		try {
			CTurno.excluir(turno);
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarSalvar(){

	
		try {
			CTurno.salvar();
		} catch (Exception e) {
			fail("Ocorreu erro");
		}
	}
	
	@Test
	public void testarModeloTabela(){
		
		try{
			CTurno.getDefaultTableModel();
		}
		catch(Exception e) {
			fail("Ocorreu erro");
		}

	}	
	
	
	
}

	
	