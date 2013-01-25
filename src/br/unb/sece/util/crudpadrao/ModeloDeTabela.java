package br.unb.sece.util.crudpadrao;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ModeloDeTabela extends DefaultTableModel {

	
	public ModeloDeTabela() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModeloDeTabela(int arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ModeloDeTabela(Object[] arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ModeloDeTabela(Object[][] arg0, Object[] arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ModeloDeTabela(Vector arg0, int arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ModeloDeTabela(Vector arg0, Vector arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isCellEditable(int row,int column){
		return false;
		
	}
}
