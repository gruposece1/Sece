package br.unb.sece.view;

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
import javax.swing.JOptionPane;


import javax.swing.JButton;

import br.unb.sece.control.CHorario;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VHorario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private CHorario CHorario = new CHorario();
	private JComboBox comboDisciplina;
	private JComboBox comboProfessor;
	private Horario horario;
	private JButton btnSalvar;
	
	/**
	 * Create the frame.
	 */
	public VHorario(Horario hora){
		
		this.horario = hora;
		
		this.CHorario.setObHorario(this.horario);
		
		setTitle("Cadastro de Hor\u00E1rio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 362, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfessor = new JLabel("Professor: ");
		lblProfessor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProfessor.setBounds(10, 67, 83, 14);
		contentPane.add(lblProfessor);
		
		JLabel lblDisciplina = new JLabel("Disciplina: ");
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDisciplina.setBounds(10, 24, 70, 14);
		contentPane.add(lblDisciplina);
		
		comboDisciplina = new JComboBox(CHorario.getModelDisciplinas());
		comboDisciplina.setBounds(103, 22, 170, 20); 
		comboDisciplina.addActionListener(this);
		contentPane.add(comboDisciplina);
		
		comboProfessor = new JComboBox();
		comboProfessor.setBounds(103, 65, 216, 20);
		contentPane.add(comboProfessor);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setBounds(131, 143, 89, 23);
		contentPane.add(btnSalvar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.btnSalvar)){
			this.salve();
		}
		if(e.getSource().equals(this.comboDisciplina)){
			//this.comboProfessor.setModel(this.CHorario.getProfessoresDisponiveis());
			System.out.println("A lista: "+this.CHorario.getProfessoresDisponiveis());
			this.comboProfessor.setModel(this.CHorario.getModelProfessores());
		}

	}
	
	private void salve(){
		Disciplina obDisciplina = null;	
		Professor obProfessor = null;
		
		try{
			obDisciplina = this.CHorario.getDisciplinaSelected(); 
			
			horario.setDisciplina(obDisciplina);
			
		}catch(NullPointerException ex){
			
		}
		
		try{
			obProfessor = this.CHorario.getProfessorSelected();
			
			horario.setProfessor(obProfessor);
			
		}catch(NullPointerException ex){
			
		}
		
		
		this.dispose();
		
	}
}
