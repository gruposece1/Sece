package br.unb.sece.view;

import br.unb.sece.control.CResponsavel;
import br.unb.sece.view.panelcadastropadrao.VCadResponsavel;

public class VResponsavel extends VPadrao{

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void criarControle() {
		// TODO Auto-generated method stub
		this.controle = new CResponsavel();
		
	}

	@Override
	public void criarPainel() {
		// TODO Auto-generated method stub
		this.panel = new VCadResponsavel();
		
	}

	@Override
	public void popularInterface() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passarDados() throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
