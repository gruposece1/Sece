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
import br.unb.sece.control.CPadrao;
import br.unb.sece.control.CSerie;
import br.unb.sece.control.CTurno;
import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turno;
import br.unb.sece.view.VSerie;
import br.unb.sece.view.VTurno;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;
import br.unb.sece.view.panelcadastropadrao.VCadTurno;

public class TesteControleTurno {
	
	private CTurno CTurno;
	private Turno turno;
	private VTurno panel;

	@Before
	public void setUp(){
		
		CTurno = new CTurno();
		
		turno = new Turno();
		turno.setInicio(1);
		turno.setFim(2);
		turno.setTurno("Vespertino");
		
		panel = new VTurno();
		panel.criarPainel();
		((VCadTurno) panel.getPanel()).getTxtInicio().setText("1");
		((VCadTurno) panel.getPanel()).getTxtFim().setText("2");
		((VCadTurno) panel.getPanel()).getCBTipo().setSelectedIndex(CTurno.getIndiceTurno(turno.getTurno()));
		
		
	}
	
	@Test
	public void testarInstancia(){
		
		assertNotNull(CTurno); // ok!
	}
	

	@Test
	public void testDefinirTitulosEMetodos() {
		try
		{
			CTurno.definirTitulosEMetodos();	// ok ! 
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}	
	}

	@Test (expected= AtributoNuloException.class)
	public void testarDadosInicioErrado() throws Exception{ // FALTAAAAAAA
		
		
		turno.setInicio(0);
		
		CTurno.setTurno(turno);
		
		CTurno.verificarDados();
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarDadosFimErrado() throws Exception{ // FALTAAAAAAA
		
		
		turno.setFim(0);
		
		CTurno.setTurno(turno);
		
		CTurno.verificarDados();
		
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testarDadosFimIgualInicio() throws Exception{ // FALTAAAAAAA
		
		
		turno.setFim(1);
		turno.setInicio(1);
		
		CTurno.setTurno(turno);
		
		CTurno.verificarDados();
		
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testarDadosInicioMaiorFim() throws Exception{ // FALTAAAAAAA
		
		
		turno.setFim(1);
		turno.setInicio(1);
		
		CTurno.setTurno(turno);
		
		CTurno.verificarDados();
		
	}
	
	
	@Test
	public void testarDadosValidos(){ // ok! 
		
		CTurno.setTurno(turno);
		
		try{
			CTurno.verificarDados();	
		}
		catch(Exception e){
			fail("Ocorreu um erro");
		}
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testarReceberDadosNulo() throws Exception{ // FAAAAAALTA
		Object obj = null;
		
		CTurno.receberDados(obj, CTurno.OPERACAO_INSERIR);
		
	}
	
	@Test (expected= AtributoInvalidoException.class)
	public void testarReceberDadosInvalido() throws Exception{//FAAAAAAALTA
		
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
	public void testarReceberDadosAlterar() throws Exception{
		
		CTurno.receberObjetoAlterar(turno);
		
		
		try{
			CTurno.receberDados(panel, CTurno.OPERACAO_ALTERAR);
		}
		catch(Exception e){
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	

	@Test
	public void testarExclusao(){
		
		try {
			CTurno.excluir(turno);
		} catch (Exception e) {
			fail("Ocorreu erro");
			//e.printStackTrace();
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

	
	