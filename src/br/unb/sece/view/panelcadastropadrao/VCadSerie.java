package br.unb.sece.view.panelcadastropadrao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VCadSerie extends JPanel {
	
	private JTextField txtNome;
	private JLabel lblNome; 
	private JLabel lblHorario;
	private JComboBox CBHorario;
	private JLabel lblNDias;
	private JComboBox CBDias;
	private String[] Ndias = {"1", "2", "3", "4", "5", "6", "7"};
	private String[] Nhorario = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

	/**
	 * Create the panel.
	 */
	public VCadSerie() 
	{
		
		setLayout(null);
		super.setBounds(20,11,522,234);
		
		lblNome= new JLabel("Nome: ");
		lblNome.setBounds(10, 25, 46, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(83, 22, 80, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		lblHorario = new JLabel("N\u00B0 Hor\u00E1rios: ");
		lblHorario.setBounds(10, 68, 67, 14);
		add(lblHorario);
		
		CBHorario = new JComboBox(Nhorario);
		CBHorario.setBounds(83, 65, 54, 20);
		add(CBHorario);
		
		lblNDias = new JLabel("N\u00B0 Dias: ");
		lblNDias.setBounds(10, 101, 46, 14);
		add(lblNDias);
		
		CBDias = new JComboBox(Ndias);
		CBDias.setBounds(83, 98, 54, 20);
		add(CBDias);

	}

}
