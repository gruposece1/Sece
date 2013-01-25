package br.unb.sece.util;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import br.unb.sece.model.Disciplina;


public class ModelComboBox extends AbstractListModel implements ComboBoxModel {

	private List elements;
	
	private Object selectedItem;
	
	private HashMap<Long,Object> elements2;
	
	public ModelComboBox(){
		this.elements = new ArrayList();
	}
	
	public ModelComboBox(List elementos){
		this.elements = elementos;
		/*
		this.elements2 = new HashMap<Long, Object>();
		//for(int i = 0; i < this.elements2.size();i++){
			Disciplina d = (Disciplina)this.elements2.get(i);
			this.elements2.put(d.getId(), d.getNome());
		}
		//this.elements2.put(0, "Matemática");
		//this.elements2.put(1, "Matemática");
		 * 
		 */
	}
	
	
	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		System.out.println("O indice: " + index);
		//return this.elements2.get(index);
		Disciplina d = (Disciplina)this.elements.get(index);
		
		return d.getId()+" - "+ d.getNome();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		//return this.elements2.size();
		return this.elements.size();
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.selectedItem;
	}

	@Override
	public void setSelectedItem(Object obj) {
		// TODO Auto-generated method stub
		this.selectedItem = obj;
		
	}
		
}
