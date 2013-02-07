package br.unb.sece.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

import br.unb.sece.control.CTurma;
import br.unb.sece.model.Horario;



/*
 * Classe extraída do seguinte link:http://www.java2s.com/Code/Java/Swing-Components/ButtonTableExample.htm
 * Data: 03/01/2013
 * 
 * */
public class ButtonEditor extends DefaultCellEditor implements WindowListener {

	 protected JButtonGradeHorario button;

	  private String label;
	  private JTable table;
	  private CTurma turma;
	  private VHorario VHorario = null;
	  
	  private int diaDaSemana; //armazena o dia da semana do botao
	  
	  private int horario; //armazena o horario do botao
	  
	  private boolean isPushed;
	  
	  private Horario obHorario;

	  public ButtonEditor(JCheckBox checkBox, JTable table, CTurma turma) {
	    super(checkBox);
	    button = new JButtonGradeHorario();
	    button.setOpaque(true);
	    this.table = table;
	    this.turma = turma;
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        fireEditingStopped();
	      }
	    });
	  }
	  
	  
	  public ButtonEditor(JCheckBox checkBox, JTable table, CTurma turma, VCadTurma VCadTurma) {
		    super(checkBox);
		    button = new JButtonGradeHorario();
		    button.setOpaque(true);
		    this.table = table;
		    this.turma = turma;
		    this.button.addActionListener(VCadTurma);
		    /*
		    button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        fireEditingStopped();
		      }
		    });
		    */
	   }

	  public Component getTableCellEditorComponent(JTable table, Object value,
	      boolean isSelected, int row, int column) {
	    if (isSelected) {
	      button.setForeground(table.getSelectionForeground());
	      button.setBackground(table.getSelectionBackground());
	    } else {
	      button.setForeground(table.getForeground());
	      button.setBackground(table.getBackground());
	    }
	    label = (value == null) ? "" : value.toString();
	    button.setText(label);
	    this.button.setDiaDaSemana(column);
	    this.button.setHorario(row);
	    isPushed = true; 
	    return button;
}

	
	public Object getCellEditorValue() {
	    if (isPushed) {

			this.obHorario = (Horario)this.turma.getHorario(table.getSelectedRow(), table.getSelectedColumn());
			this.VHorario = new VHorario(obHorario);					
		
				
			this.VHorario.setVisible(true);	
			this.VHorario.addWindowListener(this);
			
			this.VHorario.setAlwaysOnTop(true);  
			this.VHorario.toFront(); 
			
		
	    }
	    
	    
	    isPushed = false;
	    return new String(label);
	  }

	  public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	  }

	  protected void fireEditingStopped() {
	    super.fireEditingStopped();
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

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.VHorario)){
			if(this.obHorario != null){
				if(this.obHorario.getProfessor() != null){
					this.label = this.obHorario.getProfessor().getNome();
				}
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	  

	  
}
