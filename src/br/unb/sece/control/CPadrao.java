package br.unb.sece.control;

import java.util.Iterator;
import java.util.List;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JPanel;

import br.unb.sece.model.Serie;
import br.unb.sece.util.ICadastroPadrao;
import br.unb.sece.view.VDisciplina;
import br.unb.sece.view.VPadrao;


public class CPadrao implements ICadastroPadrao   {
	
	private String classeModel;
	private List listaTabela;
	protected Object titulos[];
	protected Object[] metodos;
	private Object[][] dados;
 
	
	public CPadrao (String classeModel){
		
		this.classeModel = classeModel;
		this.definirTitulosEMetodos();
		this.construirTabela();
	}
	
	public  void definirTitulosEMetodos(){
		Object[] titulos = {};
		
		this.titulos = titulos;
		
		Object [] metodos = {};
		
		this.metodos = metodos;
	}
	
	public void construirTabela() {
		
		try {
			Class classe = Class.forName(this.classeModel);
			Object o = classe.newInstance();
			List lista = null;
			Method usar;
			for(Method m : classe.getMethods()){
				if(m.getName().equals("getAll")){
					usar = m;
					Object argumento = null;
					lista = (List)m.invoke(o,null);
				}
			} 
			dados = new Object[lista.size()][this.titulos.length+1];
			int linha = 0;
			for (Iterator iter = lista.iterator() ; iter. hasNext(); ){
				Object objetoAtual = iter.next();
				for (int i = 0; i<this.metodos.length; i++){
					
					String nomeMetodo = (String)this.metodos[i];
					try {
						Method m = objetoAtual.getClass().getDeclaredMethod(nomeMetodo, null);
						this.dados[linha][i] = m.invoke(objetoAtual, null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						this.dados[linha][i] = "";
					} 
					
					this.dados[linha][i+1] = objetoAtual;
					
				}
				
				linha++;
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	public Object[] getTitulos(){
		return this.titulos;
	}
	
	public Object[][] getDados(){
		return this.dados;
	}

	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		
	}
	
	public void verificarDados() throws Exception{
	}

	@Override
	public void excluir(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}
	
	public void receberDados(Object obj) throws Exception{
		
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

	

	
	
	
	
	
	

	
	
	

}
