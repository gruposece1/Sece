package br.unb.sece.model.entities;

import javax.persistence.Entity;

@Entity
public class Turma {

	private Long idTurma;
	private String nomeTurma;

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

}
