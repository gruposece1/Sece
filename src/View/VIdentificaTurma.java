package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Control.CIdentificaTurma;
import Control.CTurma;
import Model.Turma;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VIdentificaTurma extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNada;
	private CTurma control = new CTurma();
	private CTurma cturma = new CTurma();
	private JComboBox comboBox;
	private Turma turma;
	private JButton btnSelecionar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIdentificaTurma frame = new VIdentificaTurma();
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
	public VIdentificaTurma() {
		//setSize(new Dimension(1024, 1024));
		setResizable(false);
		setTitle("SECE - Sistema Escolar de Chamada Eletr\u00F4nica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setBounds(10, 47, 46, 14);
		contentPane.add(lblTurma);
		
		comboBox = new JComboBox();
		comboBox.setBounds(66, 44, 240, 20);
		
		
		String []turmas = control.getAllTurmas();
		
		for(int i=0; i<turmas.length; i++){
			comboBox.addItem(turmas[i]);
		}
		
		contentPane.add(comboBox);
		
		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(this);
		btnSelecionar.setBounds(116, 110, 123, 23);
		contentPane.add(btnSelecionar);
		
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.btnSelecionar)){
			String result = comboBox.getSelectedItem().toString();
			turma = cturma.selectTurma(result);
			this.setVisible(false);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						cturma.setTurma(turma);
						VTurma frame = new VTurma(cturma);
						
						frame.setVisible(true);
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}
