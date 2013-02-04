package br.unb.sece.view;

import br.unb.sece.control.CDisciplina;
import br.unb.sece.control.CSerie;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;
import br.unb.sece.view.panelcadastropadrao.VCadSerie;

public class VSerie extends VPadrao{
	
	
	public VSerie(){
		super();
		this.setTitle("Cadastro de Serie");
		
	}
	
	@Override
	public void criarControle() {
		// TODO Auto-generated method stub
		this.controle= new CSerie();
		
	}

	@Override
	public void criarPainel() {
		// TODO Auto-generated method stub
		VCadSerie painel = new VCadSerie();
		this.panel = painel;
		
	}


}
