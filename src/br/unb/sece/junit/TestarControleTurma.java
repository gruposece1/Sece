package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CTurma;
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
		obTurno.setFim(6);
		this.obCTurma.gerarGrade(obSerie, obTurno);
		assertNotNull(this.obCTurma.getGradeHoraria());
		
	}
	
	@Test
	public void testarGetAllTurmas(){
		
		try
		{
			obCTurma.getAllTurmas();	
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	/*@Test
	public void testarAddAlunos(){
		
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		
		listaAlunos.add(aluno);
		
		try
		{
			obCTurma.addAlunos(listaAlunos);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}*/
	
	@Test
	public void testarSelectTurma()
	{
		String nomeTurma = "Teste";
		
		try
		{
			obCTurma.selectTurma(nomeTurma);
		}
		catch(Exception e)
		{
			fail("Ocorreu um erro");
		}
	}
	
	@Test
	public void testarSelectTurmaErrado(){
	
		String nomeTurma = "Errado";
		
		Turma turma =obCTurma.selectTurma(nomeTurma);
		
		assertNull(turma);
		
	}
	
	@Test
	public void testarReceberDados()
	{
		String objeto ="3 - 5";
		
		
		this.modelSerie.setSelectedItem(objeto);
		
		try
		{
			obCTurma.receberDados(panel);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//fail("Ocorreu um erro");
		}
	}

}
