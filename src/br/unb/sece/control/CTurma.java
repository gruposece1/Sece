package br.unb.sece.control;

import java.text.SimpleDateFormat;
import br.unb.sece.util.UtilList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.GradeNulaException;
import br.unb.sece.exceptions.TurnoHrInicioMaiorHrFimException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Professor;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.TurmaDisciplina;
import br.unb.sece.model.Turno;
import br.unb.sece.util.HibernateUtil;
import br.unb.sece.util.ModelComboBox;
import br.unb.sece.util.gradehoraria.GradeHoraria;
import br.unb.sece.view.VCadTurma;



public class CTurma {
	
	//private Object[][] grade2;
	private Turma turma;
	private GradeHoraria gradeHoraria;
	private ModelComboBox modelSerie = null;
	private ModelComboBox modelTurno = null;
	
	public CTurma(){
		
	}
	
	
	public void gerarGrade(Serie serie, Turno turno) throws NullPointerException, ArithmeticException, IndexOutOfBoundsException, TurnoHrInicioMaiorHrFimException
	{
		this.gradeHoraria = new GradeHoraria (serie, turno);
		
	}
	
	public void cadastrarTurma(String nomeTurma,Serie serie, Turno turno, GradeHoraria gradeHoraria) throws Exception{
		Turma turma = new Turma();
		
		turma.setNomeTurma(nomeTurma);
		
		turma.setSerie(serie);
		
		turma.setTurno(turno);
		
		Session session = HibernateUtil.getSession();
		
		session.getTransaction().begin();
		
		turma.salvar(session);
		
		try{
		
			gradeHoraria.verificarGrade();
			
			gradeHoraria.gerarTurmasDisciplinas(turma, session);
			
			gradeHoraria.salvarGrade(session);
			
			
			session.getTransaction().commit();
		
		}catch(HibernateException ex){
			session.getTransaction().rollback();
			HibernateUtil.closeSession();
			ex.printStackTrace();
		}catch(Exception ex){
			session.getTransaction().rollback();
			HibernateUtil.closeSession();
			throw ex;
		}
		
		
		
	}
	
	public void receberDados(VCadTurma VTurma) throws Exception{
		
		Serie serie = this.getSerieSelected();
		Turno t = this.getTurnoSelected();
		
		Session session = HibernateUtil.getSession();
		//session.beginTransaction();
		this.turma = new Turma();
		this.turma.setNomeTurma(VTurma.getTxtNome().getText());
		this.cadastrarTurma(VTurma.getTxtNome().getText(), serie, t, this.gradeHoraria);
		
		
	}
	
	
	
	/*
	public int numeroHorarios(Serie serie)
	{
		return serie.getQtdeHorarios();
	}
	*/
	
	
	/*
	 * Gerar um DefaultTableModel com os dias da semana da serie
	 * @param serie usado para definir o tamanho do TableModel
	 */
	public DefaultTableModel gerarLabel(Serie serie)
	{
		Object[][] grade = new Object[serie.getQtdeHorarios()][serie.getQtdeDias()]; 
		
		DefaultTableModel dm = new DefaultTableModel();
		
		String[] diasDaSemanaDaSerie = this.getTitulosGrade(serie.getQtdeDias());
		
		
		for(int i =0; i<serie.getQtdeHorarios(); i++)
		{
					
			for(int k=0; k<serie.getQtdeDias(); k++)
			{
				grade[i][k] = gerarNumero(i+1);
			}
		}
		
		dm.setDataVector(grade, diasDaSemanaDaSerie);
		
		return dm;
	}
	
	public String[] getTitulosGrade(int qteDias){
		String diasDaSemana[] = Serie.getDiasDaSemana();
		String[] diasDaSemanaDaSerie = new String[qteDias];
		
		for(int j = 0; j < qteDias; j++){
			diasDaSemanaDaSerie[j] = diasDaSemana[j];
		}
		
		return diasDaSemanaDaSerie;
	}
	
	public String gerarNumero(int num)
	{
		String label;
		
		
		label = String.valueOf(num);
		
		
		return label;
	}
	
	
	
	
	public Object getHorario(int linha, int coluna)
	{
		return this.gradeHoraria.getHorario(linha, coluna);
	}
	
	
	
	public ModelComboBox getModelSerie(){
		
		if(this.modelSerie == null){
			
			Serie serie = new Serie();
			this.modelSerie = new ModelComboBox(serie.getAll(), "getIdSerie", "getNome");
			
		}
		
		return this.modelSerie;
	}
	
	public ModelComboBox getModelTurnos(){
		
		if(this.modelTurno == null){
			
			Turno turno = new Turno();
			this.modelTurno = new ModelComboBox(turno.getAll(), "getId", "getTurno");
			
		}
		
		return this.modelTurno;
	}
	
	public Turno getTurnoSelected() throws NullPointerException{
		Turno obTurno = (Turno)this.modelTurno.getSelectedItemObject();
		if(obTurno == null){
			throw new NullPointerException("Turno");
		}
		return obTurno;
	}
	
	public Serie getSerieSelected() throws NullPointerException{
		Serie obSerie = (Serie)this.modelSerie.getSelectedItemObject();
		if(obSerie == null){
			throw new NullPointerException("Serie");
		}
		return obSerie;
	}
	

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

	public GradeHoraria getGradeHoraria() {
		return gradeHoraria;
	}


	
	
	

}
