package br.unb.sece.junit;

import static org.junit.Assert.*;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.fest.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.Test;

import br.unb.sece.model.Chamada;
import br.unb.sece.view.VLogin;
import br.unb.sece.view.util.PanelAlunoChamadaNota;

public class TestePanelAlunoChamadaNota {
	
	private FrameFixture window;
	private PanelAlunoChamadaNota panel;

	@Before
	public void setUp() {
		Long idAluno = (long) 1;
		String nomeAluno = "Teste";
		String matricula = "3";
		int tamanho = 34;
		panel = new PanelAlunoChamadaNota(idAluno, nomeAluno, matricula, tamanho, PanelAlunoChamadaNota.CHAMADA);
		JFrame frame = new JFrame();
		frame.add(panel);
		window = new FrameFixture(frame);
		window.show(new Dimension(700,500));
	}
	
	@Test
	public void testPanelNotaGetValorChamadaPresente() {
		
		
		window.radioButton("Presente").click();
		assertEquals(Chamada.ALUNO_PRESENTE, panel.getValorChamada());
	}
	
	@Test
	public void testPanelNotaGetObsAluno() {
		
		String obsAluno = "Não compareceu a aula";
		window.textBox("obsAluno").enterText(obsAluno);
		assertEquals(obsAluno, panel.getObsAluno());
		window.close();
	}
	
	@Test
	public void testPanelNotaGetValorChamadaAtraso() {
		
		
		window.radioButton("Atrasado").click();
		assertEquals(Chamada.ALUNO_ATRASADO, panel.getValorChamada());
		
	}
	
	
	@Test
	public void testPanelChamada() {
		Long idAluno = (long) 1;
		String nomeAluno = "Teste";
		String matricula = "3";
		int tamanho = 34;
		PanelAlunoChamadaNota panel = new PanelAlunoChamadaNota(idAluno, nomeAluno, matricula, tamanho, PanelAlunoChamadaNota.CHAMADA);
	}
	
	@Test
	public void testPanelNota() {
		Long idAluno = (long) 1;
		String nomeAluno = "Teste";
		String matricula = "3";
		int tamanho = 34;
		PanelAlunoChamadaNota panel = new PanelAlunoChamadaNota(idAluno, nomeAluno, matricula, tamanho, PanelAlunoChamadaNota.NOTA);
	}
	
	@Test
	public void testPanelNotaDefault() {
		Long idAluno = (long) 1;
		String nomeAluno = "Teste";
		String matricula = "3";
		int tamanho = 34;
		PanelAlunoChamadaNota panel = new PanelAlunoChamadaNota(idAluno, nomeAluno, matricula, tamanho, 3);
	}
	
	
	
	
	
	@Test
	public void testPanelNotaGetIdAluno() {
		Long idAluno = (long) 1;
		String nomeAluno = "Teste";
		String matricula = "3";
		int tamanho = 34;
		PanelAlunoChamadaNota panel = new PanelAlunoChamadaNota(idAluno, nomeAluno, matricula, tamanho, PanelAlunoChamadaNota.CHAMADA);
		Long idAlunoRecuperado = panel.geIdAluno();
		assertEquals(idAluno, idAlunoRecuperado);
	}
	

}
