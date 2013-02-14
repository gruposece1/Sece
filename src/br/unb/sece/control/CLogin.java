package br.unb.sece.control;

import br.unb.sece.model.Usuario;

public class CLogin {
	
	private Usuario usuario;
	private boolean temPermissao = false;
	
	public void passarDados(String nome, String login)
	{
		this.usuario = new Usuario(nome, login);
		this.temPermissao=usuario.verificarLogin();
	}
	
	public boolean getVerificar()
	{
		return temPermissao;
	}

}
