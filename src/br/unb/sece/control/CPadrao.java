package br.unb.sece.control;

import java.util.Iterator;
import java.util.List;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JPanel;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Serie;
import br.unb.sece.util.ICadastroPadrao;
import br.unb.sece.util.crudpadrao.ModeloDeTabela;
import br.unb.sece.view.VDisciplina;
import br.unb.sece.view.VPadrao;


public class CPadrao implements ICadastroPadrao   {
	
	private String classeModel;
	
	private List listaTabela;
	
	protected Object titulos[];
	
	protected Object[] metodos;
	
	private ModeloDeTabela modeloDeTabela;
	
	protected Object objAlterar;
	
	public CPadrao (String classeModel){
		
		this.classeModel = classeModel;
		this.definirTitulosEMetodos();
		//this.construirTabela();
		
	}
	
	public  void definirTitulosEMetodos(){
		Object[] titulos = {};
		
		this.titulos = titulos;
		
		Object [] metodos = {};
		
		this.metodos = metodos;
	}
	
	public Object getObjetoTabela(int row, int column)throws NullPointerException{
		return this.modeloDeTabela.getObjetoTabela(row, column);
	}
	
	public ModeloDeTabela getDefaultTableModel(){
		this.modeloDeTabela = new ModeloDeTabela(this.classeModel, this.titulos, this.metodos);
		return this.modeloDeTabela;
	}
	
	public Object[] getTitulos(){
		return this.titulos;
	}
	
	

	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		
	}
	
	public void verificarDados() throws Exception{
	}

	@Override
	public void excluir(Object obj) throws BancoDeDadosException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
		
	}
	
	public void receberDados(Object obj) throws Exception{
		
	}
	
	public void receberDados(Object obj,int operacao) throws Exception{
		
	}
	
	@Override
	public void passarDados() {
		// TODO Auto-generated method stub
		
	}

	
	
	public JPanel getPanelPadrao(Object obj){
		VPadrao frame = (VPadrao)obj;
		JPanel p = (JPanel)frame.getPanel();
		return p;
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}
	
	public void receberObjetoAlterar(Object objeto){
		this.objAlterar = objeto;
	}
	
	
	public static final int OPERACAO_INSERIR = 1;
	
	public static final int OPERACAO_ALTERAR = 2;

	

	
	
	
	
	
	

	
	
	

}
