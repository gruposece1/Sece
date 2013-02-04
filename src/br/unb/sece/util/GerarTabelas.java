package br.unb.sece.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Funcionario;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Pessoa;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.Turno;




public class GerarTabelas {
	public static void main(String[] args) {

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
		
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
		gerarInserts();
	}
	
	
	public static void gerarInserts(){
		Disciplina d = new Disciplina();
		d.setNome("Matemática");
		d.salvar();
		Disciplina d1 = new Disciplina();
		d1.setNome("Física");
		d1.salvar();
		Disciplina d2 = new Disciplina();
		d2.setNome("História");
		d2.salvar();
		Disciplina d3 = new Disciplina();
		d3.setNome("Geografia");
		d3.salvar();
		
		Turno t = new Turno(7, 12, Turno.MANHA);
		t.salvar();
		Turno t1 = new Turno(14, 18, Turno.TARDE);
		t1.salvar();
		 
		Serie s = new Serie("8ª", 6, 5);
		s.salvar();
		Serie s1 = new Serie("7ª", 4, 5);
		s1.salvar();
		
		Professor professor1 = new Professor();
		professor1.setNome("Pedro");
		professor1.setSexo(Pessoa.MASCULINO);
		professor1.salvar();
		
		Professor professor2 = new Professor();
		professor2.setNome("João");
		professor2.setSexo(Pessoa.MASCULINO);
		professor2.salvar();
		
		Professor professor3 = new Professor();
		professor3.setNome("Alberto");
		professor3.setSexo(Pessoa.MASCULINO);
		professor3.salvar();
		
		Professor professor4 = new Professor();
		professor4.setNome("Messias");
		professor4.setSexo(Pessoa.MASCULINO);
		professor4.salvar();
		
		Responsavel responsavel = new Responsavel();
		responsavel.setNome("Gustavo");
		responsavel.setEndereco("jkabas");
		responsavel.setSexo("Masculino");
		responsavel.setTelefone("113242");
		responsavel.setEmail("cahvsdahvd");
		responsavel.setCEP("kfhdsfsa");
		responsavel.setCPF("12345");
		responsavel.salvar();	
	}
}
