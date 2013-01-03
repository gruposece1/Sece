package br.com.unb.sece.util;

import br.com.unb.sece.model.DAO.HorarioDAO;
import br.com.unb.sece.model.entities.Horario;

public class TesteDAO {

	public static void main(String[] args) {
		Horario h = new Horario();
		h.setTeste("testando aqui");
		//Cria o DAO
		HorarioDAO dao = new HorarioDAO(HibernateUtil.getSession(Horario.class).openSession());
		// Salva o objeto
		dao.save(h);
		//Remove um objeto fazendo a busca por id
		dao.remove(dao.findById(Horario.class, 7l));
		// Cria um objeto encontrando ele pelo id
		Horario h2 = dao.findById(Horario.class, 8l);
		//muda algum atributo
		h2.setTeste("teste");
		//atualiza no banco.
		dao.update(h2);
	}
}
