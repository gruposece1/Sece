package br.com.unb.sece.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializacao {
	
	public Serializacao(Object ob, String nomeAruivo) throws IOException,Exception{
				// Criação de um arquivo de saída.
				FileOutputStream fos = new	FileOutputStream(nomeAruivo);
				// Criação de objeto Stream que permitirá a gravação do objeto no arquivo de saída.
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				// Objeto é efetivamente gravado no arquivo.
				oos.writeObject(ob);
				oos.close();
	}
}
