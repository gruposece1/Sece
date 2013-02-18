package br.unb.sece.model;

import java.util.Calendar;

public class Chamada {
	
	private Long idChamada;
	
	private Disciplina disciplina;
	
	private Calendar data;

	public Long getIdChamada() {
		return idChamada;
	}

	public void setIdChamada(Long idChamada) {
		this.idChamada = idChamada;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	
	
	
}
