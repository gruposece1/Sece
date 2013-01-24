package Control;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.commons.mail.EmailException;

import br.com.unb.sece.util.MandarEmail;
import Model.Aluno;
import Model.Responsavel;
import Model.Serie;

public class CChamada {

	private  Aluno aluno;
	
	public CChamada(Aluno aluno){
		this.aluno = aluno;
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}
	
	public Aluno getAluno(){
		return aluno;
	}
	
	public Aluno recuperarAluno(String nome)
	{
		
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
	
	
	public void enviarEmail(){
		Collection responsaveis =  aluno.getResponsaveis();
		System.out.println("Qtde responsaveis" + responsaveis.size());
		ArrayList<Responsavel> resp = new ArrayList<Responsavel>(responsaveis);
		Responsavel r;
		for(int i = 0; i < resp.size();i++){
			r=(Responsavel)resp.get(i);
			
			try {
				System.out.print("O email:" + r.getEmail());
				MandarEmail envio = new MandarEmail(r.getEmail(),"Grupo SECE",aluno.getNome());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Erro com a conexão com a internet.", "Atenção", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		
		}
		
	}

	public void findAluno(String nome){
		
	}
}

