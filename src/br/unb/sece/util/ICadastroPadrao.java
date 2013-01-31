package br.unb.sece.util;

import br.unb.sece.exceptions.BancoDeDadosException;

public interface ICadastroPadrao extends IPadrao {

	public void verificarDados() throws Exception;

	void excluir(Object obj) throws BancoDeDadosException; 

}
