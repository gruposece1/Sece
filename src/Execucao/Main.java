package Execucao;

import java.awt.EventQueue;
import java.util.ArrayList;

import View.Teste;
import View.VLogin;

public class Main {
	
static public ArrayList lista = new ArrayList();
	

	public static ArrayList lista()
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
				
			
					
					VLogin login = new VLogin(lista());	
					login.setVisible(true);
						
						
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
