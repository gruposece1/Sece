package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.unb.sece.model.Nota;

public class NotaDAO extends Persistencia{

	

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
	
	public Nota getNota(){
		Nota nota = (Nota)this.objSession.createCriteria(Nota.class).add(Restrictions.eq("descNota", "Nota Bimestral")).uniqueResult();
		if(nota == null){
			nota = new Nota();
			nota.setDescNota("Nota Bimestral");
			nota.salvar();
		}
		return nota;
	}
	
	

}
