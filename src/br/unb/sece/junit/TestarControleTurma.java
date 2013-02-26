package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CTurma;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.TurnoHrInicioMaiorHrFimException;
import br.unb.sece.model.Aluno;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turma;
import br.unb.sece.model.Turno;
import br.unb.sece.util.ModelComboBox;
import br.unb.sece.util.gradehoraria.GradeHoraria;
import br.unb.sece.view.VAluno;
import br.unb.sece.view.VCadTurma;
import br.unb.sece.view.VTurma;
import br.unb.sece.view.panelcadastropadrao.VCadAluno;

public class TestarControleTurma {
	
	private CTurma obCTurma;
	private Aluno aluno;
	private VCadTurma panel;
	private ModelComboBox modelSerie;
	private Serie serie;
	
	@Before
	public void setUp(){
		
		this.obCTurma = new CTurma();
		
		aluno = new Aluno();
		aluno.setNome("dasdsa");
		aluno.setDtNascimento("11/09/2005");
		aluno.setMatricula("1234");
		aluno.setSexo("Masculino");
		
		panel = new VCadTurma();
		
		panel.getTxtNome().setText("Teste");
		
		
		serie = new Serie();
		this.modelSerie = new ModelComboBox(serie.getAll(), "getIdSerie", "getNome");
		
		
	}
	
	@Test
	public void testModelTurno(){
		ModelComboBox model = this.obCTurma.getModelSerie();
	}
	
	@Test
	public void testModelSerie(){
		ModelComboBox model = this.obCTurma.getModelTurnos();
	}
	
	@Test
	public void testModelTurnoDois(){
		ModelComboBox model = this.obCTurma.getModelSerie();
	}
	
	@Test
	public void testModelSerieDois(){
		ModelComboBox model = this.obCTurma.getModelTurnos();
	}
	
	@Test
	public void testgerarGrade(){
		Serie obSerie = new Serie();
		obSerie.setQtdeDias(3);
		obSerie.setQtdeHorarios(4);
		
		Turno obTurno = new Turno();
		obTurno.setInicio(8);
		obTurno.setFim(10);
		try {
			this.obCTurma.gerarGrade(obSerie, obTurno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Ocorreu um erro");
		} 
		assertNotNull(this.obCTurma.getGradeHoraria());
		
	}
	
	
	@Test (expected= NullPointerException.class)
	public void testSerieSelectedNull(){
		CTurma cturma = new CTurma();
		cturma.getModelSerie();
		cturma.getSerieSelected();
	}
	
	@Test (expected= NullPointerException.class)
	public void testTurnoSelectedNull(){
		CTurma cturma = new CTurma();
		cturma.getModelTurnos();
		cturma.getTurnoSelected();
	}
	
	@Test 
	public void testSerieSelected(){
		CTurma cturma = new CTurma();
		ModelComboBox model = cturma.getModelSerie();
		model.setSelectedItem("1 - 7ª");
		try{
			cturma.getSerieSelected();
		}catch(NullPointerException e){
			fail("Erro");
		}
	}
	
	@Test 
	public void testTurnoSelected(){
		CTurma cturma = new CTurma();
		ModelComboBox model = cturma.getModelTurnos();
		model.setSelectedItem("1 - Manha");
		try{
			cturma.getTurnoSelected();
		}catch(NullPointerException e){
			fail("Erro");
		}
	}
	
	
	@Test 
	public void testSetGetTurma(){
		Turma turma = new Turma();
		CTurma cturma = new CTurma();
		cturma.setTurma(turma);
		cturma.getTurma();
		cturma.getTitulosGrade(6);
	}
	
	@Test
	public void testModelSerieLabel(){
		CTurma cturma = new CTurma();
		ModelComboBox model = cturma.getModelSerie();
		model.setSelectedItem("1 - 7ª");
		try{
			Serie serie = cturma.getSerieSelected();
			cturma.gerarLabel(serie);
		}catch(NullPointerException e){
			fail("Erro");
		}
	}
	
	

}
