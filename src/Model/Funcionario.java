package Model;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa{
	
	private String telefone, CPF, senha, tipoFuncionario;
	
	public Funcionario()
	{
		
	}
	
	public Funcionario (String tipo)
	{
		this.tipoFuncionario = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	
	

}
