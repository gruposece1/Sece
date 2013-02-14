package br.unb.sece.view;

import br.unb.sece.control.CFuncionario;
import br.unb.sece.control.CProfessor;
import br.unb.sece.model.Funcionario;
import br.unb.sece.model.Professor;
import br.unb.sece.view.panelcadastropadrao.VCadFuncionario;
import br.unb.sece.view.panelcadastropadrao.VCadProfessor;
import javax.swing.JScrollPane;

public class VProfessor extends VPadrao {
	
	public VProfessor(){
		super();
		this.setTitle("Cadastro de Professor");
		
	}

	public void criarControle() {
		this.controle= new CProfessor();
		
	}

	@Override
	public void criarPainel() {
		VCadProfessor painel = new VCadProfessor();
		this.panel = painel;
		
	}

	@Override
	public void popularInterface() {

		Professor professor = (Professor)this.retonarObjetoGrade();
		VCadProfessor vf = (VCadProfessor)this.panel;
		//va.getTextField().setText(a.getNome());
		vf.getTxtNome().setText(professor.getNome());
		vf.getTxtCPF().setText(professor.getCpf());
		vf.getTxtTelefone().setText(professor.getTelefone());
		vf.getTxtSenha().setText(professor.getSenha());
		
		if(professor.getSexo().equals("Feminino"))
			vf.getRdbtFeminino().setSelected(true);
		else
			vf.getRdbtMasculino().setSelected(true);
		
		
		//falta fazer
		try {
			this.controle.receberObjetoAlterar(professor);
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
