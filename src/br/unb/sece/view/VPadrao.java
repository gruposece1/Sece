package br.unb.sece.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;


import br.unb.sece.control.CLogin;
import br.unb.sece.control.CPadrao;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.util.IPadrao;
import br.unb.sece.util.crudpadrao.ModeloDeTabela;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class VPadrao extends JFrame implements IPadrao, ActionListener{

	private JPanel contentPane;
	private JTable table;
	protected CPadrao controle;
	protected Object painel;
	protected JPanel panel;
	private JButton btnCadastrar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	
	/*
	 * Create the frame.
	 */
	public VPadrao() {
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.criarControle();
		
		DefaultListModel model;
		DefaultListSelectionModel select;
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		
		btnCadastrar.setBounds(20, 259, 107, 23);
		contentPane.add(btnCadastrar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(472, 317, 89, 23);
		btnAlterar.addActionListener(this);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(472, 351, 89, 23);
		btnExcluir.addActionListener(this);
		contentPane.add(btnExcluir);

		model = new DefaultListModel();
		
		select = new DefaultListSelectionModel();
		
		
		panel = new JPanel(); 
		this.criarPainel();
		panel.setBounds(20, 11, 522, 234);
		
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 307, 425, 229);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		//new ModeloDeTabela(this.controle.getDados(),this.controle.getTitulos())
		table.setModel(this.controle.getDefaultTableModel());
		table.setCellSelectionEnabled(false);
	}
	
	/**
	 * Gerencia os eventos de click do mouse
	 */
	
	 public void actionPerformed(ActionEvent e) {
		 if(e.getSource().equals(this.btnCadastrar)){
			 if(this.btnCadastrar.getText().equals("Cadastrar")){
				 
				this.actionInsert();
			 
			 }else if(this.btnCadastrar.getText().equals("Alterar")){
				
				 this.actionAlterInsert();
			 }
			 
		 }else if(e.getSource().equals(btnAlterar)){
			 
			 this.actionAlter();
			 
		 }else if(e.getSource().equals(this.btnExcluir)){
			
			this.actionDelete();
		 }
         
	 }
	 
	/**
	 *  Recupera um objeto da grade
	 * @return Object objeto da grade selecionado
	 * @throws NullPointerException
	 */
	public Object retonarObjetoGrade()throws NullPointerException{
		
		Object obj = this.controle.getObjetoTabela(this.table.getSelectedRow(),this.controle.getTitulos().length);
		return obj;
	}
	
	/**
	 * Método para criar o controle associado a interface
	 */
	public abstract  void criarControle();
	
	/**
	 * Método para criar o Panel associado a interface
	 */
	public abstract void criarPainel();
	
	/**
	 * Método para colocar os dados na interface
	 */
	public abstract void popularInterface();
	
	@Override
	public  void salvar(){
		this.controle.salvar();
	}


	@Override
	public abstract void alterar();



	@Override
	public abstract void passarDados() throws Exception;

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	/**
	 * Gerenciar o click no botao cadastrar com o texto Alterar
	 */
	private void actionAlterInsert(){
		try {
			int escolhaUsuario = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar o registro?","Confirmação",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(escolhaUsuario == JOptionPane.OK_OPTION){
				this.controle.receberDados(this, CPadrao.OPERACAO_ALTERAR);
				
				this.controle.alterar();
				
				table.setModel(this.controle.getDefaultTableModel());
				
				JOptionPane.showMessageDialog(null, "Dados Alterados", "Atenção", JOptionPane.INFORMATION_MESSAGE);
			}else{
				this.btnCadastrar.setText("Cadastrar");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.btnCadastrar.setText("Cadastrar");
		
	}
	
	/**
	 * Gerenciar o click no botao alterar
	 */
	private void actionAlter(){
		
		this.popularInterface();
		 
		this.btnCadastrar.setText("Alterar");
	}
	
	/**
	 * Gerenciar o click no botao cadastrar
	 */
	private void actionInsert(){
		try{
			this.controle.receberDados(this,CPadrao.OPERACAO_INSERIR);
			
			this.salvar();
			
			table.setModel(this.controle.getDefaultTableModel());
			
			JOptionPane.showMessageDialog(null, "Dados Cadastrados", "Atenção", JOptionPane.INFORMATION_MESSAGE);
		
		}catch(AtributoNuloException ex){
			
			JOptionPane.showMessageDialog(null, "Algum campo esta em branco", "Atenção", JOptionPane.ERROR_MESSAGE);
		
		}catch(Exception ex){
			
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	/**
	 * Gerenciar o click no botao excluir
	 */
	private void actionDelete(){
		try{
			int escolhaUsuario = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?","Confirmação",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(escolhaUsuario == JOptionPane.OK_OPTION){
				
				Object objDelete = this.retonarObjetoGrade();
		
				this.controle.excluir(objDelete);
		
				table.setModel(this.controle.getDefaultTableModel());
		
				JOptionPane.showMessageDialog(null, "Dados Excluidos", "Atenção", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(BancoDeDadosException ex){
			
			JOptionPane.showMessageDialog(null, "Ocorrecu o seguinte erro: " + ex.getMessage(), "Atenção", JOptionPane.ERROR_MESSAGE);
			
		}catch(NullPointerException ex){
			
			JOptionPane.showMessageDialog(null, "Nenhum registro selecionado", "Atenção", JOptionPane.ERROR_MESSAGE);
			
			ex.printStackTrace();
		}
	}
	
	
}	


