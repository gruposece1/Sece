package br.unb.sece.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultCellEditor;


import teste.Colecoes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import br.unb.sece.control.CTurma;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.GradeNulaException;
import br.unb.sece.exceptions.TurnoHrInicioMaiorHrFimException;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turno;


public class VCadTurma extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNome;
	private Colecoes colecao;
	private JTable table;
	private CTurma CTurma;
	private JComboBox CBTurno;
	private JComboBox CBSerie;
	private JButton btnCadastrar;
	private JButton btnGerarGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCadTurma frame = new VCadTurma();
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
	public VCadTurma() {
		
		colecao = new Colecoes();
		CTurma = new CTurma();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle("Cadastro de Turma");
		setBounds(100, 100, 615, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTurno = new JLabel("Turno: ");
		lblTurno.setBounds(10, 58, 46, 14);
		contentPane.add(lblTurno);
		
		CBTurno = new JComboBox(CTurma.getModelTurnos());
		CBTurno.setBounds(60, 55, 86, 20);
		contentPane.add(CBTurno);
		
		
		
		JLabel lblHorrio = new JLabel("S\u00E9rie: ");
		lblHorrio.setBounds(10, 100, 46, 14);
		contentPane.add(lblHorrio);
		
		CBSerie = new JComboBox(CTurma.getModelSerie());
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
		
		
		
		btnGerarGrade = new JButton("Gerar Grade");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		btnGerarGrade.addActionListener(this);
		
		
		btnGerarGrade.setBounds(10, 139, 108, 23);
		contentPane.add(btnGerarGrade);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBounds(128, 139, 100, 23);
		contentPane.add(btnCadastrar);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JComboBox getCBTurno() {
		return CBTurno;
	}

	public void setCBTurno(JComboBox cBTurno) {
		CBTurno = cBTurno;
	}

	public JComboBox getCBSerie() {
		return CBSerie;
	}

	public void setCBSerie(JComboBox cBSerie) {
		CBSerie = cBSerie;
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(this.btnCadastrar)){
			try{
				this.CTurma.receberDados(this);
				this.setVisible(false);
				JOptionPane.showMessageDialog(null, "Dados Cadastrados", "Atenção", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				
			}catch(GradeNulaException ex){
				JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage() + " não pode ser nulo.", "Atenção", JOptionPane.ERROR_MESSAGE);
			
			}catch(AtributoNuloException ex){
				JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage() + " não pode ser nulo.", "Atenção", JOptionPane.ERROR_MESSAGE);
			
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			
		}
		
		if(e.getSource().equals(this.btnGerarGrade)){
			this.gerarGrade();
		}
		
		if(e.getSource() instanceof JButtonGradeHorario){
			JButtonGradeHorario btn = (JButtonGradeHorario)e.getSource();
			//System.out.println("A coluna: "+btn.getDiaDaSemana()+" horarios: "+btn.getHorario());
			btn.setText("Professor: Gustavo Coelho\n Disciplina: Português");
			btn.setBackground(new Color(1));
		}
		//System.out.println(e.getSource());
		
		
		
	}
	
	
	private void gerarGrade(){
		Turno turno;
		Serie serie;
		
		try{
			turno = CTurma.getTurnoSelected();
			serie = CTurma.getSerieSelected();
			table.setModel(CTurma.gerarLabel(serie));
			CTurma.gerarGrade(serie, turno);
			this.criarBotoes(serie.getQtdeDias(),serie.getQtdeHorarios());
		}catch(NullPointerException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "O campo deve ser preenchido: " + ex.getMessage(), "Atenção", JOptionPane.ERROR_MESSAGE);
		} catch (ArithmeticException ex) {
			
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "A quantidade de horário da Série não pode ser igual a zero", "Atenção", JOptionPane.ERROR_MESSAGE);
		} catch (IndexOutOfBoundsException ex) {
			JOptionPane.showMessageDialog(null, "A quantidade de dias da Série não pode ser menor que um.", "Atenção", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		} catch (TurnoHrInicioMaiorHrFimException ex) {
			JOptionPane.showMessageDialog(null, "O fim do Turno é menor que o início", "Atenção", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	private void criarBotoes(int qtdeDias, int qtdeHorarios){
		
		String diasDaSemana[] = Serie.getDiasDaSemana();
		/*
		ButtonEditor btn = new ButtonEditor(new JCheckBox(), table, CTurma);
		table.setCellEditor(btn);
		
		DefaultTableModel  df = (DefaultTableModel) table.getModel();
		Object[][] botoes = new Object[qtdeHorarios][qtdeDias];
		
		for(int i = 0; i < qtdeDias;i++){
			//table.getColumn(diasDaSemana[i]).setCellRenderer(new ButtonRenderer());
			ArrayList botoes2 = new ArrayList();
			for(int j = 0; j < qtdeHorarios; j++){
				
				btn.setDiaDaSemana(i);
				btn.setHorario(j);
				botoes[j][i] = btn;
				botoes2.add(btn);
				
			}
			//table.getColumn(diasDaSemana[i]).setCellEditor((Object)botoes2);
		}
		
		//df.setDataVector(botoes,this.CTurma.getTitulosGrade(qtdeDias));
		//table.setModel(df);
		
		
		 */
		for(int i =0; i< qtdeDias; i++){
			table.getColumn(diasDaSemana[i]).setCellRenderer(new JButtonGradeHorario());
			ButtonEditor btn = new ButtonEditor(new JCheckBox(), table, CTurma);
			btn.setDiaDaSemana(i);
			table.getColumn(diasDaSemana[i]).setCellEditor(btn);
			    
		}
	}
	
	
}
