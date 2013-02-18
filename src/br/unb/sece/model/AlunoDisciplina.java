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
public class AlunoDisciplina {
	
	@Id
	@GeneratedValue
	private Long idAlunoDisciplina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurmaDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private TurmaDisciplina turmaDisciplina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idAluno", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Aluno aluno;

	public Long getIdAlunoDisciplina() {
		return idAlunoDisciplina;
	}

	public void setIdAlunoDisciplina(Long idAlunoDisciplina) {
		this.idAlunoDisciplina = idAlunoDisciplina;
	}

	public TurmaDisciplina getTurmaDisciplina() {
		return turmaDisciplina;
	}

	public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
		this.turmaDisciplina = turmaDisciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	

}
