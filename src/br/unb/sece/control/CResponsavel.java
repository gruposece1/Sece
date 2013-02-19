package br.unb.sece.control;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Responsavel;
import br.unb.sece.view.panelcadastropadrao.VCadResponsavel;

public class CResponsavel extends CPadrao{
	private Responsavel responsavel = new Responsavel();

	public CResponsavel() {
		super("br.unb.sece.model.Responsavel");
		// TODO Auto-generated constructor stub
	}
	
	public  void definirTitulosEMetodos(){
		final Object[] titulos = {"Nome","Cpf","Email"};
		
		
		this.titulos = titulos;
		
		final Object [] metodos = {"getNome","getCpf","getEmail"};
		
		this.metodos = metodos;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	
	@Override
	public void alterar(){
		final Responsavel r = (Responsavel) this.objAlterar;
		
		r.alterar();
	}

	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		this.responsavel.salvar();
		this.responsavel = new Responsavel();
	}

	@Override
	public void excluir(Object obj) throws BancoDeDadosException {
		// TODO Auto-generated method stub
		final Responsavel r = (Responsavel) obj;
		
		r.excluir();
	}

	@Override
	public void verificarDados() throws Exception {
		if(this.responsavel.getNome().equals(""))
			throw new AtributoNuloException();
	}
	
	public void receberDados(Object obj,int operacao) throws Exception{
		VCadResponsavel panel=null;
		
		if(obj==null)
			throw new AtributoNuloException();
		
		try	{
			panel = (VCadResponsavel) this.getPanelPadrao(obj);
		} catch(Exception e) {
			throw new AtributoInvalidoException();
		}
		
		switch(operacao) {
		case CPadrao.OPERACAO_INSERIR:
			this.responsavel.setNome(panel.getTextField().getText());
			this.responsavel.setCpf(panel.getTextField_1().getText());
			this.responsavel.setEndereco(panel.getTextField_2().getText());
			this.responsavel.setEmail(panel.getTextField_3().getText());
			this.responsavel.setTelefone(panel.getTextField_4().getText());
			this.responsavel.setCEP(panel.getTextField_5().getText());
	
			
			this.verificarDados();
			panel.getTextField().setText("");
			panel.getTextField();
	
			
			break;

		case CPadrao.OPERACAO_ALTERAR:
			final Responsavel r = (Responsavel) this.objAlterar;
			
			r.setNome(panel.getTextField().getText());
			//this.verificarDados();
			panel.getTextField().setText("");
			
			break;
	}
		
		
	}
	
}
