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
	
	
	
	
	public void enviarEmail(Aluno aluno, Disciplina disciplina, Calendar data) throws MalformedURLException,EmailException {
		final Collection responsaveis =  aluno.getResponsaveis();
		final ArrayList<Responsavel> resp = new ArrayList<Responsavel>(responsaveis);
		Responsavel rensponsavel;
		
		
		for(int i = 0; i < resp.size(); i++) {
				rensponsavel = (Responsavel) resp.get(i);
				//final MandarEmail envio = new MandarEmail(r.getEmail(), "Grupo SECE", aluno.getNome());
				final MandarEmail envio = new MandarEmail(aluno, rensponsavel, disciplina, data);
		}	
	}
	
	public void enviarEmails(Turma turma, Disciplina disciplina, Calendar data){
		List<Aluno> alunos = Chamada.getAlunosVerificacaoChamada(turma, disciplina, data, Chamada.ALUNO_AUSENTE);
		Iterator<Aluno> inAlunos = alunos.iterator();
		while(inAlunos.hasNext()){
			Aluno obAluno = inAlunos.next();
			try {
				this.enviarEmail(obAluno, disciplina, data);
				List<Chamada> listaChamada = Chamada.getChamadaChamada(turma, disciplina, obAluno, data,Chamada.ALUNO_AUSENTE);
				Iterator<Chamada> inChamada = listaChamada.iterator();
				while(inChamada.hasNext()){
					Chamada obChamada = inChamada.next();
					obChamada.setVerificacaoEmail(true);
					obChamada.alterar();
				}
				
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
