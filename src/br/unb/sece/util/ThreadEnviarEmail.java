package br.unb.sece.util;

import java.util.Calendar;

import br.unb.sece.control.CChamada;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Turma;
import java.lang.Thread;

public class ThreadEnviarEmail extends Thread {
	
	private Turma turma;
	private Disciplina disciplina;
	private Calendar data;

	public ThreadEnviarEmail(Turma turma, Disciplina disciplina, Calendar data) {
		super();
		this.setTurma(turma);
		this.setDisciplina(disciplina);
		this.setData(data);
		
		
		// TODO Auto-generated constructor stub
	}

	public void setTurma(Turma turma) throws NullPointerException {
		if(turma == null) throw new NullPointerException();
		this.turma = turma;
	}

	public void setDisciplina(Disciplina disciplina) throws NullPointerException {
		if(disciplina == null) throw new NullPointerException();
		this.disciplina = disciplina;
	}

	public void setData(Calendar data) throws NullPointerException {
		if(data == null) throw new NullPointerException();
		this.data = data;
	}
	
	@Override
	public void run(){
		CChamada obCChamada = new CChamada();
		obCChamada.enviarEmails(turma, disciplina, data);
	}

	
	
	
	
}
