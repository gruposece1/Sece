package br.unb.sece.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.SerieDAO;




@Entity
public class Serie {
	
	@Id
	@GeneratedValue
	private Long idSerie;
	
	String nome;
	int qtdeHorarios, qtdeDias;
	
	public Serie()
	{
		
	}
	
	
	
	public Serie(String nome, int qtdeHorarios, int qtdeDias) {
		super();
		this.nome = nome;
		this.qtdeHorarios = qtdeHorarios;
		this.qtdeDias = qtdeDias;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdeHorarios() {
		return qtdeHorarios;
	}
	public void setQtdeHorarios(int qtdeHorarios) {
		this.qtdeHorarios = qtdeHorarios;
	}
	public int getQtdeDias() {
		return qtdeDias;
	}
	public void setQtdeDias(int qtdeDias) {
		this.qtdeDias = qtdeDias;
	}

	
	public Long getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}



	public List getAll(){

		//Colecoes colecao = new Colecoes();
		SerieDAO dao = new SerieDAO();
		
		return dao.listAll(Serie.class);

	}
	
	/*
	 * Padronizar em todo o codigo os nomes dos dias da semana 
	 */
	public static String[] getDiasDaSemana(){
		
		 String diasDaSemana[] = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta","Sábado"};
		 return diasDaSemana;
	}
	
	public void salvar(){
		SerieDAO dao = new SerieDAO();
		dao.save(this);
	}

	public void excluir() throws BancoDeDadosException{
		SerieDAO dao = new SerieDAO();
		dao.remove(this);
	}
	
	public void alterar(){
		SerieDAO dao = new SerieDAO();
		dao.update(this);
	}
	
}
