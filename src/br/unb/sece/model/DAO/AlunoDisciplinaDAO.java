package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.AlunoDisciplina;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;

public class AlunoDisciplinaDAO extends Persistencia {

	public AlunoDisciplinaDAO() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Object findById(Class classe, Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> listAll(Class classe) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean verificarRegistroExiste(TurmaDisciplina turmaDisciplina, Aluno aluno){
		List lista = this.objSession.createCriteria(AlunoDisciplina.class).add(Restrictions.eq("turmaDisciplina", turmaDisciplina)).add(Restrictions.eq("aluno", aluno)).list();
		if(lista.size() == 0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<AlunoDisciplina> getAllAlunoDisciplina(Long idTurma, Long idAluno){
		String sql = 
				"select " + 
				"  ad.* " +
				"from  " +
				 " alunodisciplina ad " +
				 " inner join turmadisciplina td " +
				 " on ad.idTurmaDisciplina = td.idTurmaDisciplina " +
				"where " +
				 " td.idTurma = " + idTurma + " " + 
				  "and ad.idAluno  = " + idAluno;
		return this.objSession.createSQLQuery(sql).addEntity(AlunoDisciplina.class).list();
		
	}

}
