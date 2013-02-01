package br.unb.sece.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.AlunoDAO;
import br.unb.sece.util.HibernateUtil;


@Entity
public class Aluno extends Pessoa{
	
	private String matricula, dtNascimento;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="alunoResponsavel", schema="sece", joinColumns={@JoinColumn(name="idAluno")},	inverseJoinColumns={@JoinColumn(name="idResponsavel")})
	@Cascade(CascadeType.SAVE_UPDATE)
	private Collection<Responsavel> responsaveis = new ArrayList<Responsavel>();
	/*
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="turmaaluno", schema="sece",
	joinColumns={@JoinColumn(name="idPessoa")},
	inverseJoinColumns={@JoinColumn(name="idTurma")})
	Collection<Turma> turmas = new ArrayList<Turma>();
	*/
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Collection<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(Collection<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	

	public void salvar(){
		AlunoDAO dao = new AlunoDAO();
		dao.save(this);
	}
	
	public static List getAll(){
		AlunoDAO dao = new AlunoDAO();
		
		return dao.listAll(Aluno.class);
	
	}

	public void excluir() throws BancoDeDadosException{
		AlunoDAO dao = new AlunoDAO();
		dao.remove(this);
	}

	

	
	
	
}
