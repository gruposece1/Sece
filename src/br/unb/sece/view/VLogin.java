package br.unb.sece.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.JPasswordField;

import br.unb.sece.control.CLogin;
import br.unb.sece.model.Usuario;

public class VLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNome;
	public CLogin login;
	private JPasswordField txtSenha;
	

	public VLogin() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 29, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 26, 145, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(10, 72, 46, 14);
		contentPane.add(lblSenha);
		
		
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
			
		btnEntrar.setBounds(255, 106, 89, 23);
		contentPane.add(btnEntrar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(66, 69, 145, 20);
		contentPane.add(txtSenha);
		
		
		
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
	
		
		login = new CLogin();
		login.passarDados(txtNome.getText(), txtSenha.getText());

		
		if(login.getVerificar()==false)
		{
			 JOptionPane.showMessageDialog(null, "Nome ou senha inválida", "Atenção", JOptionPane.ERROR_MESSAGE);
			 txtSenha.setText("");
		}
		else
		{
			
			try{
				VPrincipal frame = new VPrincipal();
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setVisible(true);
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Ocorreu um erro no processamento", "Atenção", JOptionPane.ERROR_MESSAGE);
			}
			this.dispose();
		}
		
		
	}	
}
