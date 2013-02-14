package br.unb.sece.control;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;

public class CDisciplina extends CPadrao {

	private Disciplina disciplina;
	

	public CDisciplina() {
		super("br.unb.sece.model.Disciplina");
		// TODO Auto-generated constructor stub
		this.disciplina = new Disciplina();
	}

	@Override
	public void definirTitulosEMetodos() {
		// TODO Auto-generated method stub
		final Object[] titulos = {"Nome"};
		this.titulos = titulos;
		final Object [] metodos = {"getNome"};
		this.metodos = metodos;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public void alterar(){
		final Disciplina d = (Disciplina) this.objAlterar;
		
		d.alterar();
	}

	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		this.disciplina.salvar();
		this.disciplina = new Disciplina();
	}

	@Override
	public void excluir(Object obj) throws BancoDeDadosException {
		// TODO Auto-generated method stub
		final Disciplina d = (Disciplina) obj;
		
		d.excluir();
	}

	@Override
	public void verificarDados() throws Exception {
		if(this.disciplina.getNome().equals(""))
			throw new AtributoNuloException();
	}

	/*public void receberDados(Object obj) throws Exception{
		
		VCadDisciplina panel=null;
		
		if(obj==null)
			throw new AtributoNuloException();
		try
		{
			panel = (VCadDisciplina)this.getPanelPadrao(obj);
		}
		catch(Exception e)
		{
			throw new AtributoInvalidoException();
		}
		
		disciplina.setNome(panel.getTextField().getText());
		this.verificarDados();
		panel.getTextField().setText("");


	}*/

	public void receberDados(Object obj, int operacao) throws Exception{
		VCadDisciplina panel=null;
		
		if(obj==null)
			throw new AtributoNuloException();
		
		try	{
			panel = (VCadDisciplina) this.getPanelPadrao(obj);
		} catch(Exception e) {
			throw new AtributoInvalidoException();
		}
		
		switch(operacao) {
			case CPadrao.OPERACAO_INSERIR:
				this.disciplina.setNome(panel.getTextField().getText());
				
				this.verificarDados();
				panel.getTextField().setText("");
				
				break;
	
			case CPadrao.OPERACAO_ALTERAR:
				final Disciplina d = (Disciplina) this.objAlterar;
				
				d.setNome(panel.getTextField().getText());
				//this.verificarDados();
				panel.getTextField().setText("");
				
				break;
		}
	}

}
