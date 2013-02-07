package br.unb.sece.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class JButtonGradeHorario extends JButton implements TableCellRenderer {

	private int diaDaSemana;
	
	private int horario;
	
	public JButtonGradeHorario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JButtonGradeHorario(Action arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JButtonGradeHorario(Icon arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JButtonGradeHorario(String arg0, Icon arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public JButtonGradeHorario(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public int getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(int diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	 public Component getTableCellRendererComponent(JTable table, Object value,
		      boolean isSelected, boolean hasFocus, int row, int column) {
		//System.out.println("O valor: "+isSelected);    
		if (isSelected) {
	      this.setForeground(table.getSelectionForeground());
	      this.setBackground(table.getSelectionBackground());
	    } else {
    		this.setForeground(table.getForeground());
    		this.setBackground(UIManager.getColor("Button.background"));
	    	
	    }
		
	    //System.out.println("A linha: "+row+" coluna: "+column);
	    this.setText((value == null) ? "" : value.toString());
	    return this;
     }
	
	
	
}
