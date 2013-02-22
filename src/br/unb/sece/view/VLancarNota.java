package br.unb.sece.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import br.unb.sece.control.CNota;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VLancarNota extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLancarNota frame = new VLancarNota();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JLabel lblTurma;
	private JComboBox CBTurma;
	private CNota CNota = new CNota();
	private JLabel lblDisciplina;
	private JButton btnSelecionarDisciplina;
	private JButton btnConfirmaTurma;
	private JComboBox CBDisciplina;
	private JComboBox CBBimestre;
	
	/**
	 * Create the frame.
	 */
	public VLancarNota() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTurma= new JLabel("Turma");
		lblTurma.setBounds(10, 27, 46, 14);
		contentPane.add(lblTurma);
		
		
		CBTurma = new JComboBox(CNota.getModelTurma());
		CBTurma.setBounds(74, 24, 155, 20);
		contentPane.add(CBTurma);
		
		btnConfirmaTurma = new JButton("Ok");
		
		btnConfirmaTurma.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CNota.selectTurma(CBTurma.getSelectedItem().toString());
				CBDisciplina.setEnabled(true);
				btnSelecionarDisciplina.setEnabled(true);
				
				CBDisciplina.setModel(CNota.getModelDisciplinas());
				
			}
			
		});
		
		btnConfirmaTurma.setBounds(239, 23, 53, 23);
		contentPane.add(btnConfirmaTurma);
		
		lblDisciplina = new JLabel("Disciplina: ");
		lblDisciplina.setBounds(10, 68, 59, 14);
		contentPane.add(lblDisciplina);
		
		CBDisciplina = new JComboBox();
		CBDisciplina.setEnabled(false);
		CBDisciplina.setBounds(74, 65, 155, 20);
		contentPane.add(CBDisciplina);
		
		btnSelecionarDisciplina = new JButton("Ok");
		btnSelecionarDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CNota.selectDisciplina(CBDisciplina.getSelectedItem().toString());
				CBBimestre.setEnabled(true);
			}
		});
		btnSelecionarDisciplina.setEnabled(false);
		btnSelecionarDisciplina.setBounds(239, 64, 53, 23);
		contentPane.add(btnSelecionarDisciplina);
		
		JLabel lblBimestre = new JLabel("Bimestre:");
		lblBimestre.setBounds(10, 110, 46, 14);
		contentPane.add(lblBimestre);
		
		CBBimestre = new JComboBox(gerarNomeDosBimestres());
		CBBimestre.setEnabled(false);
		CBBimestre.setBounds(74, 107, 155, 20);
		contentPane.add(CBBimestre);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			try {
					VPreencherNota preencherNota = new VPreencherNota(CNota);
					preencherNota.setVisible(true);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		btnOk.setBounds(239, 205, 89, 23);
		contentPane.add(btnOk);
	}
	
	
	public String[] gerarNomeDosBimestres(){
		
		String[] nomeBimestres = {"1","2", "3", "4"};
		
		return nomeBimestres;
	}	
}
