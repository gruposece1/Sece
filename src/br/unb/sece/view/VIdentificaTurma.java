package br.unb.sece.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import br.unb.sece.control.CIdentificaTurma;
import br.unb.sece.control.CTurma;
import br.unb.sece.model.Turma;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VIdentificaTurma extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNada;
	private CTurma cturma = new CTurma();
	private JComboBox comboBox;
	private Turma turma;
	private JButton btnSelecionar;
	private int op;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIdentificaTurma frame = new VIdentificaTurma(1);
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
	public VIdentificaTurma(int op) {
		this.op=op;
		//setSize(new Dimension(1024, 1024));
		setResizable(false);
		setTitle("SECE - Sistema Escolar de Chamada Eletr\u00F4nica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setBounds(10, 47, 46, 14);
		contentPane.add(lblTurma);
		
		comboBox = new JComboBox();
		comboBox.setBounds(66, 44, 240, 20);
		
		
		String []turmas = cturma.getAllTurmas();
		
		for(int i=0; i<turmas.length; i++){
			comboBox.addItem(turmas[i]);
		}
		
		contentPane.add(comboBox);
		
		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(this);
		btnSelecionar.setBounds(124, 147, 123, 23);
		contentPane.add(btnSelecionar);
		
		JLabel labelDisciplina = new JLabel("Disciplina:");
		labelDisciplina.setBounds(10, 82, 59, 14);
		contentPane.add(labelDisciplina);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 79, 240, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(10, 119, 59, 14);
		contentPane.add(lblHorario);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(66, 116, 240, 20);
		contentPane.add(comboBox_2);
		
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource().equals(this.btnSelecionar) && op == 1){
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
		}else if(arg0.getSource().equals(this.btnSelecionar) && op == 2){
			String result = comboBox.getSelectedItem().toString();
			turma = cturma.selectTurma(result);
			this.setVisible(false);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						cturma.setTurma(turma);
						VTurmaAluno frame = new VTurmaAluno(cturma);
						
						frame.setVisible(true);
						//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
			});
		}
	}
}
