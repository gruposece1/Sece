package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;

public class TurmaDisciplinaDAO extends Persistencia {

	

	public TurmaDisciplinaDAO() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public List<Disciplina> getDisciplinasTurma(Long idTurma){
		
		String sql = "select "+
						  "d.* "+
						"from "+
						  "disciplina d  "+
						  "inner join turmadisciplina td "+
						  "on d.id = td.idDisciplina "+
						"where  "+
						  "td.idTurma = "+ idTurma;
		
		return this.objSession.createSQLQuery(sql).addEntity(Disciplina.class).list();
	}
	
	public List<TurmaDisciplina> getTurmasDisciplina(Turma turma){
		return this.objSession.createCriteria(TurmaDisciplina.class).add(Restrictions.eq("turma", turma)).list();
	}

}
