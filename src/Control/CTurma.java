package Control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import exceptions.AtributoNuloException;
import exceptions.GradeNulaException;

import br.com.unb.sece.util.HibernateUtil;

import teste.Colecoes;

import Model.Disciplina;
import Model.Horario;
import Model.Serie;
import Model.Turma;
import Model.Turno;
import View.VCadTurma;

public class CTurma {
	
	private Colecoes colecao;
	private Object[][] grade2;
	private Turma turma;
	
	public CTurma(){
		colecao = new Colecoes();
	}
	
	public void gerarGrade(Serie serie, Turno turno)
	{
		
		assert(serie != null);
		assert(turno != null);
		
		float duracao = (turno.getFim() - turno.getInicio())/serie.getQtdeHorarios();
		grade2 = new Object[serie.getQtdeHorarios()][serie.getQtdeDias()]; 
		Date data = new Date();
	
		
		float inicio = turno.getInicio();
		int init = (int)inicio;		
		
		data.setHours(init);
		
		inicio = (inicio - (int)inicio)*100;
		
		data.setMinutes((int) inicio);
		
		GregorianCalendar gc = new GregorianCalendar();  
		gc.setTime(data);  
		  
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");  		
		
		//System.out.println("Numero de série: " + serie.getQtdeDias());
		
		for(int i =0; i<serie.getQtdeDias(); i++)
		{
			GregorianCalendar aux = (GregorianCalendar) gc.clone();
					
			for(int k=0; k<serie.getQtdeHorarios(); k++)
			{
				Horario horario = new Horario();
				
				horario.setHrInicial((Calendar) aux.clone());
				aux.add(Calendar.MINUTE, (int) (duracao*60));
				horario.setHrFinal((Calendar) aux.clone());
				horario.setDiaSemana(i);
				
				grade2[k][i] = horario;
				
				
				
			}
		}
		
		
		/*for(int i =0; i<serie.getQtdeDias(); i++)
		{
					
			for(int k=0; k<serie.getQtdeHorarios(); k++)
			{

				Horario h = (Horario) grade[i][k];
				
				System.out.println(sdf.format(h.getHrInicial().getTime()));  
				System.out.println(sdf.format(h.getHrFinal().getTime())); 
				System.out.println();
			}
		}*/
		
	}
	
	public void receberDados(VCadTurma VTurma) throws Exception{
		
		Serie serie = this.guardaSerie(VTurma.getCBSerie().getSelectedItem().toString());
		Turno t = this.guardaTurno(VTurma.getCBTurno().getSelectedItem().toString());
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		this.turma = new Turma();
		this.turma.setNomeTurma(VTurma.getTxtNome().getText());
		if(this.turma.getNomeTurma().equals("")){
			throw new AtributoNuloException("Nome Turma");
		}
		if(this.grade2 == null){
			throw new GradeNulaException("Grade");
		}
		try{
			
			this.turma.setSerie(serie);
			this.turma.setTurno(t);
			this.turma.salvar(session); 
			this.veriricarGradeAntesInserir();
			
			for(int i =0; i<serie.getQtdeHorarios(); i++)
			{
				for(int k=0; k<serie.getQtdeDias(); k++)
				{
					Horario h = (Horario)this.grade2[i][k];
					h.setTurma(this.turma);
					h.salvar(session);
				}
			}
			session.getTransaction().commit();
		}catch(AtributoNuloException ex){
			session.getTransaction().rollback();
			ex.printStackTrace();
			throw ex;
//			throw new Exception();
		}catch(HibernateException ex){
			
			session.getTransaction().rollback();
			ex.printStackTrace();
			throw new Exception();
		}
	}
	
	
	public void veriricarGradeAntesInserir() throws AtributoNuloException{
		for(int i =0; i<this.turma.getSerie().getQtdeHorarios(); i++)
		{
			for(int k=0; k<this.turma.getSerie().getQtdeDias(); k++)
			{
				Horario h = (Horario)this.grade2[i][k];
				try {
					h.verificar();
				} catch (AtributoNuloException e) {
					// TODO Auto-generated catch block
					throw new AtributoNuloException("O " + i +"º horário de "+ Horario.getDiaSemanaString(k) + " tem o seguinte problema: " + e.getMessage());
					
				}
			}
		}
	}
	
	public int numeroHorarios(Serie serie)
	{
		return serie.getQtdeHorarios();
	}
	
	public JButton[][] gerarBotao(Serie serie, Turno turno)
	{
		int i;
		
		JButton[][] gradeBotao = new JButton[serie.getQtdeDias()][serie.getQtdeHorarios()]; 
		
		String label[] = new String[numeroHorarios(serie)];
		
		for(i =0; i<label.length; i++)
		{
			label[i] = String.valueOf(i);
		}
		
		/*for(i =0; i<serie.getQtdeDias(); i++)
		{
					
			for(int k=0; k<serie.getQtdeHorarios(); k++)
			{
				grade[i][k] = new JButton(label[k]);
			}
		}	*/
		
		
		return gradeBotao;
	}
	
	public DefaultTableModel gerarLabel(Serie serie)
	{
		Object[][] grade = new Object[serie.getQtdeHorarios()][serie.getQtdeDias()]; 
		String nome[] = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
		
		DefaultTableModel dm = new DefaultTableModel();
		
		String[] nome2 = new String[serie.getQtdeDias()];
		
		for(int j = 0; j < serie.getQtdeDias(); j++){
			nome2[j] = nome[j];
		}
		
		for(int i =0; i<serie.getQtdeHorarios(); i++)
		{
					
			for(int k=0; k<serie.getQtdeDias(); k++)
			{
				grade[i][k] = gerarNumero(i+1);
			}
		}
		
		dm.setDataVector(grade, nome2);
		
		return dm;
	}
	
	public String gerarNumero(int num)
	{
		String label;
		
		
		label = String.valueOf(num);
		
		
		return label;
	}
	
	public ArrayList getListaTurno()
	{
		 return colecao.nomeTurno();
	}
	
	public ArrayList getListaSerie()
	{
		 return colecao.nomeSerie();
	}
	
	public Object getHorario(int linha, int coluna)
	{
		return this.grade2[linha][coluna];
	}
	
	public  Serie guardaSerie(String itemSerie){
		
		//Colecoes serie = new Colecoes();
		
		
		for (Iterator<Serie> iter = colecao.serie.iterator(); iter.hasNext();)
		{	
			Serie s = iter.next();
			if(s.getNome().equals(itemSerie))
				return s;
			
		}
		
		
		return null;
	}
	
	public  Turno guardaTurno(String itemTurno){
		
		//Colecoes turno = new Colecoes();
		
		
		for (Iterator<Turno> iter =colecao.turno.iterator(); iter.hasNext();)
		{	
			Turno t = iter.next();
			if(t.getTurno().equals(itemTurno))
				return t;
			
		}
		
		
		return null;
	}
	
	public ArrayList getAlunos(Turma turma){
		return (ArrayList)turma.getAluno();
	}
	
	public Turma selectTurma(String nome)
	{
		Turma turma = new Turma();
		
		ArrayList<Turma> nmTurma = new ArrayList<Turma>();
		
		for (Iterator<Turma> iter = turma.getAll().iterator(); iter. hasNext();)
		{	
			Turma t = iter.next();
			
			if(t.getNomeTurma().equals(nome))
				return t;
		}
		
		
		return null;
	}
	

	

	public String[] getAllTurmas(){
		ArrayList turmas = (ArrayList)Turma.getAll();
		String[] nomes = new String[turmas.size()];
		for(int i=0; i<turmas.size(); i++){
			Turma a = (Turma) turmas.get(i);
			nomes[i] = a.getNomeTurma();
		}
			
			return nomes;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Horario getHorario(){
		Horario h = new Horario();
		return h.horarioAtualTurma(turma);
	}
	
	
	
	

}
