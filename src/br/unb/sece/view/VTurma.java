package br.unb.sece.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.JTextPane;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.hibernate.Session;

import br.unb.sece.control.CChamada;
import br.unb.sece.control.CIdentificaTurma;
import br.unb.sece.control.CTurma;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Pessoa;
import br.unb.sece.model.Turma;
import br.unb.sece.util.HibernateUtil;
import br.unb.sece.util.ThreadEnviarEmail;
import br.unb.sece.view.util.PanelAlunoChamadaNota;

import java.awt.Scrollbar;



import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VTurma extends JFrame implements ActionListener {

	
	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel lblNada;
	private JLabel lblHoraRes = new JLabel("");
	private JTextField textFieldAnotation;
	private CTurma cturma;
	private CChamada chamada;
	private JButton btnCadastrar;
	private CIdentificaTurma cIdentificaTurma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*try {
					VTurma frame = new VTurma(turma);
					
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}*/
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public VTurma(CTurma turma, CIdentificaTurma indetifica) throws InterruptedException {
		this.cturma=turma;
		this.cIdentificaTurma = indetifica;
		setResizable(false);
				setTitle("SECE - Sistema Escolar de Chamada Eletr\u00F4nica");

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				setBounds(100, 100, 1340, 788);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JMenuBar menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 1456, 21);
				contentPane.add(menuBar);
				
				JMenu mnNewMenu = new JMenu("Gerenciar");
				menuBar.add(mnNewMenu);
				
				JMenuItem mntmAluno = new JMenuItem("Incluir Aluno");
				mnNewMenu.add(mntmAluno);
				
				JMenuItem mntmProfessor = new JMenuItem("Professor");
				mnNewMenu.add(mntmProfessor);
				
				JMenuItem mntmTurma = new JMenuItem("Turma");
				mnNewMenu.add(mntmTurma);
				
				JMenuItem mntmSerie = new JMenuItem("Serie");
				mnNewMenu.add(mntmSerie);
				
				JMenuItem mntmTurno = new JMenuItem("Turno");
				mnNewMenu.add(mntmTurno);
				
				JMenu mnAdministrao = new JMenu("Diário de Classe");
				menuBar.add(mnAdministrao);
				
				JMenuItem mntmChamada = new JMenuItem("Chamada");
				mnAdministrao.add(mntmChamada);
				
				JMenuItem mntmRelatorios = new JMenuItem("Relatórios Bimestrais");
				mnAdministrao.add(mntmRelatorios);
				
				JPanel panel = new JPanel();
				panel.setBounds(0, 23, 178, 681);
				panel.setBackground(SystemColor.activeCaption);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblArthur = new JLabel("Turma:");
				lblArthur.setBounds(10, 12, 46, 14);
				panel.add(lblArthur);
				
				JLabel lblNewLabel = new JLabel("Disciplina:");
				lblNewLabel.setBounds(10, 37, 64, 14);
				panel.add(lblNewLabel);
				
				
				lblNada = new JLabel();
				lblNada.setBounds(132, 12, 0, 0);
				panel.add(lblNada);
				lblNada.setBackground(new Color(255, 255, 255));
				lblNada.setIcon(new ImageIcon("F:\\OlhoDandara.jpg"));
				
				JLabel lblProfessor = new JLabel("Professor:");
				lblProfessor.setBounds(10, 62, 64, 14);
				panel.add(lblProfessor);
				
				JLabel lblDia = new JLabel("Dia:");
				lblDia.setBounds(10, 87, 46, 14);
				panel.add(lblDia);
				
				JLabel lblHora = new JLabel("Hora:");
				lblHora.setBounds(10, 112, 46, 14);
				panel.add(lblHora);
				
				JLabel lblTurmaRes = new JLabel(cturma.getTurma().getNomeTurma());
				lblTurmaRes.setBounds(78, 12, 64, 14);
				panel.add(lblTurmaRes);
				
				JLabel lblDisciplinaRes = new JLabel(this.cIdentificaTurma.getDisciplinaSelected().getNome());
				lblDisciplinaRes.setBounds(78, 37, 7*this.cIdentificaTurma.getDisciplinaSelected().getNome().length(), 14);
				panel.add(lblDisciplinaRes);
				
				JLabel lblProfessorRes = new JLabel(this.cIdentificaTurma.getHorarioSelected().getProfessor().getNome());
				lblProfessorRes.setBounds(78, 62, 7*this.cIdentificaTurma.getHorarioSelected().getProfessor().getNome().length(), 14);
				panel.add(lblProfessorRes);
				
				JLabel lblDiaRes = new JLabel("");
				lblDiaRes.setBounds(66, 87, 66, 14);
				panel.add(lblDiaRes);
				
				Format f = new SimpleDateFormat("dd/MM/yyyy");  
	              
	            Date data = new Date();  
	            String s = f.format(data);  
	              
	            lblDiaRes.setText(s);  
				
				
				lblHoraRes.setBounds(66, 112, 77, 14);
				panel.add(lblHoraRes);
				
				this.btnCadastrar = new JButton("Registrar");
				btnCadastrar.setBounds(32, 553, 100, 50);
				panel.add(btnCadastrar);
				this.btnCadastrar.addActionListener(this);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(190, 23, 1144, 679);
				contentPane.add(scrollPane);
				
				panel_1 = new JPanel();
				scrollPane.setViewportView(panel_1);
				panel_1.setPreferredSize(new Dimension(1144, 679));
				panel_1.setBackground(SystemColor.inactiveCaption);
				panel_1.setAutoscrolls(true);
				panel_1.setForeground(new Color(0, 0, 0));
				panel_1.setLayout(null);
				
				
				JPanel panelHeader = new JPanel();
				panelHeader.setBounds(10, 11, 1103, 33);
				panel_1.add(panelHeader);
				panelHeader.setLayout(null);
				
				JLabel lblNomeMatrcula = new JLabel("Nome - Matr\u00EDcula");
				lblNomeMatrcula.setBounds(10, 11, 237, 14);
				panelHeader.add(lblNomeMatrcula);
				
				JLabel lblPresente = new JLabel("Presente");
				lblPresente.setForeground(new Color(34, 139, 34));
				lblPresente.setBounds(246, 11, 60, 14);
				panelHeader.add(lblPresente);
				
				JLabel lblNewLabel_1 = new JLabel("Falta");
				lblNewLabel_1.setForeground(new Color(255, 0, 0));
				lblNewLabel_1.setBounds(316, 11, 31, 14);
				panelHeader.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Atrasado");
				lblNewLabel_2.setForeground(new Color(210, 105, 30));
				lblNewLabel_2.setBounds(357, 11, 83, 14);
				panelHeader.add(lblNewLabel_2);
				
				JLabel lblAnotation = new JLabel("Anota\u00E7\u00F5es");
				lblAnotation.setBounds(430, 11, 108, 14);
				panelHeader.add(lblAnotation);
				
				//JPanel []panelAlunos = addPanelAluno();
				
				panelHeader.setBounds(10, 11, 1103, 33);
				
				
				ArrayList<Aluno> lista = new ArrayList<Aluno>(cturma.getTurma().getAluno());
				PanelAlunoChamadaNota panelChamada;
				int tamanho = 34;
				for(int i=0; i< lista.size(); i++){
					tamanho = (i+1) * 34;
					panelChamada = new PanelAlunoChamadaNota(lista.get(i).getIdPessoa(), lista.get(i).getNome(),lista.get(i).getMatricula(),tamanho, PanelAlunoChamadaNota.CHAMADA);
					panel_1.add(panelChamada);
					
				}
				
				iniciaRelogio();
				
	}

	
	
	
	private void iniciaRelogio() {
		// TODO Auto-generated method stub
		new Thread(){
			public void run(){
					SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss") ;
					while(true){  
				        lblHoraRes.setText(formatter.format(new Date()));  
				        //System.out.println(formatter.format(new Date()));
				        try{
				        	Thread.currentThread().sleep(1000);  
				        }catch(Exception e){
				        	
				}
				}
			}
		}.start();
	}
	
	private void cadastrar(){
		Session session = HibernateUtil.getSession();
		Calendar data = Calendar.getInstance();
		CChamada chamada = new CChamada();
		try{
			session.getTransaction().begin();
			for(int i =0; i < this.panel_1.getComponentCount(); i++){
				Component componente = this.panel_1.getComponent(i);
				if(componente instanceof PanelAlunoChamadaNota){
					PanelAlunoChamadaNota panel = (PanelAlunoChamadaNota)componente;
					Horario obHorario = new Horario();
					
					chamada.cadastrarChamada(panel.geIdAluno(), this.cIdentificaTurma.getDisciplinaSelected().getId(), panel.getValorChamada(), data,panel.getObsAluno(), session);
				}
			}
			session.getTransaction().commit();
			//chamada.enviarEmails(this.cIdentificaTurma.getTurmaSelected(), this.cIdentificaTurma.getDisciplinaSelected(), data);
			JOptionPane.showMessageDialog(null, "Chamada Realizada com sucesso");
			this.dispose();
			//this.dispose();
		}catch(Exception ex){
			
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		
		chamada.dispararEmails(this.cIdentificaTurma.getTurmaSelected(), this.cIdentificaTurma.getDisciplinaSelected(), data);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		JRadioButton j = (JRadioButton)e.getSource();
		int i = Integer.parseInt(j.getName());
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>(this.cturma.getTurma().getAluno());
		Aluno aluno = alunos.get(i);
		this.chamada = new CChamada(aluno);
		this.chamada.enviarEmail();
		*/
		if(e.getSource().equals(this.btnCadastrar)){
			this.cadastrar();
		}
	}

}
