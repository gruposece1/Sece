package br.unb.sece.model;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.AlunoDAO;
import br.unb.sece.model.DAO.FuncionarioDAO;
import br.unb.sece.model.DAO.ResponsavelDAO;
import br.unb.sece.model.DAO.SerieDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Responsavel extends Pessoa
{
	
	private String telefone;
	private String endereco;
	private String CEP;
	private String email;
	
	public Responsavel() {
		
	}
	

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCEP() {
		return this.CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public List getAll(){
		//Colecoes colecao = new Colecoes();
		final ResponsavelDAO dao = new ResponsavelDAO();
		
		return dao.listAll(Responsavel.class);

	}
	
	public void salvar(){
		final ResponsavelDAO dao = new ResponsavelDAO();
		dao.save(this);
	}

	public void alterar(){
		final SerieDAO dao = new SerieDAO();
		
		dao.update(this);
	}
	
	public void excluir() throws BancoDeDadosException {
		final ResponsavelDAO dao = new ResponsavelDAO();
		dao.remove(this);
	}


	
	
}
