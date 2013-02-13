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


import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.GradeNulaException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Horario;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.Turno;
import br.unb.sece.util.HibernateUtil;
import br.unb.sece.util.gradehoraria.GradeHoraria;
import br.unb.sece.view.VCadTurma;

import teste.Colecoes;


public class CTurma {
	
	private Colecoes colecao;
	//private Object[][] grade2;
	private Turma turma;
	private GradeHoraria gradeHoraria;
	
	public CTurma(){
		colecao = new Colecoes();
	}
	
	
	public void gerarGrade(Serie serie, Turno turno)
	{
		
		this.gradeHoraria = new GradeHoraria (serie, turno);
		
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
		if(this.gradeHoraria.getGradeDeHorarios() == null){
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
					Horario h = this.gradeHoraria.getHorario(i, k);
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
				Horario h = this.gradeHoraria.getHorario(i, k);
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
		
		
		return gradeBotao;
	}
	
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
		return this.gradeHoraria.getHorario(linha, coluna);
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
	
	public ArrayList<Aluno> getAlunos(Turma turma){
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
	
	public void addAlunos(ArrayList alunos){
		List todos = Aluno.getAll();
		ArrayList alunosTurma = new ArrayList();
		for(int i = 0; i < alunos.size();i++){
			String matricula = alunos.get(i).toString().split(" ")[0];
			Aluno aluno = (Aluno) UtilList.getObject(todos, "getMatricula", matricula);
			alunosTurma.add(aluno);
		}
		
		turma.setAluno(alunosTurma);
		turma.alterar();
	}
	
	

}
