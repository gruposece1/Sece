package br.unb.sece.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa
{
	public static final String MASCULINO = "Masculino";
	
	public static final String FEMININO = "Feminino";
	@Id
	@GeneratedValue
	private Long idPessoa;
	private String nome, sexo;
	
	
	public Pessoa()
	{
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	


}
