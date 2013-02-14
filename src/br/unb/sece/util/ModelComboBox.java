package br.unb.sece.util;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import br.unb.sece.model.Disciplina;


public class ModelComboBox extends AbstractListModel implements ComboBoxModel {

	static final int INDICE_TEXTO = 0; //usado para recuperar o id no array
	
	private List elements;
	
	private Object selectedItem;
	
	private HashMap<Long,Object> elements2;
	
	private ArrayList<Long> mapeamento;
	
	private String metodoId;
	
	private String metodoDesc;
	
	public ModelComboBox(){
		this.elements = new ArrayList();
	} 
	
	
	
	public ModelComboBox(List elementos, String metodoId, String metodoDesc){
		this.metodoId = metodoId;
		this.metodoDesc = metodoDesc;
		this.gerarElements2(elementos, this.metodoId);
	}
	
	private void gerarElements2(List elementos,String metodoId){
		assert(elementos != null);
		this.elements2 = new HashMap<Long, Object>();
		this.mapeamento = new ArrayList<Long>();
		for(int i = 0; i < elementos.size();i++){
			Object objeto = elementos.get(i);
			Long id = (long) 0;
			try {
				id = (Long) objeto.getClass().getMethod(metodoId, null).invoke(objeto, null);
				
			} catch (Exception e) {
				e.printStackTrace();
				id = (long) this.elements2.size();
			} 
			
			this.elements2.put(id,objeto);
			this.mapeamento.add(id);
			
		
		}
		
	}
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		Long id = this.mapeamento.get(index);
		//return this.elements2.get(index);
		Object objeto = this.elements2.get(id);
		
		return this.getTextObject(objeto);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		//return this.elements2.size();
		return this.mapeamento.size();
	}
	
	private String getTextObject(Object objeto){
		String texto = " ";
		try{
			Long id = Long.valueOf(String.valueOf(objeto.getClass().getMethod(this.metodoId, null).invoke(objeto, null)));
			String stringTexto = (String)objeto.getClass().getMethod(this.metodoDesc, null).invoke(objeto, null);
			texto =  id + " - " + stringTexto;
		}catch(Exception e){
			texto = " ";
			//e.printStackTrace();
		}
		
		return texto;
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		if(this.selectedItem != null){
			System.out.println(this.selectedItem.toString());
			return this.getTextObject(this.selectedItem);
		}else{
			return null;
		}
	}
	
	public Object getSelectedItemObject(){
		return this.selectedItem;
	}

	@Override
	public void setSelectedItem(Object obj) {
		// TODO Auto-generated method stub
		String texto = obj.toString();
		String[] textoQuebrado =  texto.split(" - ");
		Long id = Long.parseLong(textoQuebrado[INDICE_TEXTO]);
		
		
		this.selectedItem = this.elements2.get(id);
		
	}
	
	
		
}
