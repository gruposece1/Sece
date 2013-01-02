package br.com.unb.sece.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.unb.sece.model.entities.Horario;

public class HibernateUtil {

	private static SessionFactory factory;

	public static Session getSession(String nomeClasse) {
		Configuration cfg = new Configuration();
		try {
			cfg.addAnnotatedClass(Class.forName(nomeClasse));
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada");
		}
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.configure().buildServiceRegistry();
		MetadataSources metadataSources = new MetadataSources(serviceRegistry);
		metadataSources.addAnnotatedClass(Horario.class);
		factory = metadataSources.buildMetadata().buildSessionFactory();
		return factory.openSession();
	}
}
