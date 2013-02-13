package br.unb.sece.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class UtilList {

	public static Object getObject(List listaBusca, String metodoBusca, String valorBuscado) throws NullPointerException{
		Object obBuscado = null;
		for(int i =0; i < listaBusca.size(); i++){
			Object objetoAtual = listaBusca.get(i);
			Method metodo;
			String atributoBusca = null;
			try {
				metodo = objetoAtual.getClass().getMethod(metodoBusca, null);
				atributoBusca = (String) metodo.invoke(objetoAtual, null);
			} catch (Exception e) {
				
				//e.printStackTrace();
			} 
			if(atributoBusca != null && atributoBusca.equals(valorBuscado)){
				obBuscado = objetoAtual;
				break;
			}
		}
		
		if(obBuscado != null){
			return obBuscado;
		}else{
			throw new NullPointerException();
		}
				
	}
}
