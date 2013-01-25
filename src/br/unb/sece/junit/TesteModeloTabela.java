package br.unb.sece.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unb.sece.util.crudpadrao.ModeloDeTabela;

public class TesteModeloTabela {

	@Test
	public void testIsCellEditable() {
		int row = 9;
		int column = 10;
		ModeloDeTabela mdt = new ModeloDeTabela();
		boolean resultado = mdt.isCellEditable(row, column);
		System.out.println("O resultado:" + String.valueOf(resultado));
		assertFalse("Permissao edicao",resultado);
		//fail("Not yet implemented");
	}

	@Test
	public void testModeloDeTabelaStringObjectArrayObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testConstruirTabela() {
		fail("Not yet implemented");
	}

}
