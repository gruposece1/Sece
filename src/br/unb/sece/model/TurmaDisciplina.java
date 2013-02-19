package br.unb.sece.model;

import java.util.List;

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

import br.unb.sece.model.DAO.TurmaDisciplinaDAO;

@Entity
public class TurmaDisciplina {
	@Id
	@GeneratedValue
	private Long idTurmaDisciplina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Disciplina disciplina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurma", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Turma turma;

	public Long getIdTurmaDisciplina() {
		return idTurmaDisciplina;
	}

	public void setIdTurmaDisciplina(Long idTurmaDisciplina) {
		this.idTurmaDisciplina = idTurmaDisciplina;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public void salvar(){
		TurmaDisciplinaDAO dao = new TurmaDisciplinaDAO();
		dao.save(this);
	}
	
	public void salvar(Session session){
		TurmaDisciplinaDAO dao = new TurmaDisciplinaDAO();
		dao.save(this,session);
	}
	
	
	public static List<Disciplina> getDisciplinas(Turma turma){
		TurmaDisciplinaDAO dao = new TurmaDisciplinaDAO();
		return dao.getDisciplinasTurma(turma.getIdTurma());
	}
	
	public static List<TurmaDisciplina> getTurmasDisciplina(Turma turma){
		TurmaDisciplinaDAO dao = new TurmaDisciplinaDAO();
		return dao.getTurmasDisciplina(turma);
	}

}
