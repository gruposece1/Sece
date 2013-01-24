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
import javax.swing.JOptionPane;

import Control.CHorario;
import Model.Disciplina;
import Model.Horario;
import Model.Professor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VHorario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private CHorario CHorario = new CHorario();
	private JComboBox comboDisciplina;
	private JComboBox comboProfessor;
	private Horario horario;
	
	/**
	 * Create the frame.
	 */
	public VHorario(Horario hora){
		
		this.horario = hora;
		
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
		
		comboDisciplina = new JComboBox(CHorario.getNomeDisciplinas().toArray());
		comboDisciplina.setBounds(240, 79, 110, 20);
		contentPane.add(comboDisciplina);
		
		comboProfessor = new JComboBox(CHorario.getNomeProfessores().toArray());
		comboProfessor.setBounds(240, 152, 110, 20);
		contentPane.add(comboProfessor);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnSalvar.setBounds(179, 203, 89, 23);
		contentPane.add(btnSalvar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Disciplina d;	
		Professor f;
			
		String itemDisciplina = comboDisciplina.getSelectedItem().toString(); 
		String itemProfessor = comboProfessor.getSelectedItem().toString(); 
		
		d = CHorario.GuardaDisciplina(itemDisciplina);
		f = CHorario.GuardaProfessores(itemProfessor);
		
		if(d != null)
			horario.setDisciplina(d);
		
		if(f != null)
			horario.setProfessor(f);
		
		this.dispose();
	}
}
