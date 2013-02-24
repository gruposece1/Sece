package br.unb.sece.control;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.AlunoDisciplina;
import br.unb.sece.model.Chamada;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Turma;
import br.unb.sece.util.MandarEmail;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.mail.EmailException;
import org.hibernate.Session;

public class CChamada {

	private  Aluno aluno;
	
	public CChamada(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public CChamada(){
		
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Aluno getAluno() {
		return this.aluno;
	}
	
	public Aluno recuperarAluno(String nome) {
		/*
		for (Iterator<Aluno> iter =serie.serie.iterator(); iter.hasNext();)
		{	
			Aluno a = iter.next();
			if(a.getNome().equals(nome))
				return a;
			
		}
		*/
		return null;
	}
	
	
	public void enviarEmail(Aluno aluno) throws MalformedURLException,EmailException {
		final Collection responsaveis =  aluno.getResponsaveis();
		final ArrayList<Responsavel> resp = new ArrayList<Responsavel>(responsaveis);
		Responsavel r;
		
		System.out.println("Qtde responsaveis" + responsaveis.size());
		
		for(int i = 0; i < resp.size(); i++) {
			r = (Responsavel) resp.get(i);
			
				System.out.print("O email:" + r.getEmail());
				final MandarEmail envio = new MandarEmail(r.getEmail(), "Grupo SECE", this.aluno.getNome());
			
		}	
	}
	
	public void enviarEmails(Turma turma, Disciplina disciplina, Calendar data){
		List<Aluno> alunos = Chamada.getAlunosVerificacaoChamada(turma, disciplina, data, Chamada.ALUNO_AUSENTE);
		Iterator<Aluno> inAlunos = alunos.iterator();
		while(inAlunos.hasNext()){
			Aluno obAluno = inAlunos.next();
			try {
				this.enviarEmail(obAluno);
				Chamada obChamada = Chamada.getChamadaChamada(turma, disciplina, obAluno, data);
				obChamada.setVerificacaoEmail(true);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public void findAluno(String nome) {
		
	}
	
	public void cadastrarChamada(Long idAluno,Long idDisciplina,int verificacaoAluno, Calendar data,String observacao, Session session ) throws AtributoInvalidoException{
		Aluno aluno = Aluno.getAluno(idAluno);
		Disciplina disciplina = Disciplina.getDisciplina(idDisciplina);
		if(disciplina == null || aluno == null){
			throw new NullPointerException();
		}
		this.cadastrarChamada(aluno, disciplina, verificacaoAluno, data,observacao,session);
	}
	
	public void cadastrarChamada(Aluno aluno,Disciplina disciplina,int verificacaoAluno, Calendar data,String observacao, Session session ) throws AtributoInvalidoException{
		AlunoDisciplina alunoDisciplina = AlunoDisciplina.getAlunoDisciplina(aluno, disciplina);
		this.cadastrarChamada(alunoDisciplina, verificacaoAluno, data,observacao, session);
	}
	
	public void cadastrarChamada(AlunoDisciplina alunoDisciplina, int verificacaoAluno, Calendar data, String observacao, Session session) throws AtributoInvalidoException{
		Chamada chamada = new Chamada();
		chamada.setAlunoDisciplina(alunoDisciplina);
		chamada.setVerificacaoAluno(verificacaoAluno);
		if(data == null){
			data = Calendar.getInstance();
			
		}
		chamada.setData(data);
		chamada.setVerificacaoEmail(false);
		if(session == null){
			chamada.salvar();
		}else{
			chamada.salvar(session);
		}
		chamada.setObsAluno(observacao);
	}

}
