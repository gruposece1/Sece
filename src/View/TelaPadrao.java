package View;


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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JList;

import Control.CLogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPadrao extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static public ArrayList lista = new ArrayList();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public TelaPadrao(Collection lista) {
		
		DefaultListModel model;
		DefaultListSelectionModel select;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnCadastrar.setBounds(20, 259, 107, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(472, 317, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(472, 351, 89, 23);
		contentPane.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 320, 443, 216);
		contentPane.add(scrollPane);

		model = new DefaultListModel();
		final JList list = new JList(model);
		list.setListData(criarLista(lista));
		
		select = new DefaultListSelectionModel();
		list.setSelectionModel(select);
		scrollPane.setViewportView(list);
		
		VCadMatricula vcadMatricula = new VCadMatricula();
		
		JPanel panel = new JPanel();
		panel = vcadMatricula;
		panel.setBounds(20, 11, 522, 234);
		
		contentPane.add(panel);
		
		list.addListSelectionListener(new ListSelectionListener()
		{
				
			public void valueChanged(ListSelectionEvent e) {
				
				if(!e.getValueIsAdjusting())
				{
					String obj = (String) list.getSelectedValue();
					Teste teste = (Teste)itemSelecionado(obj);
					
					//textField.setText(teste.getLocal());
				}	
				
			}
			
		});
		
		
		
		
		
	
	}
	
	public String[] criarLista(Collection lista)
	{
		
		Teste t[] = new Teste[lista.size()];
		String entry[] = new String[lista.size()];
	
		for (Iterator iter = lista.iterator(); iter. hasNext(); )
		{	
			for (int k=0; k<t.length; k++)
			{
				t[k] = (Teste) iter.next();
				entry[k] = t[k].getNome();
			}
		}
		
		return entry;
	}
	
	public Object itemSelecionado(Object dado)
	{
		for (Iterator iter = lista.iterator(); iter. hasNext(); )
		{	
			Object obj = iter.next();
			
			if(obj.toString().equals(dado))
				return obj;
		}
		
		return null;
	}
}	


