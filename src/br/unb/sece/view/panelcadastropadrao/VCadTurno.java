package br.unb.sece.view.panelcadastropadrao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class VCadTurno extends JPanel 
{
	private JTextField txtInicio;
	private JTextField txtFim;
	private JLabel lblIncio;
	private JLabel lblFim;
	private JLabel lblTipo;
	private JComboBox CBTipo;
	private String[] tipo = {"Matutino", "Vespertino", "Noturno"};
	
	/**
	 * Create the panel.
	 */
	public VCadTurno() 
	{
		setLayout(null);
		super.setBounds(20,11,522,234);
		
		lblIncio = new JLabel("In\u00EDcio: ");
		lblIncio.setBounds(10, 37, 46, 14);
		add(lblIncio);
		
		txtInicio = new JTextField();
		txtInicio.setBounds(57, 34, 86, 20);
		add(txtInicio);
		txtInicio.setColumns(10);
		
		lblFim = new JLabel("Fim: ");
		lblFim.setBounds(10, 75, 46, 14);
		add(lblFim);
		
		txtFim = new JTextField();
		txtFim.setBounds(57, 72, 86, 20);
		add(txtFim);
		txtFim.setColumns(10);
		
		lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(10, 113, 46, 14);
		add(lblTipo);
		
		CBTipo = new JComboBox(tipo);
		CBTipo.setBounds(57, 110, 86, 20);
		add(CBTipo);

	}

	public JTextField getTxtInicio() {
		return txtInicio;
	}

	public void setTxtInicio(JTextField txtInicio) {
		this.txtInicio = txtInicio;
	}

	public JTextField getTxtFim() {
		return txtFim;
	}

	public void setTxtFim(JTextField txtFim) {
		this.txtFim = txtFim;
	}

	public JLabel getLblIncio() {
		return lblIncio;
	}

	public void setLblIncio(JLabel lblIncio) {
		this.lblIncio = lblIncio;
	}

	public JLabel getLblFim() {
		return lblFim;
	}

	public void setLblFim(JLabel lblFim) {
		this.lblFim = lblFim;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public void setLblTipo(JLabel lblTipo) {
		this.lblTipo = lblTipo;
	}

	public JComboBox getCBTipo() {
		return CBTipo;
	}

	public void setCBTipo(JComboBox cBTipo) {
		CBTipo = cBTipo;
	}

	public String[] getTipo() {
		return tipo;
	}

	public void setTipo(String[] tipo) {
		this.tipo = tipo;
	}

}
