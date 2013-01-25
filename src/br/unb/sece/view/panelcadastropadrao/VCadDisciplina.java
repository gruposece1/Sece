package br.unb.sece.view.panelcadastropadrao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VCadDisciplina extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VCadDisciplina() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(10, 11, 46, 14);
		add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(83, 8, 238, 20);
		add(textField);
		textField.setColumns(10);
		
		super.setBounds(20,11,522,234);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	

}
