package br.unb.sece.util.crudpadrao;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

public class ModeloDeTabela extends DefaultTableModel {
	
	private String classeModel;
	
	private Object titulos[];
	
	private Object[] metodos;
	
	private Object[][] dados;
	
	private String metodoBusca = "getAll";
	
	public ModeloDeTabela() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ModeloDeTabela(String classeModel, Object[] titulos, Object[] metodos) {
		super();
		this.construir(classeModel, titulos, metodos);
	}
	
	private void construir(String classeModel, Object[] titulos, Object[] metodos){
		this.classeModel = classeModel;
		this.titulos = titulos;
		this.metodos = metodos;
		this.construirTabela();
		this.setDataVector(this.dados, this.titulos);
	}
	
	public ModeloDeTabela(String classeModel, Object[] titulos, Object[] metodos, String metodoBusca) {
		super();
		this.setMetodoBusca(metodoBusca);
		this.construir(classeModel, titulos, metodos);
	}

	@Override
	public boolean isCellEditable(int row,int column){
		return false;
		
	}
	
	
	/**
	 * Recuperar dados da tabela 
	 */
	public void construirTabela() {
		
		assert(this.titulos.length > 0);
		
		assert(this.metodos.length == this.titulos.length);
		
		try {
			Class classe = Class.forName(this.classeModel);
			Object objDaClasseModel = classe.newInstance();
			List lista = null;
			Method usar;
			for(Method m : classe.getMethods()){
				if(m.getName().equals(this.metodoBusca)){
					System.out.println(this.metodoBusca);
					lista = (List)m.invoke(objDaClasseModel,null);
				}
			} 
			
			
			assert(lista != null);
			
			assert(lista.size() > 0);
			
			dados = new Object[lista.size()][this.titulos.length+1];
			
			int linhaTabela = 0;
			for (Iterator iter = lista.iterator() ; iter. hasNext(); ){
				Object objetoAtual = iter.next();
				int colunaTabela = 0;
				for (colunaTabela = 0; colunaTabela < this.metodos.length; colunaTabela++){
					
					String nomeMetodo = (String)this.metodos[colunaTabela];
					try {
						Method method = this.getMetodo(objetoAtual.getClass().getMethods(), nomeMetodo);
						this.dados[linhaTabela][colunaTabela] = method.invoke(objetoAtual, null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						this.dados[linhaTabela][colunaTabela] = "";
					} 
					
					
				}
				this.dados[linhaTabela][colunaTabela] = objetoAtual;
				
				linhaTabela++;
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.dados = null;
			e.printStackTrace();
		} 
		
		
		
		
	}
	
	public Object getObjetoTabela(int row, int column) throws NullPointerException{
		
		return this.dados[row][column];
	}

	public Object[][] getDados() {
		return dados;
	}

	public void setDados(Object[][] dados) {
		this.dados = dados;
	}
	
	private Method getMetodo(Method[] todosMetodosDaClasse,String metodoBusca){
   	 Method metodoARetornar = null;
   	 for(Method metodo : todosMetodosDaClasse){
   		 if(metodo.getName().equals(metodoBusca)){
   			 metodoARetornar = metodo;
   		 }
   	 }
   	 return metodoARetornar;
    }


	public String getMetodoBusca() {
		return metodoBusca;
	}


	public void setMetodoBusca(String metodoBusca) {
		this.metodoBusca = metodoBusca;
	}
	
	
	
	
	
	
}
