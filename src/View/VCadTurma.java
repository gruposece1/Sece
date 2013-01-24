package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultCellEditor;

import Control.CTurma;
import Model.Horario;
import Model.Serie;
import Model.Turno;

import teste.Colecoes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import exceptions.AtributoNuloException;
import exceptions.GradeNulaException;

public class VCadTurma extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNome;
	private Colecoes colecao;
	private JTable table;
	private CTurma CTurma;
	private JComboBox CBTurno;
	private JComboBox CBSerie;
	private JButton btnCadastrar;
	

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
		
		CBTurno = new JComboBox(CTurma.getListaTurno().toArray());
		CBTurno.setBounds(60, 55, 86, 20);
		contentPane.add(CBTurno);
		
		
		
		JLabel lblHorrio = new JLabel("S\u00E9rie: ");
		lblHorrio.setBounds(10, 100, 46, 14);
		contentPane.add(lblHorrio);
		
		CBSerie = new JComboBox(CTurma.getListaSerie().toArray());
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
				
				Turno turno;
				Serie serie;
				
				String nome[] = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
				//String nome[] = {"Segunda", "Terça", "Quarta", "Quinta"};
				
				String itemTurno = CBTurno.getSelectedItem().toString(); 
				String itemSerie = CBSerie.getSelectedItem().toString(); 
				
				
				turno = CTurma.guardaTurno(itemTurno);
				serie = CTurma.guardaSerie(itemSerie);
				
				if(turno != null)
					System.out.println("ok\n");
				if(serie != null)
					System.out.println("ok2\n");
				
				
				
				table.setModel(CTurma.gerarLabel(serie));
				CTurma.gerarGrade(serie, turno);
				//table.setModel(new DefaultTableModel((c.gerarBotao((Serie)colecao.serie.get(0), (Turno)colecao.turno.get(0))),nome));
				
				for(int i =0; i<serie.getQtdeDias(); i++)
				{
					
					table.getColumn(nome[i]).setCellRenderer(new ButtonRenderer());
					    table.getColumn(nome[i]).setCellEditor(
					        new ButtonEditor(new JCheckBox(), table, CTurma));
					    
				}		
					
				
				
				
				//c.gerarGrade((Serie)colecao.serie.get(0), (Turno)colecao.turno.get(0));
				
			}
		});
		
		
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
		
	}
	
	
}
