package br.unb.sece.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.unb.sece.model.DAO.SerieDao;
import br.unb.sece.model.DAO.TurnoDAO;
import br.unb.sece.util.HibernateUtil;

import teste.Colecoes;

@Entity
public class Turno {
	
	public static final String MANHA = "Manha";
	public static final String TARDE = "Tarde";
	
	@Id
	@GeneratedValue
	private Long id;
	
	private float inicio, fim;
	private String turno;
	
	public Turno()
	{
		
	}
	
	public Turno(float inicio, float fim, String turno) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.turno = turno;
	}

	public float getInicio() {
		return inicio;
	}
	public void setInicio(float inicio) {
		this.inicio = inicio;
	}
	public float getFim() {
		return fim;
	}
	public void setFim(float fim) {
		this.fim = fim;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List getAll(){

		TurnoDAO dao = new TurnoDAO();
		
		return dao.listAll(Turno.class);

	}
	
	public void salvar(){
		TurnoDAO dao = new TurnoDAO();
		dao.save(this);
	}
	
}
