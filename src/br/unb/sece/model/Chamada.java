package br.unb.sece.model;

import java.util.Calendar;

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
public class Chamada {
	@Id
	@GeneratedValue
	private Long idChamada;
	
	private Calendar data;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idAlunoDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private AlunoDisciplina alunoDisciplina;
	
	private int verificacaoAluno;
	
	private boolean verificacaoEmail;

	public Long getIdChamada() {
		return idChamada;
	}

	public void setIdChamada(Long idChamada) {
		this.idChamada = idChamada;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

	public int getVerificacaoAluno() {
		return verificacaoAluno;
	}

	public void setVerificacaoAluno(int verificacaoAluno) {
		this.verificacaoAluno = verificacaoAluno;
	}

	public boolean isVerificacaoEmail() {
		return verificacaoEmail;
	}

	public void setVerificacaoEmail(boolean verificacaoEmail) {
		this.verificacaoEmail = verificacaoEmail;
	}

	
	
	
	
	
	
	
}
