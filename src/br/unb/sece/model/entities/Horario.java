package br.unb.sece.model.entities;

import java.util.TimeZone;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Horario {
	@Id
	@GeneratedValue
	private Long idHorario;
	private TimeZone hrInicial;
	private String teste;

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public TimeZone getHrInicial() {
		return hrInicial;
	}

	public void setHrInicial(TimeZone hrInicial) {
		this.hrInicial = hrInicial;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

}
