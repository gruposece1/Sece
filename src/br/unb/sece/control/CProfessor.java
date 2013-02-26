package br.unb.sece.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;


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
	
	protected CProfessor(String classeModel) {
		super(classeModel);
		
	}
	
	public CProfessor() {
		super("br.unb.sece.model.Professor");
		
		this.professor= new Professor();
	}
	
	public void definirTitulosEMetodos() {
		
		final Object[] titulos = {"Nome","CPF","Telefone"};
		
		this.titulos = titulos;
		
		Object [] metodos = {"getNome", "getCpf","getTelefone"};
		
		this.metodos = metodos;
		
	}

	
	
	public Professor getProfessor() {
		return professor;
	}

	public void setFuncionario(Professor professor) {
		this.professor = professor;
	}
	
	public void definirMetodoBusca(){
		
		this.metodoBusca = "getAll";
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
			
			this.professor.setNome(panel.getTxtNome().getText());
			this.professor.setCpf(panel.getTxtCPF().getText());
			this.professor.setTelefone(panel.getTxtTelefone().getText());
			this.professor.setSexo(panel.getSexo());
			this.professor.setSenha(panel.getTxtSenha().getText());
			
			List listaDisciplinas = panel.getDisciplinasParaCadastrar();
			List ListaDisciplinas2 = Disciplina.getString2Disciplina(listaDisciplinas);
			this.professor.setDisciplinas(ListaDisciplinas2);
			
			this.verificarDados();
			
			panel.getTxtCPF().setText("");
			panel.getTxtNome().setText("");
			panel.getTxtSenha().setText("");
			panel.getTxtTelefone().setText("");
			panel.getList_2().setModel(new DefaultListModel());
			panel.getList_1().setModel(CProfessor.getListDisciplinas());
			
			break;

		case CPadrao.OPERACAO_ALTERAR:
			
			Professor professor = (Professor)this.objAlterar;
			
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
			panel.getList_2().setModel(new DefaultListModel());
			panel.getList_1().setModel(CProfessor.getListDisciplinas());
			
			
			break;
		}



	}
	
	public static DefaultListModel getListDisciplinas(){
		Disciplina obDisciplina = new Disciplina();
		List disciplinas = obDisciplina.getAll();
		
		
		return CProfessor.getDefaultListModel(disciplinas);
		
	}
	
	public static DefaultListModel getDefaultListModel(Collection disciplinas){
		DefaultListModel disciplinaListModel = new DefaultListModel();
		Iterator inDisciplinas = disciplinas.iterator();
		while(inDisciplinas.hasNext()){
			Disciplina obDisciplina = (Disciplina)inDisciplinas.next();
			disciplinaListModel.addElement(obDisciplina.getId()+" "+ obDisciplina.getNome());
		}
		return disciplinaListModel;
	}
	
	public static DefaultListModel getDefaultListModelDisciplinasMenosADoProfessor(Collection disciplinasProfessor){
		Disciplina obDisciplina = new Disciplina();
		List disciplinas = obDisciplina.getAll();
		disciplinas.removeAll(disciplinasProfessor);
		return CProfessor.getDefaultListModel(disciplinas);
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
		
	}
		
		

}
   
