package br.unb.sece.view.panelcadastropadrao;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import br.unb.sece.control.CResponsavel;
import br.unb.sece.control.CTurno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class VCadResponsavel extends JPanel{
	
	private JLabel lblNome;
	private JLabel lblSexo;
	private JLabel lblTelefone;
	private JLabel lblEndereo;
	private JLabel lblEmail;
	private JLabel lblCep;
	
	private JComboBox CBTipo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField rbrMasculino;
	private JTextField rbrFeminino;
	private JTextField textField_5;
	
	public JTextField getRbrMasculino() {
		return rbrMasculino;
	}

	public void setRbrMasculino(JTextField rbrMasculino) {
		this.rbrMasculino = rbrMasculino;
	}

	public JTextField getRbrFeminino() {
		return rbrFeminino;
	}

	public void setRbrFeminino(JTextField rbrFeminino) {
		this.rbrFeminino = rbrFeminino;
	}

	public VCadResponsavel() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(18, 8, 82, 14);
		add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(82, 5, 227, 20);
		add(textField);
		textField.setColumns(10);
		
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(18, 72, 46, 14);
		add(lblSexo);
		
		JRadioButton rdbtMasculino = new JRadioButton("M");
		rdbtMasculino.setBounds(82, 68, 38, 23);
		
		JRadioButton rdbtFeminino = new JRadioButton("F");
		rdbtFeminino.setBounds(142, 68, 38, 23);
		
		ButtonGroup grpSexo = new ButtonGroup();   
        grpSexo.add(rdbtMasculino);
        grpSexo.add(rdbtFeminino);
        
        add(rdbtMasculino);
        add(rdbtFeminino);
        
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setBounds(18, 33, 107, 28);
		add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 33, 227, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndereo_1 = new JLabel("Endere\u00E7o");
		lblEndereo_1.setBounds(18, 97, 110, 21);
		add(lblEndereo_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(82, 97, 227, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(18, 130, 82, 14);
		add(lblEmail_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(82, 127, 227, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTelefone_1 = new JLabel("Telefone");
		lblTelefone_1.setBounds(18, 156, 93, 14);
		add(lblTelefone_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(82, 155, 227, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCep_1 = new JLabel("CEP");
		lblCep_1.setBounds(18, 194, 46, 14);
		add(lblCep_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(82, 186, 227, 20);
		add(textField_5);
		textField_5.setColumns(10);
	}

	

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public JComboBox getCBTipo() {
		return CBTipo;
	}

	public void setCBTipo(JComboBox cBTipo) {
		CBTipo = cBTipo;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
}
