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
public class RegistroNota {
	@Id
	@GeneratedValue
	private Long idRegistroNota;
	
	private double valor;
	
	private int bimestre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idNota", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Nota nota;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idAlunoDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private AlunoDisciplina alunoDisciplina;

	public Long getIdRegistroNota() {
		return idRegistroNota;
	}

	public void setIdRegistroNota(Long idRegistroNota) {
		this.idRegistroNota = idRegistroNota;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getBimestre() {
		return bimestre;
	}

	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}
	
	public static final int PRIMEIRO_BIMESTRE = 1;
	
	public static final int SEGUNDO_BIMESTRE = 1;
	
	public static final int TERCEIRO_BIMESTRE = 1;
	
	public static final int QUARTO_BIMESTRE = 1;

}
