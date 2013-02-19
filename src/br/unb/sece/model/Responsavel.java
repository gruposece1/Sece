package br.unb.sece.model;

import br.unb.sece.model.DAO.ResponsavelDAO;

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
	
	public List getAll() {
		final ResponsavelDAO dao = new ResponsavelDAO();
		final List<Responsavel> lista = new ArrayList(dao.listAll(Responsavel.class));
		
		return lista;
	}
	
	public void salvar(){
		final ResponsavelDAO dao = new ResponsavelDAO();
		dao.save(this);
	}

	public void alterar() {
		// TODO Auto-generated method stub
		
	}

	public void excluir() {
		// TODO Auto-generated method stub
		
	}


	
	
}
