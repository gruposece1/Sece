package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CNota;
import br.unb.sece.control.CTurmaAluno;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.AlunoDisciplina;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Nota;
import br.unb.sece.model.Pessoa;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.Turno;
import br.unb.sece.model.DAO.DisciplinaDAO;
import br.unb.sece.model.DAO.ProfessorDAO;
import br.unb.sece.model.DAO.SerieDAO;
import br.unb.sece.model.DAO.TurnoDAO;
import br.unb.sece.util.HibernateUtil;
import br.unb.sece.util.gradehoraria.GradeHoraria;

public class TestarControleNota {

	private CNota CNota;
	private Disciplina disciplina;
	private CTurmaAluno CTurmaAluno;
	private Aluno aluno;
	private Responsavel responsavel;
	private ArrayList<Responsavel> listaResponsavel;
	
	@Before
	public void setUp()
	{
		CNota = new CNota();
		
		CTurmaAluno = new CTurmaAluno();
		
		responsavel = new Responsavel();
		
		listaResponsavel = new ArrayList<Responsavel>();
		
		responsavel.setCEP("213453");
		responsavel.setCpf("123432");
		
		listaResponsavel.add(responsavel);
		
		aluno = new Aluno();
		aluno.setNome("Teste");
		aluno.setDtNascimento("11122001");
		aluno.setMatricula("123214");
		aluno.setResponsaveis(listaResponsavel);
		aluno.setSexo("Feminino");
		
		aluno.salvar();
		
		disciplina = new Disciplina();
		disciplina.setNome("Fisica");
		
		CNota.setDisciplina(disciplina);
		
	}
	
	@Test
	public void testarInstancia()
	{
		assertNotNull(CNota);
	}

	
	@Test
	public void testarGetAllTurmar() {
		
		try
		{
			CNota.getAllTurmas();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarGetModelTurma()
	{
		try
		{
			CNota.getModelTurma();
		}
		catch(Exception e)
		{
			//fail("Ocorreu um erro");
			e.printStackTrace();
		}
	}
	

	
	@Test
	public void testarSelectTurmaCerto()
	{
		try
		{
			CNota.getModelTurma().setSelectedItem("1 - turma");
			CNota.selectTurma("1 - turma");
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	

	@Test
	public void testargetModelDisciplinaCerto()
	{
		try
		{
			CNota.getModelTurma().setSelectedItem("1 - turma");
			CNota.selectTurma("1 - turma");
			CNota.getModelDisciplinas();
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void testarSelectDisciplinaCerto()
	{
		try
		{
			CNota.getModelTurma().setSelectedItem("1 - turma");
			CNota.selectTurma("1 - turma");
			CNota.getModelDisciplinas().setSelectedItem("2 - Física");
			CNota.selectDisciplina("2 - Física");
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
			//e.printStackTrace();
		}
	}
	
	@Test
	public void salvaNota1()
	{
		try{
			Serie serie = new Serie();
			serie.setQtdeDias(2);
			serie.setQtdeHorarios(2);
			Turno turno = new Turno();
			turno.setInicio(9);
			turno.setFim(88);
			Session session = HibernateUtil.getSession();
			session.getTransaction().begin();
			
			SerieDAO daoSerie = new SerieDAO();
			daoSerie.save(serie, session);
			
			TurnoDAO daoTurno = new TurnoDAO();
			daoTurno.save(turno, session);
			
			GradeHoraria grade = new GradeHoraria(serie, turno);
			
			Disciplina disciplina = new Disciplina();
			Disciplina disciplina1 = new Disciplina();
			Disciplina disciplina2 = new Disciplina();
			Disciplina disciplina3 = new Disciplina();
			
			Professor professor = new Professor();
			Professor professor1 = new Professor();
			
			Turma turma = new Turma();
			turma.setNomeTurma("Teste");
			turma.setSerie(serie);
			turma.setTurno(turno);
			turma.salvar(session);
			
			disciplina.setNome("Português");
			disciplina1.setNome("Geografia");
			disciplina2.setNome("História");
			disciplina3.setNome("Matemática");
			
			DisciplinaDAO daoDisciplina = new DisciplinaDAO();
			daoDisciplina.save(disciplina, session);
			daoDisciplina.save(disciplina1, session);
			daoDisciplina.save(disciplina2, session);
			daoDisciplina.save(disciplina3, session);
			
			professor.setNome("João");
			professor.setSexo(Pessoa.MASCULINO);
			professor.setTelefone("71999999");
			
			professor1.setNome("Pedro");
			professor1.setSexo(Pessoa.MASCULINO);
			professor1.setTelefone("71999999");
			
			ProfessorDAO daoProfessor = new ProfessorDAO();
			daoProfessor.save(professor, session);
			daoProfessor.save(professor1, session);
			
			Object[][] gradeDeHorarios = grade.getGradeDeHorarios();
			
			Horario obHorario = grade.getHorario(0,0);
			obHorario.setDisciplina(disciplina);
			obHorario.setProfessor(professor1);
			
			Horario obHorario1 = grade.getHorario(0,1);
			obHorario1.setDisciplina(disciplina1);
			obHorario1.setProfessor(professor1);
			
			Horario obHorario2 = grade.getHorario(1,0);
			obHorario2.setDisciplina(disciplina2);
			obHorario2.setProfessor(professor);
			
			Horario obHorario3 = grade.getHorario(1,1);
			obHorario3.setDisciplina(disciplina3);
			obHorario3.setProfessor(professor);
			
			grade.gerarTurmasDisciplinas(turma, session);
			
			grade.verificarGrade();
			
			grade.salvarGrade(session);
			
			//CTurmaAluno.cadastrarAlunoTurma(turma.getIdTurma(), aluno.getIdPessoa());
			
			
			CNota.salvarNota(AlunoDisciplina.getAlunoDisciplina(aluno, disciplina3), 10, new Nota(), 1, session);
			
			session.getTransaction().rollback();
		}catch(Exception ex){
			//ex.printStackTrace();
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void salvaNota()
	{
		try{
			Serie serie = new Serie();
			serie.setQtdeDias(2);
			serie.setQtdeHorarios(2);
			Turno turno = new Turno();
			turno.setInicio(9);
			turno.setFim(88);
			Session session = HibernateUtil.getSession();
			session.getTransaction().begin();
			
			SerieDAO daoSerie = new SerieDAO();
			daoSerie.save(serie, session);
			
			TurnoDAO daoTurno = new TurnoDAO();
			daoTurno.save(turno, session);
			
			GradeHoraria grade = new GradeHoraria(serie, turno);
			
			Disciplina disciplina = new Disciplina();
			Disciplina disciplina1 = new Disciplina();
			Disciplina disciplina2 = new Disciplina();
			Disciplina disciplina3 = new Disciplina();
			
			Professor professor = new Professor();
			Professor professor1 = new Professor();
			
			Turma turma = new Turma();
			turma.setNomeTurma("Teste");
			turma.setSerie(serie);
			turma.setTurno(turno);
			turma.salvar(session);
			
			disciplina.setNome("Português");
			disciplina1.setNome("Geografia");
			disciplina2.setNome("História");
			disciplina3.setNome("Matemática");
			
			DisciplinaDAO daoDisciplina = new DisciplinaDAO();
			daoDisciplina.save(disciplina, session);
			daoDisciplina.save(disciplina1, session);
			daoDisciplina.save(disciplina2, session);
			daoDisciplina.save(disciplina3, session);
			
			professor.setNome("João");
			professor.setSexo(Pessoa.MASCULINO);
			professor.setTelefone("71999999");
			
			professor1.setNome("Pedro");
			professor1.setSexo(Pessoa.MASCULINO);
			professor1.setTelefone("71999999");
			
			ProfessorDAO daoProfessor = new ProfessorDAO();
			daoProfessor.save(professor, session);
			daoProfessor.save(professor1, session);
			
			Object[][] gradeDeHorarios = grade.getGradeDeHorarios();
			
			Horario obHorario = grade.getHorario(0,0);
			obHorario.setDisciplina(disciplina);
			obHorario.setProfessor(professor1);
			
			Horario obHorario1 = grade.getHorario(0,1);
			obHorario1.setDisciplina(disciplina1);
			obHorario1.setProfessor(professor1);
			
			Horario obHorario2 = grade.getHorario(1,0);
			obHorario2.setDisciplina(disciplina2);
			obHorario2.setProfessor(professor);
			
			Horario obHorario3 = grade.getHorario(1,1);
			obHorario3.setDisciplina(disciplina3);
			obHorario3.setProfessor(professor);
			
			grade.gerarTurmasDisciplinas(turma, session);
			
			grade.verificarGrade();
			
			grade.salvarGrade(session);
			
			//CTurmaAluno.cadastrarAlunoTurma(turma.getIdTurma(), aluno.getIdPessoa());
			
			
			CNota.salvarNota(aluno.getIdPessoa(), disciplina3, CNota.getNotas(aluno, disciplina3, new Nota()), 1, session);
			
			session.getTransaction().rollback();
		}catch(Exception ex){
			//ex.printStackTrace();
			fail("Ocorreu um erro");
		}
	}


}
