package br.unb.sece.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VPanelAluno extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public VPanelAluno() {
		
		setBackground(new Color (240, 240, 240));
		setLayout(null);
		super.setBounds(20,11,522,234);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 30, 46, 14);
		add(lblNome);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(30, 78, 46, 14);
		add(lblEndereo);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(30, 131, 46, 14);
		add(lblTelefone);
		
		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setBounds(30, 185, 64, 14);
		add(lblNascimento);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(30, 241, 46, 14);
		add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(120, 27, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 75, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 128, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 182, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(120, 238, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);

	}

}
