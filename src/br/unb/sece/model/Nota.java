package br.unb.sece.model;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.unb.sece.model.DAO.NotaDAO;
import br.unb.sece.model.DAO.TurmaDAO;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue
	private Long idNota;
	
	
	private String descNota;


	public Long getIdNota() {
		return idNota;
	}


	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}


	public String getDescNota() {
		return descNota;
	}


	public void setDescNota(String descNota) {
		this.descNota = descNota;
	}
	
	
	public void salvar(Session session) {
		final NotaDAO dao = new NotaDAO();
		
		dao.save(this, session);
		
	}
	
	public void salvar() {
		final NotaDAO dao = new NotaDAO();
		
		dao.save(this);
		
	}
	
	public static Nota getNota(){
		final NotaDAO dao = new NotaDAO();
		return dao.getNota();
	}
	
}
