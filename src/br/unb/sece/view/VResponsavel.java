package br.unb.sece.view;

import br.unb.sece.control.CResponsavel;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Serie;
import br.unb.sece.view.panelcadastropadrao.VCadProfessor;
import br.unb.sece.view.panelcadastropadrao.VCadResponsavel;
import br.unb.sece.view.panelcadastropadrao.VCadSerie;

public class VResponsavel extends VPadrao{

	

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
		Responsavel responsavel = (Responsavel)this.retonarObjetoGrade();
		VCadResponsavel vc = (VCadResponsavel)this.panel;
		vc.getTxtNome().setText(responsavel.getNome());
	
		
		try {
			this.controle.receberObjetoAlterar(responsavel);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passarDados() throws Exception {
		
		this.controle.receberDados(this);
	}
	

}
