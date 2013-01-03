package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class VCadMatricula extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public VCadMatricula() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		super.setBounds(20, 11, 522, 234);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(27, 25, 46, 14);
		add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(83, 22, 138, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(27, 56, 46, 14);
		add(lblCdigo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 53, 138, 20);
		add(textField_1);
		textField_1.setColumns(10);

	}
}
