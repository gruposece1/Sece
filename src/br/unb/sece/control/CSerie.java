package br.unb.sece.control;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Serie;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;
import br.unb.sece.view.panelcadastropadrao.VCadSerie;

public class CSerie extends CPadrao {
	private Serie obSerie;
	
	public CSerie() {
		super("br.unb.sece.model.Serie");
		this.obSerie = new Serie();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void definirTitulosEMetodos() {
		// TODO Auto-generated method stub
		Object[] titulos = {"Nome","Qtde Horários","Qtde Dias"};

		this.titulos = titulos;

		Object [] metodos = {"getNome","getQtdeHorarios","getQtdeDias"};

		this.metodos = metodos;

	}
	
	@Override
	public void alterar(){
		Serie d = (Serie)this.objAlterar;
		d.alterar();
	}

	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		this.obSerie.salvar();
		this.obSerie = new Serie();

	}

	@Override
	public void excluir(Object obj) throws BancoDeDadosException {
		// TODO Auto-generated method stub
		Serie objSerie = (Serie)obj;
		objSerie.excluir();

	}

	@Override
	public void verificarDados() throws Exception{

		if(this.obSerie.getNome().equals("")){
			throw new AtributoNuloException();
		}
	}
	
	public void receberDados(Object obj,int operacao) throws Exception{
		VCadSerie panel = (VCadSerie)this.getPanelPadrao(obj);
		
		switch(operacao){
			case CPadrao.OPERACAO_INSERIR:
				obSerie.setNome(panel.getTxtNome().getText());
				obSerie.setQtdeHorarios(Integer.parseInt(String.valueOf(panel.getCBHorario().getSelectedItem())));
				obSerie.setQtdeDias(Integer.parseInt(String.valueOf(panel.getCBDias().getSelectedItem())));
				this.verificarDados();
			   // panel.getTextField().setText("");
			    
			    //Tem que limpar o JComboBox depois
			   // panel.getTextField().setText("");
				break;
	
			case CPadrao.OPERACAO_ALTERAR:
				Serie objSerie = (Serie)this.objAlterar;
				
				objSerie.setNome(panel.getTxtNome().getText());
				objSerie.setQtdeHorarios(Integer.parseInt(String.valueOf(panel.getCBHorario().getSelectedItem())));
				objSerie.setQtdeDias(Integer.parseInt(String.valueOf(panel.getCBDias().getSelectedItem())));
				
				//this.verificarDados();
				panel.getTextField().setText("");
				
				break;
		}
		


	}



}
