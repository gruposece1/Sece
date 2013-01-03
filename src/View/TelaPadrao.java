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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPadrao extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static public ArrayList lista = new ArrayList();
	
	public static Collection lista()
	{
		
		
		Teste t1 = new Teste("Lucas", "Gama");
		Teste t2 = new Teste("Gustavo", "Gama");
		
		lista.add(t1);
		lista.add(t2);
		
		return lista;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPadrao frame = new TelaPadrao(lista());
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 32, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(73, 29, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setToolTipText("");
		lblEndereco.setBounds(20, 70, 49, 14);
		contentPane.add(lblEndereco);
		
		textField_1 = new JTextField();
		textField_1.setBounds(73, 67, 115, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setBounds(20, 106, 46, 14);
		contentPane.add(lblCep);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 103, 115, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(282, 32, 46, 14);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("M");
		rdbtnMasculino.setBounds(324, 28, 49, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("F");
		rdbtnFeminino.setBounds(372, 28, 46, 23);
		contentPane.add(rdbtnFeminino);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 320, 443, 216);
		contentPane.add(scrollPane);

		model = new DefaultListModel();
		final JList list = new JList(model);
		list.setListData(criarLista(lista));
		
		select = new DefaultListSelectionModel();
		list.setSelectionModel(select);
		scrollPane.setViewportView(list);
		
		list.addListSelectionListener(new ListSelectionListener()
		{
				
			public void valueChanged(ListSelectionEvent e) {
				
				if(!e.getValueIsAdjusting())
				{
					String obj = (String) list.getSelectedValue();
					Teste teste = (Teste)itemSelecionado(obj);
					
					textField.setText(teste.getLocal());
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


