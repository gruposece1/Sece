package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Session;

import br.unb.sece.model.Turma;

public class TurmaDAO extends Persistencia {

	public TurmaDAO(){
		super();
	}
	public TurmaDAO(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public Turma findById(Class classe, Long pk) {
		// TODO Auto-generated method stub
		return (Turma) this.objSession.load(classe, pk);
	}



@Override
public void save(Object entity, Session session) {
	// TODO Auto-generated method stub
	super.save((Turma)entity, session);
}



	



	@Override
	public List<Object> listAll(Class classe) {
		// TODO Auto-generated method stub
		return (List<Object>) this.objSession.createQuery("select o from " + classe.getSimpleName() + " o").list();
	}



}
