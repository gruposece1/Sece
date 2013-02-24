package br.unb.sece.util;

import java.util.Calendar;

import br.unb.sece.control.CChamada;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Turma;

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

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	public void run(){
		CChamada obCChamada = new CChamada();
		obCChamada.enviarEmails(turma, disciplina, data);
		this.stop();
	}

	
	
	
	
}
