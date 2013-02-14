package br.unb.sece.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.unb.sece.control.CTurma;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turno;
import br.unb.sece.util.ModelComboBox;
import br.unb.sece.util.gradehoraria.GradeHoraria;

public class TestarControleTurma {
	
	private CTurma obCTurma;
	
	@Before
	public void setUp(){
		
		this.obCTurma = new CTurma();
		
		
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

}
