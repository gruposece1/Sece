package br.unb.sece.control;
import java.util.ArrayList;
import java.util.List;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Responsavel;
import br.unb.sece.model.Serie;
import br.unb.sece.util.ColunaPesquisa;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;
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
		//this.obSerie = new Serie();

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

		VCadSerie panel1 = new VCadSerie();
		
		if(obj==null)
			throw new AtributoInvalidoException();
		try{
			panel1 = (VCadSerie)this.getPanelPadrao(obj);
		} catch(Exception e){
			throw new AtributoInvalidoException();
		}
			
		
		switch(operacao){
			case CPadrao.OPERACAO_INSERIR:
				obSerie.setNome(panel1.getTxtNome().getText());
				obSerie.setQtdeHorarios(Integer.parseInt(String.valueOf(panel1.getCBHorario().getSelectedItem())));
				obSerie.setQtdeDias(Integer.parseInt(String.valueOf(panel1.getCBDias().getSelectedItem())));
				this.verificarDados();
			
				break;
	
			case CPadrao.OPERACAO_ALTERAR:
				Serie objSerie = (Serie)this.objAlterar;
				
				objSerie.setNome(panel1.getTxtNome().getText());
				objSerie.setQtdeHorarios(Integer.parseInt(String.valueOf(panel1.getCBHorario().getSelectedItem())));
				objSerie.setQtdeDias(Integer.parseInt(String.valueOf(panel1.getCBDias().getSelectedItem())));
				
				//this.verificarDados();
				panel1.getTxtNome().setText("");
				
				break;
		}
		
	}
	
	public void setSerie(Serie serie){
		this.obSerie = serie;
		
	}
	
}

