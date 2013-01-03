package teste;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Serie;
import Model.Turno;

public class Colecoes {
	
	public ArrayList turno, serie;
	
	public Colecoes()
	{
		turno = new ArrayList();
		serie = new ArrayList();
		
		
		Turno t = new Turno(7, 12, Turno.MANHA);
		Turno t1 = new Turno(14, 18, Turno.TARDE);
		Turno t2 = new Turno(8, 13, Turno.MANHA);
		
		Serie s = new Serie("8", 5, 5);
		Serie s1 = new Serie("7", 4, 5);
		
		turno.add(t);
		turno.add(t1);
		turno.add(t2);
		
		serie.add(s);
		serie.add(s1);
	}
	
	public ArrayList nomeSerie()
	{
		ArrayList nmSerie = new ArrayList();
		
		for (Iterator iter = serie.iterator(); iter. hasNext(); )
		{	
			Serie serie = (Serie)iter.next();
			
			nmSerie.add(serie.getNome());
			
		}
		
		return nmSerie;
	}
	
	public ArrayList nomeTurno()
	{
		ArrayList nmTurno = new ArrayList();
		
		for (Iterator iter = turno.iterator(); iter. hasNext(); )
		{	
			Turno turno = (Turno)iter.next();
			
			nmTurno.add(turno.getTurno());
			
		}
		
		return nmTurno;
	}
	
	
	

}
