package br.unb.sece.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class TurmaAluno {
	@Id
	@GeneratedValue
	private Long idTurmaAluno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idPessoa", insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Aluno aluno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurma", insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Turma turma;

	public Long getIdTurmaAluno() {
		return idTurmaAluno;
	}

	public void setIdTurmaAluno(Long idTurmaAluno) {
		this.idTurmaAluno = idTurmaAluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

}
