package Control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Model.Horario;
import Model.Serie;
import Model.Turno;

public class CTurma {
	
	public Object[][] gerarGrade(Serie serie, Turno turno)
	{
		
		float duracao = (turno.getFim() - turno.getInicio())/serie.getQtdeHorarios();
		Object[][] grade = new Object[serie.getQtdeDias()][serie.getQtdeHorarios()]; 
		Date data = new Date();
		
		float inicio = turno.getInicio();
		int init = (int)inicio;		
		
		data.setHours(init);
		
		inicio = (inicio - (int)inicio)*100;
		
		data.setMinutes((int) inicio);
		
		GregorianCalendar gc = new GregorianCalendar();  
		gc.setTime(data);  
		  
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");  		
		
		for(int i =0; i<serie.getQtdeDias(); i++)
		{
			GregorianCalendar aux = (GregorianCalendar) gc.clone();
					
			for(int k=0; k<serie.getQtdeHorarios(); k++)
			{
				Horario horario = new Horario();
				
				horario.setHrInicial((Calendar) aux.clone());
				aux.add(Calendar.MINUTE, (int) (duracao*60));
				horario.setHrFinal((Calendar) aux.clone());
				
				grade[i][k] = horario;
				
				
				
			}
		}
		
		
		for(int i =0; i<serie.getQtdeDias(); i++)
		{
					
			for(int k=0; k<serie.getQtdeHorarios(); k++)
			{

				Horario h = (Horario) grade[i][k];
				
				//System.out.println(sdf.format(h.getHrInicial().getTime()));  
				//System.out.println(sdf.format(h.getHrFinal().getTime())); 
				//System.out.println();
			}
		}
		
		return grade;
	}

}
