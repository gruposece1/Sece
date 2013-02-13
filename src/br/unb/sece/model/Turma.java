package br.unb.sece.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.Session;
import org.hibernate.annotations.*;

import br.unb.sece.model.DAO.TurmaDAO;
import br.unb.sece.util.HibernateUtil;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long idTurma;
	
	@Column(name="nomeTurma")
	private String nomeTurma;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idSerie", insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Serie serie;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurno", insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.LOCK)
	private Turno turno;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="turmaaluno", schema="sece", joinColumns={@JoinColumn(name="idTurma")},	inverseJoinColumns={@JoinColumn(name="idPessoa")})
	@Cascade(CascadeType.LOCK)
	private Collection<Aluno> aluno = new ArrayList<Aluno>();
	
	

	
	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public Collection<Aluno> getAluno() {
		return aluno;
	}
	
	public ArrayList<Aluno> getAlunos(){
		return (ArrayList)this.aluno;
	}

	public void setAluno(Collection<Aluno> aluno) {
		this.aluno = aluno;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	
	
	public static List getAll(){
		TurmaDAO dao = new TurmaDAO();
		List<Object> lista = dao.listAll(Turma.class);
		return lista;
	}
	
	public void salvar(){
		TurmaDAO dao = new TurmaDAO();
		dao.save(this);
	}
	
	public void salvar(Session session){
		TurmaDAO dao = new TurmaDAO(session);
		//dao.close();
		System.out.println("O id: " + this.getSerie().getIdSerie());
		System.out.println("O id turno: " + this.getTurno().getId());
		dao.save((Turma)this, session);
		
	}
	
	public void alterar(){
		TurmaDAO dao = new TurmaDAO();
		
		dao.update(this);
	}
	
	
	
	
	
	

}
