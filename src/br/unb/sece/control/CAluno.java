package br.unb.sece.control;

import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;

public class CAluno extends CPadrao{

	private Aluno aluno;
	
	public CAluno() {
		super("br.unb.sece.model.Aluno");
		
		this.aluno = new Aluno();
	}
	
	public void definirTitulosEMetodos() {
		// TODO Auto-generated method stub
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
	}
	
	public void receberDados(Object obj) throws Exception{
		
		VCadAluno panel = (VCadAluno)this.getPanelPadrao(obj);
		
		aluno.setNome(panel.getTxtNome().getText());
		aluno.setDtNascimento(panel.getTxtNascimento().getText());
		aluno.setMatricula(panel.getTxtMatricula().getText());
		aluno.setSexo(panel.getSexo());
		
		this.verificarDados();
		
		panel.getTxtNome().setText("");
		panel.getTxtMatricula().setText("");
		panel.getTxtNascimento().setText("");
		
	}

}
