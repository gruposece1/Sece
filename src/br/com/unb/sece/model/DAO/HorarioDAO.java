package br.com.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Session;

import br.com.unb.sece.model.entities.Horario;

public class HorarioDAO implements GenericDAO<Horario, Long> {

	Session session;

	public HorarioDAO(Session session) {
		this.session = session;
	}

	@Override
	public void save(Horario entity) {
		this.session.beginTransaction();
		this.session.save(entity);
		this.session.getTransaction().commit();
	}

	@Override
	public void remove(Horario entity) {
		this.session.beginTransaction();
		this.session.delete(entity);
		this.session.getTransaction().commit();

	}

	@Override
	public Horario findById(Class<Horario> classe, Long pk) {

		return (Horario) this.session.load(classe, pk);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Horario> listAll(Class<Horario> classe) {
		return (List<Horario>) this.session.createQuery("select o from " + classe.getSimpleName() + " o").list();
	}

	@Override
	public void update(Horario entity) {
		this.session.beginTransaction();
		this.session.update(entity);
		this.session.getTransaction().commit();
	}

}
