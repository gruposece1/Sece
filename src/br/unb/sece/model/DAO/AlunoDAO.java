package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Session;

public class AlunoDAO extends Persistencia {


	public AlunoDAO(){
		super();
	}
	public AlunoDAO(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object findById(Class classe, Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listAll(Class classe) {
		// TODO Auto-generated method stub
		return (List<Object>) this.objSession.createQuery("select o from " + classe.getSimpleName() + " o").list();
	}

	

}
