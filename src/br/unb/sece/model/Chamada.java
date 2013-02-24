package br.unb.sece.model;

import java.util.Calendar;
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

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.model.DAO.ChamadaDAO;

@Entity
public class Chamada {
	@Id
	@GeneratedValue
	private Long idChamada;
	
	private Calendar data;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idAlunoDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private AlunoDisciplina alunoDisciplina;
	
	private int verificacaoAluno;
	
	private boolean verificacaoEmail;
	
	private String obsAluno;

	public Long getIdChamada() {
		return idChamada;
	}

	public void setIdChamada(Long idChamada) {
		this.idChamada = idChamada;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}

	public int getVerificacaoAluno() {
		return verificacaoAluno;
	}

	public void setVerificacaoAluno(int verificacaoAluno) throws AtributoInvalidoException {
		if(verificacaoAluno < 1 || verificacaoAluno >3){
			throw new AtributoInvalidoException();
		}
		this.verificacaoAluno = verificacaoAluno;
	}

	public boolean isVerificacaoEmail() {
		return verificacaoEmail;
	}

	public void setVerificacaoEmail(boolean verificacaoEmail) {
		this.verificacaoEmail = verificacaoEmail;
	}
	
	public boolean enviarEmail(){
		if(this.verificacaoAluno == Chamada.ALUNO_AUSENTE){
			return true;
		}else{
			return false;
		}
	}

	public String getObsAluno() {
		return obsAluno;
	}

	public void setObsAluno(String obsAluno) {
		this.obsAluno = obsAluno;
	}



	public static final int  ALUNO_PRESENTE = 1;
	
	public static final int  ALUNO_AUSENTE = 2;
	
	public static final int  ALUNO_ATRASADO = 3;
	
	
	public void salvar(){
		final ChamadaDAO dao = new ChamadaDAO();
		dao.save(this);
	}
	
	public void salvar(Session session){
		final ChamadaDAO dao = new ChamadaDAO();
		dao.save(this,session);
	}
	
	public void alterar(){
		final ChamadaDAO dao = new ChamadaDAO();
		dao.update(this);
	}
	
	public static List<Aluno> getAlunosVerificacaoChamada(Turma turma, Disciplina disciplina, Calendar data, int condicaoAluno){
		final ChamadaDAO dao = new ChamadaDAO();
		
		return dao.getAlunosVerificacaoChamada(turma.getIdTurma(), disciplina.getId(), data, condicaoAluno);
		
	}
	
	public static Chamada getChamadaChamada(Turma turma, Disciplina disciplina,Aluno aluno, Calendar data){
		final ChamadaDAO dao = new ChamadaDAO();
		
		return dao.getChamada(turma.getIdTurma(), disciplina.getId(), aluno.getIdPessoa(), data);
		
	}
	
}
