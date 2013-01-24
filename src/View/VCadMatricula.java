package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VCadMatricula extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public VCadMatricula() {
		
		setBackground(new Color (240, 240, 240));
		setLayout(null);
		super.setBounds(20,11,522,234);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(69, 38, 46, 14);
		add(lblNome);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setBounds(69, 105, 46, 14);
		add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(124, 35, 87, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 102, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}

}
