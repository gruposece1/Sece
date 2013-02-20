package br.unb.sece.view.panelcadastropadrao;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import br.unb.sece.control.CProfessor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCadProfessor extends VCadFuncionario {
	
	private JButton btnNewButton,button;
	private JList list_1, list_2;
	
	public VCadProfessor() {
		super();
		
		JLabel lblDisciplinas = new JLabel("Disciplinas:");
		lblDisciplinas.setBounds(10, 171, 67, 14);
		add(lblDisciplinas);
		
	
		
		list_1 = new JList(CProfessor.getListDisciplinas());
		list_1.setBounds(81, 165, 126, 58);
		add(list_1);
		
		list_2 = new JList(new DefaultListModel());
		list_2.setBounds(290, 165, 126, 58);
		add(list_2);
		
		this.btnNewButton = new JButton(">>");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(217, 167, 55, 23);
		add(btnNewButton);
		
		this.button = new JButton("<<");
		button.addActionListener(this);
		button.setBounds(217, 200, 55, 23);
		add(button);
		
		
		this.remove(this.lblCargo);
		this.remove(this.CBCargo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(this.btnNewButton)){
			Object obSelecionado = list_1.getSelectedValue();
			DefaultListModel lista = (DefaultListModel) list_2.getModel();
			lista.addElement(obSelecionado);
			DefaultListModel lista2 = (DefaultListModel) list_1.getModel();
			lista2.removeElement(obSelecionado);
			}
		
		if (e.getSource().equals(this.button)){
			Object obSelecionado = list_2.getSelectedValue();
			DefaultListModel lista = (DefaultListModel) list_1.getModel();
			lista.addElement(obSelecionado);
			DefaultListModel lista1 = (DefaultListModel) list_2.getModel();
			lista1.removeElement(obSelecionado);
			
		}	
	}

	public JList getList_2(){
		
		return this.list_2;
	}
	
}

