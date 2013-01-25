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


public class VCadProfessor extends JPanel implements ActionListener{
	
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private ButtonGroup grpSexo;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblSexo;
	private JLabel lblDisciplina;
	private JRadioButton rdbtMasculino;
	private JRadioButton rdbtFeminino; 
	private JComboBox CBDisciplina;
	private JButton btnDisciplina;
	private JList listDisciplina;
	private DefaultListModel model;
	private String[] materias= {"Matematica", "Portugues", "Ciencias", "Filosofia"};
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 * 
	 * 
	 */

	
	public VCadProfessor() {
		setLayout(null);
		super.setBounds(20,11,522,234);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 37, 46, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 34, 126, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblCpf = new JLabel("CPF: ");
		lblCpf.setBounds(224, 37, 46, 14);
		add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(280, 34, 126, 20);
		add(txtCPF);
		txtCPF.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(224, 72, 46, 14);
		add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(280, 69, 126, 20);
		add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(10, 72, 46, 14);
		add(lblSexo);
		
		rdbtMasculino = new JRadioButton("M");
		rdbtMasculino.setBounds(60, 68, 38, 23);
		
		rdbtFeminino = new JRadioButton("F");
		rdbtFeminino.setBounds(100, 68, 38, 23);
		
		grpSexo = new ButtonGroup();   
        grpSexo.add(rdbtMasculino);
        grpSexo.add(rdbtFeminino);
        
        add(rdbtMasculino);
        add(rdbtFeminino);
        
        lblDisciplina = new JLabel("Discilinas");
        lblDisciplina.setBounds(10, 108, 46, 14);
        add(lblDisciplina);
        
        CBDisciplina = new JComboBox(materias);
        CBDisciplina.setBounds(60, 105, 102, 20);
        add(CBDisciplina);
        
        btnDisciplina = new JButton("+");
        btnDisciplina.setBounds(172, 104, 46, 23);
        add(btnDisciplina);
        
        
        
        model = new DefaultListModel();
		
		
        btnDisciplina.addActionListener(this);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 136, 465, 87);
        add(scrollPane);
        listDisciplina = new JList(model);
        scrollPane.setViewportView(listDisciplina);
        
	}

	public void actionPerformed(ActionEvent e)
	{
		
		System.out.println("Teste");
		String disciplina = CBDisciplina.getName();
		model.addElement(disciplina);
		
		
	}
}
