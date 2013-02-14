package br.unb.sece.model;

public class Usuario {

	private String nome;
	private String senha;
	
	public Usuario(String nome, String senha) {
		setNome(nome);
		setSenha(senha);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean verificarLogin() {
		if(this.nome.equals("Sece") && this.senha.equals("1"))
			return true;		
		else
			return false;
	}
	
}
