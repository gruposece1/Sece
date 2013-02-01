package br.unb.sece.view.panelcadastropadrao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import br.unb.sece.control.CDisciplina;
import br.unb.sece.view.VLogin;


public class VCadAluno extends JPanel implements ActionListener{
	
	private JTextField txtNome;
	private ButtonGroup grpSexo;
	private JLabel lblNome;
	private JLabel lblSexo;
	private JRadioButton rdbtMasculino;
	private JRadioButton rdbtFeminino; 
	private JTextField txtMatricula;
	private JTextField txtNascimento;
	private JTextField txtMae;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 * 
	 * 
	 */

	
	public VCadAluno() {
		setLayout(null);
		super.setBounds(20,11,522,234);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 37, 46, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(81, 34, 126, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(290, 37, 46, 14);
		add(lblSexo);
		
		rdbtMasculino = new JRadioButton("M");
		rdbtMasculino.setBounds(371, 33, 38, 23);
		
		rdbtFeminino = new JRadioButton("F");
		rdbtFeminino.setBounds(419, 33, 38, 23);
		
		grpSexo = new ButtonGroup();   
        grpSexo.add(rdbtMasculino);
        grpSexo.add(rdbtFeminino);
        
        add(rdbtMasculino);
        add(rdbtFeminino);
        
        JLabel lblMatrcula = new JLabel("Matr\u00EDcula: ");
        lblMatrcula.setBounds(10, 80, 56, 14);
        add(lblMatrcula);
        
        txtMatricula = new JTextField();
        txtMatricula.setBounds(81, 77, 126, 20);
        add(txtMatricula);
        txtMatricula.setColumns(10);
        
        JLabel lblNascimento = new JLabel("Nascimento:");
        lblNascimento.setBounds(290, 80, 71, 14);
        add(lblNascimento);
        
        txtNascimento = new JTextField();
        txtNascimento.setBounds(371, 77, 86, 20);
        add(txtNascimento);
        txtNascimento.setColumns(10);
        
        JLabel lblMae = new JLabel("M\u00E3e: ");
        lblMae.setBounds(10, 116, 46, 14);
        add(lblMae);
        
        txtMae = new JTextField();
        txtMae.setEditable(false);
        txtMae.setBounds(81, 113, 126, 20);
        add(txtMae);
        txtMae.setColumns(10);
        
        JLabel lblPai = new JLabel("Pai:");
        lblPai.setBounds(290, 116, 46, 14);
        add(lblPai);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(371, 113, 86, 20);
        add(textField);
        textField.setColumns(10);
        
        btnNewButton = new JButton("New button");
        btnNewButton.setBounds(210, 112, 24, 23);
        add(btnNewButton);
        
        
        
        
	}
	
	

	public JTextField getTxtNome() {
		return txtNome;
	}



	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}



	public JTextField getTxtMatricula() {
		return txtMatricula;
	}



	public void setTxtMatricula(JTextField txtMatricula) {
		this.txtMatricula = txtMatricula;
	}



	public JTextField getTxtNascimento() {
		return txtNascimento;
	}



	public void setTxtNascimento(JTextField txtNascimento) {
		this.txtNascimento = txtNascimento;
	}


	public String getSexo()
	{
		if(rdbtMasculino.isSelected())
			return "Masculino";
		else
			return "Feminino";
					
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
