package br.unb.sece.model;

public class Usuario {

	private String nome, senha;
	
	public Usuario(String nome, String senha)
	{
		setNome(nome);
		setSenha(senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verificarLogin()
	{
		if(nome.equals("Sece") && senha.equals("1"))
			return true;
		
		else
			return false;
	}
	
	
	
}
