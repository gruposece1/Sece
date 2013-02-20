package br.unb.sece.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.AlunoDisciplina;
import br.unb.sece.model.Chamada;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Funcionario;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Nota;
import br.unb.sece.model.Pessoa;
import br.unb.sece.model.Professor;
import br.unb.sece.model.RegistroNota;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;
import br.unb.sece.model.Turno;


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
		cfg.addAnnotatedClass(TurmaDisciplina.class);
		if(factory == null){
			factory = cfg.buildSessionFactory();
		}

		return factory;
	}
	
	public static Session getSession(){
		if(session == null){
			System.out.println("Hibernate Util criando session");
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
			cfg.addAnnotatedClass(TurmaDisciplina.class);
			cfg.addAnnotatedClass(AlunoDisciplina.class);
			cfg.addAnnotatedClass(Nota.class);
			cfg.addAnnotatedClass(RegistroNota.class);
			cfg.addAnnotatedClass(Chamada.class);
			factory = cfg.buildSessionFactory();
			session = factory.openSession();
		}
		
		return session;
	}
	
	public static void closeSession(){
		session.close();
		session = null;
	}
}
