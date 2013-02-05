package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unb.sece.util.crudpadrao.ModeloDeTabela;

public class TesteModeloTabela {

	private ModeloDeTabela mdt = new ModeloDeTabela();
	@Test
	public void testIsCellEditable() {
		int row = 9;
		int column = 10;
		boolean resultado = mdt.isCellEditable(row, column);
		assertFalse("Permissao edicao",resultado);
		//fail("Not yet implemented");
	}

	@Test
	public void testModeloDeTabelaStringObjectArrayObjectArray() {
		//fail("Not yet implemented");
	}

	@Test
	public void testConstruirTabela() {
		String classeModel = "br.unb.sece.model.Serie";
		
		String titulos[] = {"Nome","Qtde Horários","Qtde Dias"};
		
		String metodos[] = {"getNome","getQtdeHorarios","getQteDias"};
		
		ModeloDeTabela mdt = new ModeloDeTabela(classeModel, titulos, metodos);
		
		assertNotNull(mdt.getDados());
		
		//fail("Not yet implemented");
	}
	
	
	@Test
	public void testGetObjetoTabelaDadosNulo(){
		int row = 3;
		int column = 1;
		mdt = new ModeloDeTabela();
		try{
			Object retorno = mdt.getObjetoTabela(row, column);
			fail("Deveria retorna uma excecao");
		}catch(NullPointerException ex){
			
		}
		
		
	}
	
	@Test
	public void testGetObjetoTabelaDadosNotNull(){
		int row = 2;
		int column = 1;
		
		String classeModel = "br.unb.sece.model.Serie";
		
		String titulos[] = {"Nome","Qtde Horários","Qtde Dias"};
		
		String metodos[] = {"getNome","getQtdeHorarios","getQteDias"};
		
		mdt = new ModeloDeTabela(classeModel, titulos, metodos);
		try{
			Object retorno = mdt.getObjetoTabela(row,metodos.length );
			assertNotNull(retorno);
		}catch(NullPointerException ex){
			ex.printStackTrace();
			fail("Nao deveria retornar excecao");
		}
		
		
	}
	

}
