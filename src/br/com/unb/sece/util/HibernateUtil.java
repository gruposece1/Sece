package br.com.unb.sece.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;

	public static SessionFactory getSession(Class classe) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(classe);
		factory = cfg.buildSessionFactory();

		return factory;
	}
}
