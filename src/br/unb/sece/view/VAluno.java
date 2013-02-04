package br.unb.sece.view;

import br.unb.sece.control.CAluno;
import br.unb.sece.control.CDisciplina;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;

public class VAluno extends VPadrao {

	public VAluno() {
		super();
		this.setTitle("Cadastro de Aluno");
	}
	
	@Override
	public void criarControle() {
		this.controle= new CAluno();
		
	}

	@Override
	public void criarPainel() {
		VCadAluno painel = new VCadAluno();
		this.panel = painel;
		
	}

	@Override
	public void popularInterface() {

		Aluno a = (Aluno)this.retonarObjetoGrade();
		VCadAluno va = (VCadAluno)this.panel;
		//va.getTextField().setText(a.getNome());
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
