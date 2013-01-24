package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;

public class TelaHorario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHorario frame = new TelaHorario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaHorario() {
		setTitle("Cadastro de Hor\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProfessor.setBounds(121, 154, 63, 14);
		contentPane.add(lblProfessor);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDisciplina.setBounds(121, 81, 63, 14);
		contentPane.add(lblDisciplina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(240, 79, 75, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(240, 152, 75, 20);
		contentPane.add(comboBox_1);
	}
}
