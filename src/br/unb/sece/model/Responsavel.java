package br.unb.sece.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import br.unb.sece.model.DAO.ResponsavelDAO;

@Entity
public class Responsavel extends Pessoa
{
	
	private String telefone, endereco, CEP, email;
	
	public Responsavel()
	{
		
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List getAll(){
		ResponsavelDAO dao = new ResponsavelDAO();
		List<Responsavel> lista = new ArrayList(dao.listAll(Responsavel.class));
		return lista;
	}
	
}
