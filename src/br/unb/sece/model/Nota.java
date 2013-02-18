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
public class Nota {
	
	@Id
	@GeneratedValue
	private Long idNota;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idHorario", insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Horario horario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurmaAluno", insertable=true, updatable = true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private TurmaAluno aluno;
	
	private double notaPrimeiroBimestre;
	
	private double notaSegundoBimestre;
	
	private double notaTerceiroBimestre;
	
	private double notaQuartoBimestre;

	public Long getIdNota() {
		return idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public double getNotaPrimeiroBimestre() {
		return notaPrimeiroBimestre;
	}

	public void setNotaPrimeiroBimestre(double notaPrimeiroBimestre) {
		this.notaPrimeiroBimestre = notaPrimeiroBimestre;
	}

	public double getNotaSegundoBimestre() {
		return notaSegundoBimestre;
	}

	public void setNotaSegundoBimestre(double notaSegundoBimestre) {
		this.notaSegundoBimestre = notaSegundoBimestre;
	}

	public double getNotaTerceiroBimestre() {
		return notaTerceiroBimestre;
	}

	public void setNotaTerceiroBimestre(double notaTerceiroBimestre) {
		this.notaTerceiroBimestre = notaTerceiroBimestre;
	}

	public double getNotaQuartoBimestre() {
		return notaQuartoBimestre;
	}

	public void setNotaQuartoBimestre(double notaQuartoBimestre) {
		this.notaQuartoBimestre = notaQuartoBimestre;
	}
	
	
}
