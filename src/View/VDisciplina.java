package View;

import Model.Disciplina;
import View.PanelCadastroPadrao.VCadDisciplina;
import Control.CDisciplina;

public class VDisciplina extends VPadrao {
	
	public VDisciplina (){
		
		super();
		this.setTitle("Cadastro de Disciplina");
	}

	

	@Override
	public void criarControle() {
		// TODO Auto-generated method stub
		this.controle= new CDisciplina();
		
		
		
	}

	@Override
	public void criarPainel() {
		// TODO Auto-generated method stub
		VCadDisciplina painel = new VCadDisciplina();
		this.panel = painel;
		
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
		// TODO Auto-generated method stub
		this.controle.receberDados(this);
		
	}



	@Override
	public void popularInterface() {
		// TODO Auto-generated method stub
		Disciplina d = (Disciplina)this.retonarObjetoGrade();
		VCadDisciplina vc = (VCadDisciplina)this.panel;
		vc.getTextField().setText(d.getNome());
		
		
	}



	
	
	

}
