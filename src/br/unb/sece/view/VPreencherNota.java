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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import br.unb.sece.control.CNota;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Nota;
import br.unb.sece.model.Pessoa;
import br.unb.sece.model.Turma;
import br.unb.sece.util.HibernateUtil;
import br.unb.sece.view.util.PanelAlunoChamadaNota;

import java.awt.Scrollbar;



import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VPreencherNota extends JFrame implements ActionListener {

	
	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel lblNada;
	private JLabel lblHoraRes = new JLabel("");
	private JTextField textFieldAnotation;
	private CNota cnota;
	private CChamada chamada;
	private JButton btnCadastrar;

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
	public VPreencherNota(CNota cnota) throws InterruptedException {
		this.cnota=cnota;
		setResizable(false);
				setTitle("SECE - Sistema Escolar de Chamada Eletr\u00F4nica");

				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				setBounds(100, 100, 1340, 788);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				
				
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
				
				JLabel lblTurmaRes = new JLabel(cnota.getTurma().getNomeTurma());
				lblTurmaRes.setBounds(78, 12, 64, 14);
				panel.add(lblTurmaRes);
				
				JLabel lblDisciplinaRes = new JLabel(cnota.getHorario().getDisciplina().getNome());
				lblDisciplinaRes.setBounds(78, 37, 7*cnota.getHorario().getDisciplina().getNome().length(), 14);
				panel.add(lblDisciplinaRes);
				
				JLabel lblProfessorRes = new JLabel(cnota.getHorario().getProfessor().getNome());
				lblProfessorRes.setBounds(78, 62, 7*cnota.getHorario().getProfessor().getNome().length(), 14);
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
				
				this.btnCadastrar = new JButton("Salvar");
				btnCadastrar.setBounds(32, 595, 100, 50);
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
				
				JLabel lblNota01 = new JLabel("Nota 01");
				lblNota01.setForeground(Color.BLACK);
				lblNota01.setBounds(246, 11, 60, 14);
				panelHeader.add(lblNota01);
				
				JLabel lblNota02 = new JLabel("Nota 02");
				lblNota02.setForeground(Color.BLACK);
				lblNota02.setBounds(303, 11, 44, 14);
				panelHeader.add(lblNota02);
				
				JLabel lblNota03 = new JLabel("Nota 03");
				lblNota03.setForeground(Color.BLACK);
				lblNota03.setBounds(357, 11, 83, 14);
				panelHeader.add(lblNota03);
				
				JLabel lblNota04 = new JLabel("Nota 04");
				lblNota04.setBounds(410, 11, 108, 14);
				panelHeader.add(lblNota04);
				
				//JPanel []panelAlunos = addPanelAluno();
				
				panelHeader.setBounds(10, 11, 1103, 33);
				
				
				ArrayList<Aluno> lista = new ArrayList<Aluno>(cnota.getTurma().getAluno());
				System.out.println("VTurma a qtde na turma : " + lista.size());
				PanelAlunoChamadaNota panelChamada;
				int tamanho = 34;
				for(int i=0; i< lista.size(); i++){
					tamanho = (i+1) * 34;
					
					System.out.println(cnota.getBimestre());
					
					panelChamada = new PanelAlunoChamadaNota(lista.get(i).getIdPessoa(), lista.get(i).getNome(),lista.get(i).getMatricula(),tamanho, PanelAlunoChamadaNota.NOTA, cnota.getBimestre(), this.cnota.getNotas(lista.get(i), this.cnota.getDisciplina(), Nota.getNota()));
					panel_1.add(panelChamada);
					
				}
				
				iniciaRelogio();
				
	}

	private JPanel[] addPanelAluno(){
		

		
		//Pegar antes a quantidade de alunos
		final int QNT_ALUNOS=cnota.getTurma().getAluno().size();
		JPanel []panelChamadaEstrutura = new JPanel[QNT_ALUNOS];
		
		System.out.println("A qtde alunos: "+QNT_ALUNOS);
		final int tamanho = 34;
		int j=0, tam = 679;
		for(int i=0; i<QNT_ALUNOS; i++){
			
			if(j>=679)
			{
				panel_1.setBounds(190, 23, 1144, tam=tam+34);
				panel_1.setPreferredSize(new Dimension(1144,tam=tam+34));
			}
				
			panelChamadaEstrutura[i] = new JPanel();
			j=j+tamanho;
			panelChamadaEstrutura[i].setBounds(10, j, 1103, 33);
			panelChamadaEstrutura[i].setLayout(null);
			System.out.println("A qtde de alunos: " + cnota.getTurma().getAluno().size());
			Collection c = cnota.getTurma().getAluno();
			ArrayList<Aluno> alunos = new ArrayList<Aluno>(c);
			Aluno a = alunos.get(i);
			//for(Object obj: c){
				// a = (Aluno)obj;
			//}
			//ArrayList alunos = (ArrayList)c;
	
			//Aluno a = (Aluno) alunos.get(i);
			JLabel lblMatNomeAluno = new JLabel(a.getNome());
			//lblMatNomeAluno.setText("AAAA");
			lblMatNomeAluno.setBounds(10, 11, 272, 14);
			panelChamadaEstrutura[i].add(lblMatNomeAluno);
			
			ButtonGroup chamadaGroup = new ButtonGroup();
			
			JRadioButton radioPresente = new JRadioButton("");
			radioPresente.setBounds(267, 7, 21, 23);
			
			JRadioButton radioFalta = new JRadioButton("");
			radioFalta.setBounds(317, 7, 21, 23);
			radioFalta.setName(String.valueOf(i));
			//radioFalta.addActionListener(this);
			//chamada = new CChamada(a);
			/*
			radioFalta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					chamada.enviarEmail();
				
				}
					});
			
			*/
			
			JRadioButton radioAtrasado = new JRadioButton("");
			radioAtrasado.setBounds(366, 7, 21, 23);
			
			chamadaGroup.add(radioPresente);
			chamadaGroup.add(radioFalta);
			chamadaGroup.add(radioAtrasado);
			panelChamadaEstrutura[i].add(radioPresente);
			panelChamadaEstrutura[i].add(radioFalta);
			panelChamadaEstrutura[i].add(radioAtrasado);
			
			textFieldAnotation = new JTextField();
			textFieldAnotation.setBounds(427, 8, 666, 20);
			panelChamadaEstrutura[i].add(textFieldAnotation);
			textFieldAnotation.setColumns(10);
			
		}
		
		
		
		

		return panelChamadaEstrutura;
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
		try{
			session.getTransaction().begin();
			
			for(int i =0; i < this.panel_1.getComponentCount(); i++){
				Component componente = this.panel_1.getComponent(i);
				if(componente instanceof PanelAlunoChamadaNota){
					PanelAlunoChamadaNota panel = (PanelAlunoChamadaNota)componente;
					this.cnota.salvarNota(panel.geIdAluno(), this.cnota.getDisciplina(), panel.getNotas(), this.cnota.getBimestre(), session);
				}
			}
			session.getTransaction().commit();
			this.dispose();
		}catch(Exception ex){
			
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		JRadioButton j = (JRadioButton)e.getSource();
		int i = Integer.parseInt(j.getName());
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>(this.cnota.getTurma().getAluno());
		Aluno aluno = alunos.get(i);
		this.chamada = new CChamada(aluno);
		this.chamada.enviarEmail();
		*/
		if(e.getSource().equals(this.btnCadastrar)){
			this.cadastrar();
		}
	}

}
