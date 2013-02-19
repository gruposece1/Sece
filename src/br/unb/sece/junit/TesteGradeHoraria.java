package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.TurnoHrInicioMaiorHrFimException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Pessoa;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.Turno;
import br.unb.sece.model.DAO.DisciplinaDAO;
import br.unb.sece.model.DAO.ProfessorDAO;
import br.unb.sece.model.DAO.SerieDAO;
import br.unb.sece.model.DAO.TurnoDAO;
import br.unb.sece.util.HibernateUtil;
import br.unb.sece.util.gradehoraria.GradeHoraria;

public class TesteGradeHoraria {

	@Test (expected= NullPointerException.class)
	public void testGradeHorariaNullSerie() throws Exception {
		Serie serie = null;
		Turno turno = null;
		GradeHoraria grade = new GradeHoraria(serie, turno);
		
		
	}
	
	@Test (expected= NullPointerException.class)
	public void testGradeHorariaNullTurno() throws Exception{
		Serie serie = new Serie();
		serie.setQtdeDias(2);
		serie.setQtdeHorarios(3);
		Turno turno = null;
		GradeHoraria grade = new GradeHoraria(serie, turno);
	}
	
	@Test
	public void testGradeHoraria() throws Exception{
		Serie serie = new Serie();
		serie.setQtdeDias(2);
		serie.setQtdeHorarios(3);
		Turno turno = new Turno();
		turno.setInicio(8);
		turno.setFim(88);
		try{
			GradeHoraria grade = new GradeHoraria(serie, turno);
		}catch(NullPointerException ex){
			fail("Serie ou turno nulos");
		}
	}
	
	@Test (expected= ArithmeticException.class)
	public void testGradeHorariaQtdeHorarioZero() throws Exception{
		Serie serie = new Serie();
		serie.setQtdeDias(2);
		serie.setQtdeHorarios(0);
		Turno turno = new Turno();
		turno.setInicio(10);
		turno.setFim(88);
		GradeHoraria grade = new GradeHoraria(serie, turno);
		
	}
	
	@Test (expected= IndexOutOfBoundsException.class)
	public void testGradeHorariaDiasMenorQueUm() throws Exception{
		Serie serie = new Serie();
		serie.setQtdeDias(-2);
		serie.setQtdeHorarios(3);
		Turno turno = new Turno();
		turno.setInicio(10);
		turno.setFim(88);
		GradeHoraria grade = new GradeHoraria(serie, turno);
		
	}
	
	@Test (expected= TurnoHrInicioMaiorHrFimException.class)
	public void testGradeHorariaInicioMaiorQueFim() throws Exception{
		Serie serie = new Serie();
		serie.setQtdeDias(4);
		serie.setQtdeHorarios(3);
		Turno turno = new Turno();
		turno.setInicio(198);
		turno.setFim(88);
		GradeHoraria grade = new GradeHoraria(serie, turno);
		
	}
	
	@Test (expected= AtributoNuloException.class)
	public void testGradeHorariaHorariosNulos() throws Exception{
		Serie serie = new Serie();
		serie.setQtdeDias(4);
		serie.setQtdeHorarios(3);
		Turno turno = new Turno();
		turno.setInicio(9);
		turno.setFim(88);
		GradeHoraria grade = new GradeHoraria(serie, turno);
		grade.verificarGrade();
		
	}
	
	@Test 
	public void testGradeHorariaGetDisciplinasGradeTodaNula() throws Exception{
		Serie serie = new Serie();
		serie.setQtdeDias(2);
		serie.setQtdeHorarios(2);
		Turno turno = new Turno();
		turno.setInicio(9);
		turno.setFim(88);
		GradeHoraria grade = new GradeHoraria(serie, turno);
		List disciplinas = grade.getDisciplinasGrade();
		
	}
	
	@Test 
	public void testGradeHorariaPreenchida() throws Exception{
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
			
			session.getTransaction().rollback();
		}catch(Exception ex){
			ex.printStackTrace();
			fail("Ocorreu um erro");
		}
		
		
	}

	

}
