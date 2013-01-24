package br.com.unb.sece.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Aluno;
import Model.Disciplina;
import Model.Funcionario;
import Model.Horario;
import Model.Pessoa;
import Model.Professor;
import Model.Responsavel;
import Model.Serie;
import Model.Turma;
import Model.Turno;

public class HibernateUtil {

	private static SessionFactory factory;
	
	private static Session session = null;

	public static SessionFactory getSession(Class classe) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(classe);
		cfg.addAnnotatedClass(Pessoa.class);
		cfg.addAnnotatedClass(Professor.class);
		cfg.addAnnotatedClass(Funcionario.class);
		cfg.addAnnotatedClass(Responsavel.class);
		cfg.addAnnotatedClass(Aluno.class);
		cfg.addAnnotatedClass(Horario.class);
		cfg.addAnnotatedClass(Disciplina.class);
		cfg.addAnnotatedClass(Turno.class);
		cfg.addAnnotatedClass(Serie.class);
		cfg.addAnnotatedClass(Turma.class);
		if(factory == null){
			factory = cfg.buildSessionFactory();
		}

		return factory;
	}
	
	public static Session getSession(){
		if(session == null){
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(Pessoa.class);
			cfg.addAnnotatedClass(Professor.class);
			cfg.addAnnotatedClass(Funcionario.class);
			cfg.addAnnotatedClass(Responsavel.class);
			cfg.addAnnotatedClass(Aluno.class);
			cfg.addAnnotatedClass(Horario.class);
			cfg.addAnnotatedClass(Disciplina.class);
			cfg.addAnnotatedClass(Turno.class);
			cfg.addAnnotatedClass(Serie.class);
			cfg.addAnnotatedClass(Turma.class);
			factory = cfg.buildSessionFactory();
			session = factory.openSession();
		}
		
		return session;
	}
}
