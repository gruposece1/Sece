package br.unb.sece.control;

import java.util.ArrayList;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Funcionario;
import br.unb.sece.model.Responsavel;
import br.unb.sece.view.panelcadastropadrao.VCadFuncionario;

public class CFuncionario extends CPadrao{

	private Funcionario funcionario;
	
	public CFuncionario() {
		super("br.unb.sece.model.Funcionario");
		
		this.funcionario = new Funcionario();
	}
	
	public void definirTitulosEMetodos() {
		
		Object[] titulos = {"Nome", "CPF", "Cargo", "Telefone"};
		
		this.titulos = titulos;
		
		Object [] metodos = {"getNome", "getCPF", "getTipoFuncionario", "getTelefone"};
		
		this.metodos = metodos;
		
	}

	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void salvar() {
		this.funcionario.salvar();
		this.funcionario = new Funcionario();
		
	}
	
	
	public void excluir(Object obj) throws BancoDeDadosException {
		Funcionario funcionario = (Funcionario)obj;
		funcionario.excluir();
		
	}
	
	@Override
	public void verificarDados() throws Exception{
		
		if(this.funcionario.getNome().equals("")){
			throw new AtributoNuloException();
		}
		
		if(this.funcionario.getCpf().equals(""))
			throw new AtributoNuloException();
		
		if(this.funcionario.getSenha().equals(""))
			throw new AtributoNuloException();
		
		if(this.funcionario.getTelefone().equals("")){
			throw new AtributoNuloException();
		}
		
	}
	
	@Override
	public void definirMetodoBusca(){
		this.metodoBusca = "listCordenadoresSecretarias";
	}
	
	public void receberDados(Object obj, int operacao) throws Exception{
		
		VCadFuncionario panel=new VCadFuncionario();
		
		if(obj==null)
			throw new AtributoInvalidoException();
	
		
		try
		{
			panel = (VCadFuncionario)this.getPanelPadrao(obj);
		} catch(Exception e)
		{
			throw new AtributoInvalidoException();
		}
			
		switch(operacao){
		case CPadrao.OPERACAO_INSERIR:
			
			ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
			
			funcionario.setNome(panel.getTxtNome().getText());
			funcionario.setCpf(panel.getTxtCPF().getText());
			funcionario.setTelefone(panel.getTxtTelefone().getText());
			funcionario.setSexo(panel.getSexo());
			funcionario.setSenha(panel.getTxtSenha().getText());
			funcionario.setTipoFuncionario(panel.getCargo());
			
			this.verificarDados();
			
			panel.getTxtCPF().setText("");
			panel.getTxtNome().setText("");
			panel.getTxtSenha().setText("");
			panel.getTxtTelefone().setText("");
			
			break;

		case CPadrao.OPERACAO_ALTERAR:
			
			Funcionario funcionario = (Funcionario)this.objAlterar;
			
			funcionario.setNome(panel.getTxtNome().getText());
			funcionario.setCpf(panel.getTxtCPF().getText());
			funcionario.setTelefone(panel.getTxtTelefone().getText());
			funcionario.setSexo(panel.getSexo());
			funcionario.setSenha(panel.getTxtSenha().getText());
			funcionario.setTipoFuncionario(panel.getCargo());
			//this.verificarDados();
			
			panel.getTxtCPF().setText("");
			panel.getTxtNome().setText("");
			panel.getTxtSenha().setText("");
			panel.getTxtTelefone().setText("");
			
			
			break;
		}
		
	}

	



	
}
