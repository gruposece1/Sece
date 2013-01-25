package br.unb.sece.exceptions;
import java.util.*;

public class TelefoneException  {

	public static void main(String args[]){
		String telefone = "619196-0621";
		
		boolean tipo = telefone.matches("^[a-zA-Z0-9]([a-zA-Z0-9\\.\\-\\_])+@(hotmail|gmail)\\-com");
		
		String nome = "Sece UnB";
		
		//tipo = nome.matches("^[A-Z]([a-zA-Z\\ ])+");

		tipo = "12".matches("[10-21]");
		
		System.out.println(tipo);
	}
		
	
}
