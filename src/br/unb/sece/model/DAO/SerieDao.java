package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Session;


public class SerieDAO extends Persistencia {

	public SerieDAO(){
		super();
	}

	public SerieDAO(Session session) {
		super(session);
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
		List lista = (List) this.objSession.createQuery("select o from " + classe.getSimpleName() + " o").list();
		//this.session.close();
		return lista;
		
		
	}

}
