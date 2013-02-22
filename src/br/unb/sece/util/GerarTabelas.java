package br.unb.sece.util;

import java.util.ArrayList;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

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
		cfg.addAnnotatedClass(AlunoDisciplina.class);
		cfg.addAnnotatedClass(TurmaDisciplina.class);
		cfg.addAnnotatedClass(Turma.class);
		cfg.addAnnotatedClass(Nota.class);
		cfg.addAnnotatedClass(RegistroNota.class);
		cfg.addAnnotatedClass(Chamada.class);
		
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
		Disciplina d4 = new Disciplina();
		d4.setNome("Português");
		d4.salvar(); 
		Disciplina d5 = new Disciplina();
		d5.setNome("Inglês");
		d5.salvar(); 
		
		ArrayList obDisciplinasProf1 = new ArrayList();
		ArrayList obDisciplinasProf2 = new ArrayList();
		ArrayList obDisciplinasProf3 = new ArrayList();
		ArrayList obDisciplinasProf4 = new ArrayList();
		
		//Adicionando disciplinas as listas
		obDisciplinasProf1.add(d1);
		obDisciplinasProf1.add(d2);

		obDisciplinasProf2.add(d2);
		
		obDisciplinasProf3.add(d3);
		
		obDisciplinasProf4.add(d4);
		obDisciplinasProf4.add(d5);
		
		Turno t = new Turno(7, 12, Turno.MANHA);
		t.salvar();
		Turno t1 = new Turno(14, 18, Turno.TARDE);
		t1.salvar();
		 
		Serie s = new Serie("8ª", 6, 5);
		s.salvar();
		Serie s1 = new Serie("7ª", 4, 5);
		s1.salvar();
		Serie s2 = new Serie("5ª", 2, 2);
		s2.salvar();
		
		Professor professor1 = new Professor();
		professor1.setNome("Pedro");
		professor1.setSexo(Pessoa.MASCULINO);
		professor1.setDisciplinas(obDisciplinasProf1);
		professor1.salvar();
		
		Professor professor2 = new Professor();
		professor2.setNome("João");
		professor2.setSexo(Pessoa.MASCULINO);
		professor2.setDisciplinas(obDisciplinasProf2);
		professor2.salvar();
		
		Professor professor3 = new Professor();
		professor3.setNome("Alberto");
		professor3.setSexo(Pessoa.MASCULINO);
		professor3.setDisciplinas(obDisciplinasProf3);
		professor3.salvar();
		
		Professor professor4 = new Professor();
		professor4.setNome("Messias");
		professor4.setSexo(Pessoa.MASCULINO);
		professor4.setDisciplinas(obDisciplinasProf4);
		professor4.salvar();
		
		Responsavel responsavel = new Responsavel();
		responsavel.setNome("Gustavo");
		responsavel.setEndereco("jkabas");
		responsavel.setSexo("Masculino");
		responsavel.setTelefone("113242");
		responsavel.setEmail("cahvsdahvd");
		responsavel.setCEP("kfhdsfsa");
		responsavel.setCpf("12345");
		responsavel.salvar();	
	}
}
