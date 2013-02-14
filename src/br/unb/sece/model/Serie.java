package br.unb.sece.model;


import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.SerieDAO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Serie {
	
	@Id
	@GeneratedValue
	private Long idSerie;
	
	private String nome;
	private int qtdeHorarios;
	private int qtdeDias;
	
	public Serie() {
		
	}
	
	public Serie(String nome, int qtdeHorarios, int qtdeDias) {
		super();
		this.nome = nome;
		this.qtdeHorarios = qtdeHorarios;
		this.qtdeDias = qtdeDias;
	}


	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQtdeHorarios() {
		return this.qtdeHorarios;
	}
	
	public void setQtdeHorarios(int qtdeHorarios) {
		this.qtdeHorarios = qtdeHorarios;
	}
	
	public int getQtdeDias() {
		return this.qtdeDias;
	}
	
	public void setQtdeDias(int qtdeDias) {
		this.qtdeDias = qtdeDias;
	}

	public Long getIdSerie() {
		return this.idSerie;
	}

	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}

	public List getAll(){

		//Colecoes colecao = new Colecoes();
		final SerieDAO dao = new SerieDAO();
		
		return dao.listAll(Serie.class);

	}
	
	/*
	 * Padronizar em todo o codigo os nomes dos dias da semana 
	 */
	public static String[] getDiasDaSemana(){
		
		 final String diasDaSemana[] = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
		 
		 return diasDaSemana;
	}
	
	public void salvar(){
		final SerieDAO dao = new SerieDAO();
		
		dao.save(this);
	}

	public void excluir() throws BancoDeDadosException{
		final SerieDAO dao = new SerieDAO();
		
		dao.remove(this);
	}
	
	public void alterar(){
		final SerieDAO dao = new SerieDAO();
		
		dao.update(this);
	}
	
}
