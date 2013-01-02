package br.com.unb.sece.model.DAO;

import java.io.Serializable;
import java.util.List;


//Modelo adaptado do site http://serjava.blogspot.com.br/2011/12/persistencia-jpa-dao-generico.html

public interface GenericDAO<T, I extends Serializable> {

	public T save(T entity);
	public void remove(T entity);
	public T getById(Class<T> classe, I pk);
	public List<T> listAll(Class<T> classe);
}
