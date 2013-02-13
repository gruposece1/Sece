package br.unb.sece.view;

import java.util.ArrayList;

import br.unb.sece.control.CFuncionario;
import br.unb.sece.model.Funcionario;
import br.unb.sece.view.panelcadastropadrao.VCadFuncionario;
import br.unb.sece.view.panelcadastropadrao.VCadProfessor;

public class VFuncionario extends VPadrao {

	public VFuncionario() {
		super();
		this.setTitle("Cadastro de Funcionario");
	}
	
	@Override
	public void criarControle() {
		this.controle= new CFuncionario();
		
	}

	@Override
	public void criarPainel() {
		VCadFuncionario painel = new VCadFuncionario();
		this.panel = painel;
		
	}

	@Override
	public void popularInterface() {

		Funcionario funcionario = (Funcionario)this.retonarObjetoGrade();
		VCadFuncionario vf = (VCadFuncionario)this.panel;
		//va.getTextField().setText(a.getNome());
		vf.getTxtNome().setText(funcionario.getNome());
		vf.getTxtCPF().setText(funcionario.getCpf());
		vf.getTxtTelefone().setText(funcionario.getTelefone());
		vf.getTxtSenha().setText(funcionario.getSenha());
		
		if(funcionario.getSexo().equals("Feminino"))
			vf.getRdbtFeminino().setSelected(true);
		else
			vf.getRdbtMasculino().setSelected(true);
		
		vf.getCBCargo().setSelectedItem(funcionario.getTipoFuncionario());
		
		//falta fazer
		try {
			this.controle.receberObjetoAlterar(funcionario);
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
