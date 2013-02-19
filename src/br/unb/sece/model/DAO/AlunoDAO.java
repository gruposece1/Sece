package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Session;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.Turma;

public class AlunoDAO extends Persistencia {


	public AlunoDAO(){
		super();
	}
	public AlunoDAO(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Aluno findById(Class classe, Long pk) {
		// TODO Auto-generated method stub
		return (Aluno) this.objSession.load(classe, pk);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listAll(Class classe) {
		// TODO Auto-generated method stub
		return (List<Object>) this.objSession.createQuery("select o from " + classe.getSimpleName() + " o").list();
	}
	
	public List<Aluno> getAlunosTurma(Long idTurma){
		String sql =  "select "+ 
					  "p.*, "+ 
					 " a.* "+ 
					"from  "+ 
					 " aluno  a "+ 
					 " inner join pessoa p "+ 
					  "on p.idPessoa = a.idPessoa "+ 
					  "inner join alunodisciplina ad "+ 
					  "on a.idPessoa = ad.idAluno "+ 
					  "inner join turmadisciplina td "+ 
					  "on td.idTurmaDisciplina = ad.idTurmaDisciplina "+
					"where "+
					  "td.idTurma = "+ idTurma;
		
		return this.objSession.createSQLQuery(sql).addEntity(Aluno.class).list();
		
	}
	
	public List<Aluno> getAlunos(Long idTurma){
		String sql =  "select "+ 
					  "p.*, "+ 
					 " a.* "+ 
					"from  "+ 
					 " aluno  a "+ 
					 " inner join pessoa p "+ 
					  "on p.idPessoa = a.idPessoa "+ 
					  "inner join alunodisciplina ad "+ 
					  "on a.idPessoa = ad.idAluno "+ 
					  "inner join turmadisciplina td "+ 
					  "on td.idTurmaDisciplina = ad.idTurmaDisciplina "+
					"where "+
					  "td.idTurma <> "+ idTurma;
		
		return this.objSession.createSQLQuery(sql).addEntity(Aluno.class).list();
		
	}

	

}
