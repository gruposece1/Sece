package br.unb.sece.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import br.unb.sece.model.Aluno;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import br.unb.sece.control.CPadrao;
import br.unb.sece.control.CTurma;
import br.unb.sece.control.CTurmaAluno;
import br.unb.sece.view.panelcadastropadrao.VCadSerie;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class VTurmaAluno extends JFrame{

	private JPanel contentPane;
	private DefaultListModel listTurma;
	private DefaultListModel listModel;
	private JList list;
	private JList list_1;
	private JButton btnSalvar;
	private ArrayList a_turma;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VTurmaAluno frame = new VTurmaAluno(null);
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
	public VTurmaAluno(final CTurma turma) {
		
		DefaultListModel model;
		DefaultListSelectionModel select;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listTurma.addElement(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		button.setBounds(290, 184, 58, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("<<");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(list_1.getSelectedValue());
				listTurma.removeElement(list_1.getSelectedValue());
			}
		});
		button_1.setBounds(290, 256, 58, 23);
		contentPane.add(button_1);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tamanhoLista = list_1.getModel().getSize();  
			    ArrayList listaAlunos = new ArrayList();  
			       for (int i=0; i < tamanhoLista; i++){  
			           listaAlunos.add(list_1.getModel().getElementAt(i));  
			           System.out.println(listaAlunos.get(i).toString());
			       }
			       
			       turma.addAlunos(listaAlunos);
			}
		});
		btnSalvar.setBounds(274, 394, 96, 33);
		contentPane.add(btnSalvar);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setBounds(10, 11, 58, 14);
		contentPane.add(lblTurma);
		
		JLabel lblNomeTurma = new JLabel(turma.getTurma().getSerie()+""+turma.getTurma().getNomeTurma());
		lblNomeTurma.setBounds(74, 11, 146, 14);
		contentPane.add(lblNomeTurma);
		
		
		listModel = new DefaultListModel();
		
		
		List alunos =  CTurmaAluno.getAll();
		String[] values = new String[alunos.size()];
		
		if(turma!=null){
		for(int i = 0; i<alunos.size(); i++){
			values[i] = ((Aluno) alunos.get(i)).getMatricula()+" "+((Aluno) alunos.get(i)).getNome();
			listModel.addElement(values[i]);
		}
		}
		listTurma = new DefaultListModel();
		
		
		a_turma = new ArrayList(turma.getTurma().getAluno());
		String[] values_1 = new String[a_turma.size()];
		if(a_turma!=null){
			for(int i = 0; i<a_turma.size(); i++){
				values_1[i] = ((Aluno) a_turma.get(i)).getMatricula()+" "+((Aluno) a_turma.get(i)).getNome();
				listTurma.addElement(values_1[i]);
			}
		}
		list = new JList(listModel);
		list.setBounds(10, 36, 265, 313);
		contentPane.add(list); 
		
		list_1 = new JList(listTurma);
		list_1.setBounds(363, 36, 265, 313);
		contentPane.add(list_1);
	}

	
}
