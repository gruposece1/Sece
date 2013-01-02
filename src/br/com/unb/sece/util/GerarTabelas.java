package br.com.unb.sece.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.unb.sece.model.entities.Horario;

public class GerarTabelas {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Horario.class);

		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
}
