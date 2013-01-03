package Execucao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import Control.CTurma;
import Model.Serie;
import Model.Turno;

import teste.Colecoes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VCadTurma extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private Colecoes colecao;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCadTurma frame = new VCadTurma();
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
	public VCadTurma() {
		
		colecao = new Colecoes();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTurno = new JLabel("Turno: ");
		lblTurno.setBounds(10, 58, 46, 14);
		contentPane.add(lblTurno);
		
		JComboBox CBTurno = new JComboBox(colecao.nomeTurno().toArray());
		CBTurno.setBounds(60, 55, 86, 20);
		contentPane.add(CBTurno);
		
		
		JLabel lblHorrio = new JLabel("S\u00E9rie: ");
		lblHorrio.setBounds(10, 100, 46, 14);
		contentPane.add(lblHorrio);
		
		JComboBox CBSerie = new JComboBox(colecao.nomeSerie().toArray());
		CBSerie.setBounds(60, 97, 86, 20);
		contentPane.add(CBSerie);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 22, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 19, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 195, 579, 208);
		contentPane.add(scrollPane);
		
		
		
		JButton btnGerarGrade = new JButton("Gerar Grade");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		btnGerarGrade.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CTurma c = new CTurma();
				
				String nome[] = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
				
				table.setModel(new DefaultTableModel(c.gerarGrade((Serie)colecao.serie.get(0), (Turno)colecao.turno.get(0)),nome));
				//c.gerarGrade((Serie)colecao.serie.get(0), (Turno)colecao.turno.get(0));
				
			}
		});
		
		
		btnGerarGrade.setBounds(10, 139, 108, 23);
		contentPane.add(btnGerarGrade);
	}
}
