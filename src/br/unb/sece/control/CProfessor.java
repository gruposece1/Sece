package br.unb.sece.control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;


import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;

import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Responsavel;
import br.unb.sece.view.panelcadastropadrao.VCadProfessor;


public class CProfessor extends CFuncionario{

private Professor professor;
	
	public CProfessor() {
		super("br.unb.sece.model.Professor");
		
		this.professor= new Professor();
	}
	
	public void definirTitulosEMetodos() {
		
		final Object[] titulos = {"Nome","CPF","Telefone"};
		
		this.titulos = titulos;
		
		Object [] metodos = {"getNome", "getCPF","getTelefone"};
		
		this.metodos = metodos;
		
	}

	
	
	public Professor getProfessor() {
		return professor;
	}

	public void setFuncionario(Professor professor) {
		this.professor = professor;
	}

	public void salvar() {
		this.professor.salvar();
		this.professor = new Professor();
		
	}
	
	
	public void excluir(Object obj) throws BancoDeDadosException {
		Professor professor = (Professor)obj;
		professor.excluir();
		
	}
	
	@Override
	public void verificarDados() throws Exception{
		
		if(this.professor.getNome().equals("")){
			throw new AtributoNuloException();
		}
		
		if(this.professor.getCpf().equals(""))
			throw new AtributoNuloException();
		
		if(this.professor.getSenha().equals(""))
			throw new AtributoNuloException();
		
		if(this.professor.getTelefone().equals("")){
			throw new AtributoNuloException();
		}
		
	}
	
	public void receberDados(Object obj, int operacao) throws Exception{
		
		VCadProfessor panel=new VCadProfessor();
		
		if(obj==null)
			throw new AtributoInvalidoException();
	
		
		try
		{
			panel = (VCadProfessor)this.getPanelPadrao(obj);
		} catch(Exception e)
		{
			throw new AtributoInvalidoException();
		}
			
		switch(operacao){
		case CPadrao.OPERACAO_INSERIR:
			
			ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
			
			professor.setNome(panel.getTxtNome().getText());
			professor.setCpf(panel.getTxtCPF().getText());
			professor.setTelefone(panel.getTxtTelefone().getText());
			professor.setSexo(panel.getSexo());
			professor.setSenha(panel.getTxtSenha().getText());
			
			
			this.verificarDados();
			
			panel.getTxtCPF().setText("");
			panel.getTxtNome().setText("");
			panel.getTxtSenha().setText("");
			panel.getTxtTelefone().setText("");
			
			break;

		case CPadrao.OPERACAO_ALTERAR:
			
			Professor funcionario = (Professor)this.objAlterar;
			
			professor.setNome(panel.getTxtNome().getText());
			professor.setCpf(panel.getTxtCPF().getText());
			professor.setTelefone(panel.getTxtTelefone().getText());
			professor.setSexo(panel.getSexo());
			professor.setSenha(panel.getTxtSenha().getText());
			
			//this.verificarDados();
			
			panel.getTxtCPF().setText("");
			panel.getTxtNome().setText("");
			panel.getTxtSenha().setText("");
			panel.getTxtTelefone().setText("");
			
			
			break;
		}



	}
	
	public static DefaultListModel getListDisciplinas(){
		Disciplina obDisciplina = new Disciplina();
		List disciplinas = obDisciplina.getAll();
		
		DefaultListModel disciplinaListModel = new DefaultListModel();
		
		for (int i=0; i<disciplinas.size();i++){
			
		Disciplina obDisciplina2 = (Disciplina) disciplinas.get(i);
		disciplinaListModel.addElement(obDisciplina2.getId()+" "+ obDisciplina2.getNome());
		 
			
		}
		return disciplinaListModel;
		
	}
	
	

	public void setProfessor(Professor professor) {
		this.professor = professor;
		
	}

}
   
