package br.unb.sece.view.panelcadastropadrao;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import br.unb.sece.control.CProfessor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VCadProfessor extends VCadFuncionario{
	
	
	public VCadProfessor() {
		super();
		
		JLabel lblDisciplinas = new JLabel("Disciplinas:");
		lblDisciplinas.setBounds(10, 171, 67, 14);
		add(lblDisciplinas);
		
	
		
		JList list_1 = new JList(CProfessor.getListDisciplinas());
		list_1.setBounds(81, 165, 126, 58);
		add(list_1);
		
		JList list_2 = new JList();
		list_2.setBounds(290, 165, 126, 58);
		add(list_2);
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(217, 167, 55, 23);
		add(btnNewButton);
		
		JButton button = new JButton("<<");
		button.setBounds(217, 200, 55, 23);
		add(button);
		
		
		this.remove(this.lblCargo);
		this.remove(this.CBCargo);
	}
}
