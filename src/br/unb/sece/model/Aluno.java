package br.unb.sece.model;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.AlunoDAO;

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


@Entity
public class Aluno extends Pessoa{
	
	private String matricula;
	private String dtNascimento;
	
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
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Collection<Responsavel> getResponsaveis() {
		return this.responsaveis;
	}

	public void setResponsaveis(Collection<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	

	public void salvar() {
		final AlunoDAO dao = new AlunoDAO();
		dao.save(this);
	}
	
	public static List getAll() {
		final AlunoDAO dao = new AlunoDAO();
		
		return dao.listAll(Aluno.class);
	
	}

	public void excluir() throws BancoDeDadosException {
		final AlunoDAO dao = new AlunoDAO();
		dao.remove(this);
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public static Aluno getAluno(Long idAluno){
		final AlunoDAO dao = new AlunoDAO();
		return dao.findById(Aluno.class, idAluno);
	}
	
	public static List<Aluno> getAlunosTurma(Turma turma){
		final AlunoDAO dao = new AlunoDAO();
		return dao.getAlunosTurma(turma.getIdTurma());
	}
	
	/**
	 * Buscar os alunos que nao sao da turma
	 * @param turma que nao terao seus alunos retornados
	 * @return list de alunos
	 */
	public static List<Aluno> getAlunos(Turma turma){
		final AlunoDAO dao = new AlunoDAO();
		List alunosDaTurma = Aluno.getAlunosTurma(turma);
		List todosAlunos = Aluno.getAll();
		todosAlunos.removeAll(alunosDaTurma);
		return todosAlunos;
	}
	
	public static Aluno getAlunoMatricula(String matricula) throws NullPointerException{
		final AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.getAlunoMatricula(matricula);
		if(aluno == null){
			throw new NullPointerException("Objeto Nao Encontrado");
		}
		return aluno;
	}
	
}
