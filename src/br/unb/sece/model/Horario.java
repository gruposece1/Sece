package br.unb.sece.model;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.model.DAO.HorarioDAO;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Horario {
	
	public static final String SEGUNDA = "Segunda-feira";
	public static final String TERCA = "Terça-feira";
	public static final String QUARTA = "Quarta-feira";
	public static final String QUINTA = "Quinta-feira";
	public static final String SEXTA = "Sexta-feira";
	public static final String SABADO = "Sábado";
	public static final String DOMINGO = "Domingo";
	
	public static final int SEGUNDA_BANCO = 0;
	public static final int TERCA_BANCO = 1;
	public static final int QUARTA_BANCO = 2;
	public static final int QUINTA_BANCO = 3;
	public static final int SEXTA_BANCO = 4;
	public static final int SABADO_BANCO = 5;
	public static final int DOMINGO_BANCO = 6;
	
	
	@Id
	@GeneratedValue
	private Long idHorario;
	
	private Calendar hrInicial;
	private Calendar hrFinal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idProfessor", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Professor professor;
	
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	*/
	@Transient
	private Disciplina disciplina;
	/*
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurma", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	*/
	@Transient
	private Turma turma;

	private int diaSemana;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTurmaDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private TurmaDisciplina turmaDisciplina;
	
	public Long getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Calendar getHrInicial() {
		return this.hrInicial;
	}

	public void setHrInicial(Calendar hrInicial) {
		this.hrInicial = hrInicial;
	}

	public Calendar getHrFinal() {
		return this.hrFinal;
	}

	public void setHrFinal(Calendar hrFinal) {
		this.hrFinal = hrFinal;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		if(this.disciplina == null && this.idHorario != null){
			this.disciplina = Disciplina.getDisciplina(this);
		}
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public void salvar() throws AtributoNuloException, AtributoInvalidoException{
		final HorarioDAO hr = new HorarioDAO();
		this.verificar();
		hr.save(this);
	}
	 
	public void verificar() throws AtributoNuloException, AtributoInvalidoException{
		if(this.hrInicial == null){
			throw new AtributoNuloException("Hora Inicial");
		}
		if(this.hrFinal == null){
			throw new AtributoNuloException("Hora Final");
		}
		if(this.diaSemana < 0 || this.diaSemana > 6){
			throw new AtributoInvalidoException("Hora Final");
		}
		if(this.disciplina == null){
			throw new AtributoNuloException("Disciplina");
		}
		if(this.professor == null){
			throw new AtributoNuloException("Professor");
		}
	}
	public void salvar(Session session) throws AtributoNuloException, AtributoInvalidoException{
		final HorarioDAO hr = new HorarioDAO();
		this.verificar();
		hr.save(this, session);
	}
	
	public Horario  horarioAtualTurma(Turma turma) {
		final HorarioDAO hr = new HorarioDAO();
		return hr.horarioAtualTurma(Horario.class, turma);
	}

	public int getDiaSemana() {
		return this.diaSemana;
	}
	
	
	

	public TurmaDisciplina getTurmaDisciplina() {
		return turmaDisciplina;
	}

	public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
		this.turmaDisciplina = turmaDisciplina;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	public static List<Horario> getHorariosDaTurma(Turma turma, Disciplina disciplina){
		if(turma == null || disciplina == null) throw new NullPointerException();
		final HorarioDAO hr = new HorarioDAO();
		return hr.getHorariosTurmaDisciplina(turma.getIdTurma(), disciplina.getId());
	}
	
	public String getDiaSemanaString() {
		
		switch(this.diaSemana){
			case Horario.DOMINGO_BANCO:
				return Horario.DOMINGO;
			case Horario.QUARTA_BANCO:
				return Horario.QUARTA;
			case Horario.SEGUNDA_BANCO:
				return Horario.SEGUNDA;
			case Horario.TERCA_BANCO:
				return Horario.TERCA;
			case Horario.QUINTA_BANCO:
				return Horario.QUINTA;
			case Horario.SEXTA_BANCO:
				return Horario.SEXTA;
			case Horario.SABADO_BANCO:
				return Horario.SABADO;
		}
		
		return " ";
		
	}
	
	public static String getDiaSemanaString(int diaDaSemana) {
		assert diaDaSemana >= 0 && diaDaSemana <= 6;
		
		switch(diaDaSemana){
			case Horario.DOMINGO_BANCO:
				return Horario.DOMINGO;
			case Horario.QUARTA_BANCO:
				return Horario.QUARTA;
			case Horario.SEGUNDA_BANCO:
				return Horario.SEGUNDA;
			case Horario.TERCA_BANCO:
				return Horario.TERCA;
			case Horario.QUINTA_BANCO:
				return Horario.QUINTA;
			case Horario.SEXTA_BANCO:
				return Horario.SEXTA;
			case Horario.SABADO_BANCO:
				return Horario.SABADO;
		}
		
		return " ";
		
	}
	
	

}
