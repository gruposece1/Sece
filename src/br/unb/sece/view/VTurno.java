package br.unb.sece.view;

import javax.swing.JPanel;

import br.unb.sece.control.CTurno;
import br.unb.sece.model.Turno;
import br.unb.sece.view.panelcadastropadrao.VCadTurno;

public class VTurno extends VPadrao {

	/**
	 * Create the panel.
	 */
	public VTurno() {
		super();
		this.setTitle("Cadastro de Turno");

	}
	
	public void criarControle() {
		// TODO Auto-generated method stub
		this.controle= new CTurno();
		
	}

	@Override
	public void criarPainel() {
		// TODO Auto-generated method stub
		VCadTurno painel = new VCadTurno();
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
		Turno d = (Turno)this.retonarObjetoGrade();
		VCadTurno vc = (VCadTurno)this.panel;
		vc.getTxtInicio().setText(String.valueOf(d.getInicio()));
		vc.getTxtFim().setText(String.valueOf(d.getFim()));
		vc.getCBTipo().setSelectedIndex(CTurno.getIndiceTurno(d.getTurno()));
		//falta fazer
		try {
			this.controle.receberObjetoAlterar(d);
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



	
	
	

}
