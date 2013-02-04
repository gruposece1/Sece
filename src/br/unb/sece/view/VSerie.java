package br.unb.sece.view;

import br.unb.sece.control.CDisciplina;
import br.unb.sece.control.CSerie;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Serie;
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
	
	@Override
	public void alterar() {
		// TODO Auto-generated method stub
	}



	@Override
	public void passarDados() throws Exception {
		// TODO Auto-generated method stub
		this.controle.receberDados(this);
		
	}



	@Override
	public void popularInterface() {
		// TODO Auto-generated method stub
		Serie obSerie = (Serie)this.retonarObjetoGrade();
		VCadSerie vc = (VCadSerie)this.panel;
		vc.getTextField().setText(obSerie.getNome());
		
		
		try {
			this.controle.receberObjetoAlterar(obSerie);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		obSerie.setNome(panel.getTxtNome().getText());
		obSerie.setQtdeHorarios(Integer.parseInt(String.valueOf(panel.getCBHorario().getSelectedItem())));
		obSerie.setQtdeDias(Integer.parseInt(String.valueOf(panel.getCBDias().getSelectedItem())));*/
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}


}
