package br.unb.sece.util;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxEditor;

import br.unb.sece.model.Disciplina;


public class EditorComboBox implements ComboBoxEditor {
	
	private String texto;
	
	
	private String metodo;

	@Override
	public void addActionListener(ActionListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Component getEditorComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getItem() {
		// TODO Auto-generated method stub
		//System.out.println("SPegando um item");
		return this.texto;
	}

	@Override
	public void removeActionListener(ActionListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setItem(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("Setando um item");
		if(obj instanceof Disciplina){
			System.out.println("Passou onde deveria");
			Disciplina d  = (Disciplina)obj;
			this.texto = d.getNome();
			
		}else{
			this.texto = obj.toString();
		}
		
	}

}
