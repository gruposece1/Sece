package br.com.unb.sece.model.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import br.com.unb.sece.model.entities.Horario;
import br.com.unb.sece.util.HibernateUtil;

/**
 * Implementa comportamentos padr�es das classes DAO
 * @author Grupo Sece
 */

public abstract class Persistencia implements GenericDAO<Object, Long> {

	/**
	 * Objeto que faz a comunicacao com o banco de dados
	 */
	Session objSession;
	
	public Persistencia(){
		this.objSession = HibernateUtil.getSession();
	}
	/**
	 * M�todo construtor da classe 
	 * @param session objeto que faz a comunica��o com o banco de dados
	 * @author Grupo Sece
	 * @deprecated 
	 */
	public Persistencia(Session session){
		this.objSession = HibernateUtil.getSession();
	}
	
	/**
	 * Salva um objeto no banco de dados
	 * @param entity objeto que ser� salvo no bando de dados
	 */
	@Override
	public void save(Object entity) {
		// TODO Auto-generated method stub
		this.objSession.beginTransaction();
		this.objSession.save(entity);
		this.objSession.getTransaction().commit();
		//this.session.close();
		System.out.println("Fechou sess�o");
		
	}
	/**
	 * Salva um objeto no banco de dados com uma transacao que ainda esteja aberta
	 * @param entity objeto a ser salvo no banco de dados
	 * @param session sessao que esta sendo utilizada
	 */
	public void save(Object entity,Session session){
		session.save(entity);
	}
	
	/**
	 * Remove um objeto no banco de dados
	 * @param entity objeto a ser salvo no banco de dados
	 */
	
	@Override
	public void remove(Object entity) {
		// TODO Auto-generated method stub
		this.objSession.beginTransaction();
		this.objSession.delete(entity);
		this.objSession.getTransaction().commit();
		this.objSession.close();
		
	}
	
	/**
	 * Atualiza um objeto no banco de dados
	 * @param entity - objeto a ser atualizado no banco de dados
	 */
	
	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		this.objSession.beginTransaction();
		this.objSession.update(entity);
		this.objSession.getTransaction().commit();
		this.objSession.close();
	}
	
	public void close(){
		this.objSession.close();
	}
	
	/**
	 * Recupera um objeto pela chave primaria no banco
	 * @param classe classe que tera os objetos recuperados 
	 * @param pk chave primaria utilizada na busca
	 */
	@Override
	public abstract Object findById(Class classe, Long pk);
	
	/**
	 * Objetivo: atualizar um objeto no banco de dados
	 * @param classe classe que tera todos os objetos recuperados do banco de dados
	 */
	@Override
	public abstract List<Object> listAll(Class classe);

}
