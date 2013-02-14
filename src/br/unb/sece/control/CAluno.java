package br.unb.sece.control;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Responsavel;
import br.unb.sece.util.ColunaPesquisa;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;

import java.util.ArrayList;
import java.util.List;



public class CAluno extends CPadrao{

	private Aluno aluno;
	
	public CAluno() {
		super("br.unb.sece.model.Aluno");
		this.aluno = new Aluno();
	}
	
	public void definirTitulosEMetodos() {
		final Object[] titulos = {"Nome", "Sexo", "Matricula", "Ano de Nascimento"};
		final Object [] metodos = {"getNome", "getSexo", "getMatricula", "getDtNascimento"};
		this.titulos = titulos;
		this.metodos = metodos;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public void salvar() {
		this.aluno.salvar();
		
	}
	
	
	public void excluir(Object obj) throws BancoDeDadosException {
		final Aluno a = (Aluno) obj;
		
		a.excluir();
	}
	
	@Override
	public void verificarDados() throws Exception {
		if(this.aluno.getNome().equals("")) 
			throw new AtributoNuloException();
		
		if(this.aluno.getDtNascimento().equals(""))
			throw new AtributoNuloException();
		
		if(this.aluno.getMatricula().equals(""))
			throw new AtributoNuloException();
		
		if(this.aluno.getResponsaveis().isEmpty())
			throw new AtributoNuloException();
		
		if(this.aluno.getResponsaveis().size()>2)
			throw new AtributoInvalidoException("Numero de responsaveis invalido");
	}
	
	public void receberDados(Object obj, int operacao) throws Exception {
		VCadAluno panel = new VCadAluno();
		
		if(obj == null)
			throw new AtributoInvalidoException();
	
		try {
			panel = (VCadAluno) this.getPanelPadrao(obj);
		} catch(Exception e) {
			throw new AtributoInvalidoException();
		}
			
		switch(operacao){
			case CPadrao.OPERACAO_INSERIR:
				final ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
				
				this.aluno.setNome(panel.getTxtNome().getText());
				this.aluno.setMatricula(panel.getTxtMatricula().getText());
				this.aluno.setDtNascimento(panel.getTxtNascimento().getText());
				this.aluno.setSexo(panel.getSexo());
				this.aluno.setResponsaveis(panel.getResponsavel());
				
				this.verificarDados();
				
				panel.getTxtMatricula().setText("");
				panel.getTxtNome().setText("");
				panel.getTxtNascimento().setText("");
				panel.getTxtMae().setText("");
				panel.getTxtPai().setText("");
				
				break;

			case CPadrao.OPERACAO_ALTERAR:
				final Aluno aluno = (Aluno) this.objAlterar;
				
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
		final ArrayList<ColunaPesquisa> camposTabela = new ArrayList<ColunaPesquisa>();
		final ColunaPesquisa nome = new ColunaPesquisa("Nome", "getNome");
		final ColunaPesquisa cpf = new ColunaPesquisa("CPF", "getCPF");
		
		camposTabela.add(nome);
		camposTabela.add(cpf);
		
		return camposTabela;
	}

	public List getResponsaveis() {
		final Responsavel responsavel = new Responsavel();
		return responsavel.getAll();
	}

}
