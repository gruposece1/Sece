package br.unb.sece.model;

import java.util.List;

import javax.persistence.Entity;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.FuncionarioDAO;

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
	
	public void salvar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.save(this);
	}
	
	public void excluir() throws BancoDeDadosException{
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.remove(this);
	}
	
	public  List getAll(){
		FuncionarioDAO dao = new FuncionarioDAO();
		
		return dao.listAll(Funcionario.class);
	
	}

}
