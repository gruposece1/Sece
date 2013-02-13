package br.unb.sece.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import java.awt.Panel;
import javax.swing.ImageIcon;

import teste.InserirAlunos;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblNada;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal frame = new VPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VPrincipal() {
		//setSize(new Dimension(1024, 1024));
		setResizable(false);
		setTitle("SECE - Sistema Escolar de Chamada Eletr\u00F4nica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 711, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1456, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAluno = new JMenuItem("Aluno");
		mntmAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					VAluno aluno = new VAluno();
					aluno.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnNewMenu.add(mntmAluno);
		
		JMenuItem mntmFuncionario = new JMenuItem("Funcionario");
		mntmFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				try{
					VFuncionario vf = new VFuncionario();
					vf.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
				
				
			}
		});
		mnNewMenu.add(mntmFuncionario);
		
		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mntmProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					VProfessor t = new VProfessor();
					t.setVisible(true);
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		mnNewMenu.add(mntmProfessor);
		
		JMenuItem mntmTurma = new JMenuItem("Turma");
		mntmTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList tur  = new ArrayList();
				
				try{
					VCadTurma t = new VCadTurma();
					t.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		mnNewMenu.add(mntmTurma);
		
		JMenuItem mntmSerie = new JMenuItem("Serie");
		mnNewMenu.add(mntmSerie);
		mntmSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					VSerie tp = new VSerie();
				
					tp.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		
		JMenuItem mntmTurno = new JMenuItem("Turno");
		mntmTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					VTurno turno = new VTurno();
					turno.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mnNewMenu.add(mntmTurno);
		
		JMenuItem mntmDisciplina = new JMenuItem("Disciplina");
		mntmDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList list  = new ArrayList();
				try{
					VDisciplina tp = new VDisciplina();
				
					tp.setVisible(true);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		mnNewMenu.add(mntmDisciplina);
		
		JMenu mnAdministrao = new JMenu("Administra\u00E7\u00E3o");
		menuBar.add(mnAdministrao);
		
		JMenuItem mntmChamada = new JMenuItem("Chamada");
		mntmChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VIdentificaTurma v = new VIdentificaTurma();
					v.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		mnAdministrao.add(mntmChamada);
		
		JMenuItem mntmRelatorios = new JMenuItem("Relatórios Bimestrais");
		mnAdministrao.add(mntmRelatorios);
		
		
		lblNada = new JLabel("");
		lblNada.setBackground(new Color(255, 255, 255));
		lblNada.setIcon(new ImageIcon("F:\\OlhoDandara.jpg"));
		lblNada.setBounds(-120, 0, 1959, 865);
		contentPane.add(lblNada);
		
	}
}
