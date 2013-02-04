package br.unb.sece.view;

import java.util.ArrayList;

import br.unb.sece.control.CAluno;
import br.unb.sece.control.CDisciplina;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Responsavel;
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
		va.getTxtNome().setText(a.getNome());
		va.getTxtMatricula().setText(a.getMatricula());
		va.getTxtNascimento().setText(a.getDtNascimento());
		
		if(a.getSexo().equals("Feminino"))
			va.getRdbtFeminino().setSelected(true);
		else
			va.getRdbtMasculino().setSelected(true);
		
		ArrayList<Responsavel> responsavel = new ArrayList<Responsavel>(a.getResponsaveis());
		
		if(responsavel.size()==1)
		{	
			if(responsavel.get(0).getSexo().equals("Feminino"))
				va.getTxtMae().setText(responsavel.get(0).getNome());
			else
				va.getTxtPai().setText(responsavel.get(0).getNome());
		}
		else if(!responsavel.get(0).getSexo().equals(responsavel.get(1).getSexo()))
		{
			if(responsavel.get(0).getSexo().equals("Feminino"))
				va.getTxtMae().setText(responsavel.get(0).getNome());
			else if(responsavel.get(0).getSexo().equals("Masculino"))
				va.getTxtPai().setText(responsavel.get(0).getNome());
			else if(responsavel.get(1).getSexo().equals("Feminino"))
				va.getTxtMae().setText(responsavel.get(1).getNome());
			else
				va.getTxtPai().setText(responsavel.get(1).getNome());
		}
		else
		{
			va.getTxtMae().setText(responsavel.get(0).getNome());
			va.getTxtPai().setText(responsavel.get(1).getNome());
		}	
		
		//falta fazer
		try {
			this.controle.receberObjetoAlterar(a);
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
