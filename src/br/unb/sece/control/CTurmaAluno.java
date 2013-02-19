package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;

import org.hibernate.Session;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.AlunoDisciplina;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;
import br.unb.sece.util.HibernateUtil;

public class CTurmaAluno {

	private Turma turma;
	
	public CTurmaAluno(){
		turma = new Turma();		
	}
	
	public static List getAll(){
		return  Aluno.getAll();
	}
	
	
	public void cadastrarAlunoTurma(Long idTurma, Long idAluno){
		Turma turmaDoAluno = Turma.recuperarTuma(idTurma);
		Aluno aluno = Aluno.getAluno(idAluno);
		this.cadastrarAlunoTurma(turmaDoAluno, aluno);
	}
	
	
	public void cadastrarAlunoTurma(Turma turmaDoAluno, Aluno aluno){
		
		Session session = HibernateUtil.getSession();
		session.getTransaction().begin();
		try{
			List<TurmaDisciplina> disciplinasTurma = TurmaDisciplina.getTurmasDisciplina(turmaDoAluno);
			Iterator<TurmaDisciplina> iteradorTurmaDisciplina = disciplinasTurma.iterator();
			while(iteradorTurmaDisciplina.hasNext()){
				TurmaDisciplina turmaDisciplina = iteradorTurmaDisciplina.next();
				AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
				alunoDisciplina.setTurmaDisciplina(turmaDisciplina);
				alunoDisciplina.setAluno(aluno);
				alunoDisciplina.salvar(session);
			}
			
			session.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
			HibernateUtil.closeSession();
		}
		
	}
	
	public void cadastrarAlunoTurma(Turma turmaDoAluno, List matriculaAluno){
		for(int i = 0; i < matriculaAluno.size(); i++){
			try{
				Aluno aluno = Aluno.getAlunoMatricula(matriculaAluno.get(i).toString());
				this.cadastrarAlunoTurma(turmaDoAluno, aluno);
			}catch(NullPointerException ex){
				ex.printStackTrace();
			}
		}
	}
	
	public static DefaultListModel getListAlunos(Turma turma){
		
		List alunos = Aluno.getAlunos(turma);
		
		return CTurmaAluno.getDefaultListModel(alunos);
		
	}
	
	public static DefaultListModel getListAlunosDaTurma(Turma turma){
		List alunos = Aluno.getAlunosTurma(turma);
		
		return CTurmaAluno.getDefaultListModel(alunos);
	}
	
	private static DefaultListModel getDefaultListModel(List<Aluno> alunos){
		DefaultListModel AlunoListModel = new DefaultListModel();
		for (int i=0; i< alunos.size();i++){
			
			Aluno obAluno = (Aluno)alunos.get(i);
			AlunoListModel.addElement(obAluno.getMatricula()+" "+ obAluno.getNome());
		 
			
		}
		return AlunoListModel;
	}

}
