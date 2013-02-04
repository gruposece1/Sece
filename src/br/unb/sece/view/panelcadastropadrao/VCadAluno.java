package br.unb.sece.view.panelcadastropadrao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

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

import br.unb.sece.control.CAluno;
import br.unb.sece.control.CDisciplina;
import br.unb.sece.view.VLogin;
import br.unb.sece.model.Responsavel;
import br.unb.sece.util.ColunaPesquisa;
import br.unb.sece.util.Pesquisa;


public class VCadAluno extends JPanel implements ActionListener, WindowListener{
	
	private JTextField txtNome;
	private ButtonGroup grpSexo;
	private JLabel lblNome;
	private JLabel lblSexo;
	private JRadioButton rdbtMasculino;
	private JRadioButton rdbtFeminino; 
	private JTextField txtMatricula;
	private JTextField txtNascimento;
	private JTextField txtMae;
	private JTextField txtPai;
	private JButton btnPesquisarMae;
	private JButton btnPesquisarPai;
	private Pesquisa janelaDePesquisa;
	private int tipoResponsavel;
	private ArrayList<Responsavel> responsavel;

	/**
	 * Create the panel.
	 * 
	 * 
	 */

	
	public VCadAluno()  {
		setLayout(null);
		super.setBounds(20,11,522,234);
		
		responsavel = new ArrayList<Responsavel>();
		
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
        txtNascimento.setBounds(371, 77, 109, 20);
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
        
        txtPai = new JTextField();
        txtPai.setEditable(false);
        txtPai.setBounds(371, 113, 109, 20);
        add(txtPai);
        txtPai.setColumns(10);
        
        btnPesquisarMae = new JButton();
        btnPesquisarMae.setBounds(210, 112, 24, 23);
        btnPesquisarMae.addActionListener(this);
        add(btnPesquisarMae);
        
        btnPesquisarPai = new JButton("");
        btnPesquisarPai.addActionListener(this);
        btnPesquisarPai.setBounds(488, 112, 24, 23);
        add(btnPesquisarPai);
        
        
        
        
        
        
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


	public ArrayList<Responsavel> getResponsavel() {
		return responsavel;
	}



	public void setResponsavel(ArrayList<Responsavel> responsavel) {
		this.responsavel = responsavel;
	}

	

	public JTextField getTxtMae() {
		return txtMae;
	}



	public void setTxtMae(JTextField txtMae) {
		this.txtMae = txtMae;
	}



	public JTextField getTxtPai() {
		return txtPai;
	}



	public void setTxtPai(JTextField txtPai) {
		this.txtPai = txtPai;
	}



	@Override
	public void actionPerformed(ActionEvent e) {

		CAluno CAluno = new CAluno();
	
		if(e.getSource().equals(btnPesquisarMae))
			tipoResponsavel = 0;
		else
			tipoResponsavel = 1;
		
		System.out.println(tipoResponsavel);
		
		if(e.getSource().equals(this.btnPesquisarMae) || e.getSource().equals(this.btnPesquisarPai)){
			ArrayList camposTabela = CAluno.gerarNomeColunas();
			janelaDePesquisa = new Pesquisa(CAluno.getResponsaveis(), camposTabela);
			janelaDePesquisa.setVisible(true);
			janelaDePesquisa.addWindowListener(this);			
				
			
			
		}
		
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosed(WindowEvent e) {
		
		if(e.getSource().equals(this.janelaDePesquisa))
		{
			Object obj = janelaDePesquisa.getRetorno();
			
			if(tipoResponsavel==0)
				this.txtMae.setText(((Responsavel) obj).getNome());
			else
				this.txtPai.setText(((Responsavel) obj).getNome());
			
			responsavel.add((Responsavel) obj);
		}
		
	}



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
