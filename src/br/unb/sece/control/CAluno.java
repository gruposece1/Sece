package br.unb.sece.control;

import java.util.ArrayList;
import java.util.List;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Responsavel;
import br.unb.sece.util.ColunaPesquisa;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;

public class CAluno extends CPadrao{

	private Aluno aluno;
	
	public CAluno() {
		super("br.unb.sece.model.Aluno");
		
		this.aluno = new Aluno();
	}
	
	public void definirTitulosEMetodos() {
		
		Object[] titulos = {"Nome", "Sexo", "Matricula", "Ano de Nascimento"};
		
		this.titulos = titulos;
		
		Object [] metodos = {"getNome", "getSexo", "getMatricula", "getDtNascimento"};
		
		this.metodos = metodos;
		
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void salvar() {
		this.aluno.salvar();
		
	}
	
	
	public void excluir(Object obj) throws BancoDeDadosException {
		Aluno a = (Aluno)obj;
		a.excluir();
		
	}
	
	@Override
	public void verificarDados() throws Exception{
		
		if(this.aluno.getNome().equals("")){
			throw new AtributoNuloException();
		}
		
		if(this.aluno.getDtNascimento().equals(""))
			throw new AtributoNuloException();
		
		if(this.aluno.getMatricula().equals(""))
			throw new AtributoNuloException();
		
		if(this.aluno.getResponsaveis().isEmpty())
			throw new AtributoNuloException();
		
		if(this.aluno.getResponsaveis().size()>2)
			throw new AtributoInvalidoException("Numero de responsaveis invalido");
	}
	
	public void receberDados(Object obj, int operacao) throws Exception{
		
		VCadAluno panel=new VCadAluno();
		
		if(obj==null)
			throw new AtributoInvalidoException();
	
		
		try
		{
			panel = (VCadAluno)this.getPanelPadrao(obj);
		} catch(Exception e)
		{
			throw new AtributoInvalidoException();
		}
			
		switch(operacao){
		case CPadrao.OPERACAO_INSERIR:
			
			ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
			
			aluno.setNome(panel.getTxtNome().getText());
			aluno.setMatricula(panel.getTxtMatricula().getText());
			aluno.setDtNascimento(panel.getTxtNascimento().getText());
			aluno.setSexo(panel.getSexo());
			aluno.setResponsaveis(panel.getResponsavel());
			
			this.verificarDados();
			
			panel.getTxtMatricula().setText("");
			panel.getTxtNome().setText("");
			panel.getTxtNascimento().setText("");
			panel.getTxtMae().setText("");
			panel.getTxtPai().setText("");
			
			break;

		case CPadrao.OPERACAO_ALTERAR:
			Aluno aluno = (Aluno)this.objAlterar;
			aluno.setNome(panel.getTxtNome().getText());
			aluno.setMatricula(panel.getTxtMatricula().getText());
			aluno.setDtNascimento(panel.getTxtNascimento().getText());
			aluno.setSexo(panel.getSexo());
			aluno.setResponsaveis(panel.getResponsavel());
			//this.verificarDados();
			
			panel.getTxtMatricula().setText("");
			panel.getTxtNome().setText("");
			panel.getTxtNascimento().setText("");
			panel.getTxtMae().setText("");
			panel.getTxtPai().setText("");
			
			break;
		}
		
	}

	
	public ArrayList<ColunaPesquisa> gerarNomeColunas() {
		ArrayList<ColunaPesquisa> camposTabela = new ArrayList<ColunaPesquisa>();
		ColunaPesquisa nome = new ColunaPesquisa("Nome", "getNome");
		ColunaPesquisa cpf = new ColunaPesquisa("CPF", "getCPF");
		camposTabela.add(nome);
		camposTabela.add(cpf);
		return camposTabela;
	}



	public List getResponsaveis() {
		Responsavel responsavel = new Responsavel();
		return responsavel.getAll();
	}
}
