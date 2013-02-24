package br.unb.sece.view.panelcadastropadrao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import br.unb.sece.model.Pessoa;



public class VCadFuncionario extends JPanel implements ActionListener{
	
	private JTextField txtNome;
	private ButtonGroup grpSexo;
	private JLabel lblNome;
	private JLabel lblSexo;
	private JRadioButton rdbtMasculino;
	private JRadioButton rdbtFeminino; 
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private JTextField txtSenha;
	protected  JComboBox CBCargo;
	protected JLabel lblCargo;

	/**
	 * Create the panel.
	 * 
	 * 
	 */

	
	public VCadFuncionario()  {
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
		rdbtMasculino.setBounds(379, 33, 38, 23);
		
		rdbtFeminino = new JRadioButton("F");
		rdbtFeminino.setBounds(442, 33, 38, 23);
		
		grpSexo = new ButtonGroup();   
        grpSexo.add(rdbtMasculino);
        grpSexo.add(rdbtFeminino);
        
        add(rdbtMasculino);
        add(rdbtFeminino);
        
        JLabel lblCPF = new JLabel("CPF: ");
        lblCPF.setBounds(10, 80, 56, 14);
        add(lblCPF);
        
        txtCPF = new JTextField();
        txtCPF.setBounds(81, 77, 126, 20);
        add(txtCPF);
        txtCPF.setColumns(10);
        
        JLabel lblNascimento = new JLabel("Telefone: ");
        lblNascimento.setBounds(290, 80, 71, 14);
        add(lblNascimento);
        
        txtTelefone = new JTextField();
        txtTelefone.setBounds(371, 77, 109, 20);
        add(txtTelefone);
        txtTelefone.setColumns(10);
        
        JLabel lblSenha = new JLabel("Senha: ");
        lblSenha.setBounds(10, 121, 46, 14);
        add(lblSenha);
        
        txtSenha = new JTextField();
        txtSenha.setBounds(81, 118, 126, 20);
        add(txtSenha);
        txtSenha.setColumns(10);
        
        lblCargo = new JLabel("Cargo: ");
        lblCargo.setBounds(290, 121, 46, 14);
        add(lblCargo);
        
        
        CBCargo = new JComboBox(setarTipoDeCargos());
        CBCargo.setBounds(371, 118, 109, 20);
        add(CBCargo);
        
        txtCPF.setName("CPF");
        txtNome.setName("Nome");
        txtSenha.setName("Senha");
        txtTelefone.setName("Telefone");
        CBCargo.setName("CBCargo");
        rdbtMasculino.setName("Masculino");
        rdbtFeminino.setName("Feminino");
        
	}
	
	public String[] setarTipoDeCargos(){
		
		 String[] cargos = {"Secretario", "Coordenador"};
	
		 return cargos;
	}
	

	public JRadioButton getRdbtMasculino() {
		return rdbtMasculino;
	}



	public void setRdbtMasculino(JRadioButton rdbtMasculino) {
		this.rdbtMasculino = rdbtMasculino;
	}



	public JRadioButton getRdbtFeminino() {
		return rdbtFeminino;
	}



	public void setRdbtFeminino(JRadioButton rdbtFeminino) {
		this.rdbtFeminino = rdbtFeminino;
	}



	public JTextField getTxtNome() {
		return txtNome;
	}



	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}



	public JTextField getTxtCPF() {
		return txtCPF;
	}



	public void setTxtCPF(JTextField txtMatricula) {
		this.txtCPF = txtMatricula;
	}



	public JTextField getTxtTelefone() {
		return txtTelefone;
	}



	public void setTxtTelefone(JTextField txtNascimento) {
		this.txtTelefone = txtNascimento;
	}


	public String getSexo()
	{
		if(rdbtMasculino.isSelected())
			return Pessoa.MASCULINO;
		else if(rdbtFeminino.isSelected())
			return Pessoa.FEMININO;
		else
			return null;
					
	}


	public JTextField getTxtSenha() {
		return txtSenha;
	}


	public String getCargo()
	{
		return CBCargo.getSelectedItem().toString();
	}
	
	
	

	public JComboBox getCBCargo() {
		return CBCargo;
	}


	public void setCBCargo(JComboBox cBCargo) {
		CBCargo = cBCargo;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}

