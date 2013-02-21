package br.unb.sece.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.AlunoDisciplinaDAO;

@Entity
public class AlunoDisciplina {
	
	@Id
	@GeneratedValue
	private Long idAlunoDisciplina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurmaDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private TurmaDisciplina turmaDisciplina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idAluno", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Aluno aluno;

	public Long getIdAlunoDisciplina() {
		return idAlunoDisciplina;
	}

	public void setIdAlunoDisciplina(Long idAlunoDisciplina) {
		this.idAlunoDisciplina = idAlunoDisciplina;
	}

	public TurmaDisciplina getTurmaDisciplina() {
		return turmaDisciplina;
	}

	public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
		this.turmaDisciplina = turmaDisciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void salvar(Session session){
		AlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		dao.save(this, session);
	}
	
	public boolean verificarExistencia(){
		return AlunoDisciplina.verificarExistencia(this.turmaDisciplina, this.aluno);
	}
	
	public static boolean  verificarExistencia(TurmaDisciplina turmaDisciplina, Aluno aluno){
		final AlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		return dao.verificarRegistroExiste(turmaDisciplina, aluno);
	}
	
	public List getAllAlunoDisciplina(Turma turma){
		return AlunoDisciplina.getAllAlunoDisciplina(turma, this.aluno);
	}
	
	public static List getAllAlunoDisciplina(Turma turma, Aluno aluno){
		return AlunoDisciplina.getAllAlunoDisciplina(turma.getIdTurma(), aluno.getIdPessoa());
	}
	
	public static List getAllAlunoDisciplina(Long idTurma, Long idAluno){
		final AlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		return dao.getAllAlunoDisciplina(idTurma, idAluno);
	}
	
	public void excluir() throws BancoDeDadosException{
		final AlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		dao.remove(this);
	}
	
	public static List<Aluno> getAlunosDaTurma(Turma turma){
		final AlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		if(turma == null){
			throw new NullPointerException();
		}
		return dao.getAlunosDaTurma(turma.getIdTurma());
	}
	
	public static AlunoDisciplina getAlunoDisciplina(Aluno aluno,Disciplina disciplina){
		final AlunoDisciplinaDAO dao = new AlunoDisciplinaDAO();
		return dao.getAlunoDisciplina(aluno, disciplina);
	}
	

}
