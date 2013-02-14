package br.unb.sece.model;


import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.FuncionarioDAO;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa{
	
	private String telefone;
	private String senha; 
	private String tipoFuncionario;
	
	public Funcionario() {
		
	}
	
	public Funcionario (String tipo) {
		this.tipoFuncionario = tipo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoFuncionario() {
		return this.tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	
	public void salvar() {
		final FuncionarioDAO dao = new FuncionarioDAO();
		dao.save(this);
	}
	
	public void excluir() throws BancoDeDadosException {
		final FuncionarioDAO dao = new FuncionarioDAO();
		dao.remove(this);
	}
	
	public  List getAll() {
		final FuncionarioDAO dao = new FuncionarioDAO();
		
		return dao.listAll(Funcionario.class);
	}
	
	public List<Funcionario> listCordenadoresSecretarias(){
		final FuncionarioDAO dao = new FuncionarioDAO();
		return dao.listCordenadoresSecretarias();
		
	}

}
