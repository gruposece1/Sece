package br.com.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Session;

import Model.Aluno;
import Model.Horario;

public class ResponsavelDAO extends Persistencia {

	public ResponsavelDAO(){
		super();
	}
	public ResponsavelDAO(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}
	/*
	public List responsaveisAlunos(Class classe,Aluno aluno){
		String sql = "select o from " + classe.getSimpleName() + "o inner join "
		return (List) this.session.createQuery("select o from " + classe.getSimpleName() + " o where idturma = "+turma.getIdTurma()).list();
	}
	*/

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
	
}
