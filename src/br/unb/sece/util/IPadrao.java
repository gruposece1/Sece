package br.unb.sece.util;

public interface IPadrao {

	public void salvar();
	public void excluir();
	public void alterar();
	
	public void passarDados() throws Exception;
}
