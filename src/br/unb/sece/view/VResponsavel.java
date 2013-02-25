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
		  final Responsavel responsavel = (Responsavel)this.retonarObjetoGrade();
		  VCadResponsavel vc = (VCadResponsavel)this.panel;
		  
		  vc.getTextField().setText(responsavel.getNome());
		  vc.getTextField_1().setText(responsavel.getCpf());
		  vc.getTextField_2().setToolTipText(responsavel.getSexo());
		  vc.getTextField_3().setText(responsavel.getEmail());
		  vc.getTextField_4().setText(responsavel.getTelefone());
		  vc.getTextField_5().setText(responsavel.getCEP());

		  
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
