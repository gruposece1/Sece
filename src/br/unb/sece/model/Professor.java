package br.unb.sece.model;

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

import br.unb.sece.model.DAO.ProfessorDAO;
import br.unb.sece.model.DAO.TurnoDAO;
import br.unb.sece.util.HibernateUtil;

@Entity
public class Professor extends Funcionario {
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="professorDisciplina", schema="sece", joinColumns={@JoinColumn(name="idProfessor")},	inverseJoinColumns={@JoinColumn(name="idDisciplina")})
	@Cascade(CascadeType.SAVE_UPDATE)
	private Collection<Disciplina> disciplinas;
	
	public Professor()
	{
		super("Professor");
	}

	

	public Collection<Disciplina> getDisciplinas() {
		return disciplinas;
	}



	public void setDisciplinas(Collection<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void salvar(){
		ProfessorDAO dao = new ProfessorDAO();
		dao.save(this);
	}
	
	public List getAll(){
		ProfessorDAO dao = new ProfessorDAO();
		
		return dao.listAll(Professor.class);
	}

	public List cadastroProfessor(){
			
			ArrayList<Professor> professor = new ArrayList<Professor>();
			
			Professor professor1 = new Professor();
			professor1.setNome("A");
			professor.add(professor1);
			
			Professor professor2 = new Professor();
			professor2.setNome("B");
			professor.add(professor2);
			
			Professor professor3 = new Professor();
			professor3.setNome("C");
			professor.add(professor3);
			
			
			Professor professor4 = new Professor();
			professor4.setNome("D");
			professor.add(professor4);
		
			return professor;
	}
	
	public static List getProfessoresDisponiveis(Horario obHorario,Disciplina obDisciplina){
		ProfessorDAO obDao = new ProfessorDAO();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm") ;
		String hrInicial = formatter.format(obHorario.getHrInicial().getTime());
		String hrFinal = formatter.format(obHorario.getHrFinal().getTime());
		System.out.println("A hora inicial: " + hrInicial);
		System.out.println("A hora final: " + hrFinal);
		return obDao.getProfessoresDisponiveis(obHorario.getDiaSemana(), obDisciplina.getId(), hrInicial, hrFinal);
	}

}