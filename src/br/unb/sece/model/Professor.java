package br.unb.sece.model;

import br.unb.sece.model.DAO.ProfessorDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
public class Professor extends Funcionario {
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="professorDisciplina", schema="sece", joinColumns={@JoinColumn(name="idProfessor")},	inverseJoinColumns={@JoinColumn(name="idDisciplina")})
	@Cascade(CascadeType.SAVE_UPDATE)
	private Collection<Disciplina> disciplinas;
	
	public Professor() {
		super("Professor");
	}

	public Collection<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void salvar() {
		final ProfessorDAO dao = new ProfessorDAO();
		dao.save(this);
	}
	
	public List getAll() {
		final ProfessorDAO dao = new ProfessorDAO();
		
		return dao.listAll(Professor.class);
	}

	public List cadastroProfessor() {
			final ArrayList<Professor> professor = new ArrayList<Professor>();
			
			final Professor professor1 = new Professor();
			professor1.setNome("A");
			professor.add(professor1);
			
			final Professor professor2 = new Professor();
			professor2.setNome("B");
			professor.add(professor2);
			
			final Professor professor3 = new Professor();
			professor3.setNome("C");
			professor.add(professor3);
			
			
			final Professor professor4 = new Professor();
			professor4.setNome("D");
			professor.add(professor4);
		
			return professor;
	}
	
	public static List getProfessoresDisponiveis(Horario obHorario, Disciplina obDisciplina){
		final ProfessorDAO obDao = new ProfessorDAO();
		final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm") ;
		final String hrInicial = formatter.format(obHorario.getHrInicial().getTime());
		final String hrFinal = formatter.format(obHorario.getHrFinal().getTime());
		
		System.out.println("A hora inicial: " + hrInicial);
		System.out.println("A hora final: " + hrFinal);
		
		return obDao.getProfessoresDisponiveis(obHorario.getDiaSemana(), obDisciplina.getId(), hrInicial, hrFinal);
	}

}