package br.unb.sece.view.util;


import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.unb.sece.model.Chamada;

public class PanelAlunoChamadaNota extends JPanel {
	
	private Long idAluno;
	
	private int valorChamada;
	
	private double valorNota;
	
	private JLabel lblMatNomeAluno;
	
	private int tipoPanel = PanelAlunoChamadaNota.CHAMADA;
	
	private JTextField textFieldAnotation;
	
	private JRadioButton radioPresente;
	
	private JRadioButton radioFalta;
	
	private JRadioButton radioAtrasado;
	
	public PanelAlunoChamadaNota(Long idAluno,String nomeAluno,String matricula, int tipoPanel) {
		super();
		this.idAluno = idAluno;
		this.setBounds(10, 34, 1103, 33);
		this.setLayout(null);
		this.lblMatNomeAluno = new JLabel(nomeAluno + "  "+matricula);
		this.lblMatNomeAluno.setBounds(10, 11, 272, 14);
		this.add(this.lblMatNomeAluno);
		this.tipoPanel = tipoPanel;
		switch(this.tipoPanel){
			case PanelAlunoChamadaNota.CHAMADA:
				this.constrututorChamada();
				break;
			case PanelAlunoChamadaNota.NOTA:
				this.construtorNota();
				break;
			default:
				this.constrututorChamada();
				break;
		}
	}
	
	private void constrututorChamada(){
		System.out.println("Aqui passou");
		ButtonGroup chamadaGroup = new ButtonGroup();
		
		this.radioPresente = new JRadioButton("");
		this.radioPresente.setBounds(267, 7, 21, 23);
		
		this.radioFalta = new JRadioButton("");
		this.radioFalta.setBounds(317, 7, 21, 23);
		
		this.radioAtrasado = new JRadioButton("");
		this.radioAtrasado.setBounds(366, 7, 21, 23);
		
		chamadaGroup.add(radioPresente);
		chamadaGroup.add(radioFalta);
		chamadaGroup.add(radioAtrasado);
		
		
		
		this.textFieldAnotation = new JTextField();
		this.textFieldAnotation.setBounds(427, 8, 666, 20);
		this.textFieldAnotation.setColumns(10);
		
		this.add(radioPresente);
		this.add(radioAtrasado);
		this.add(radioFalta);
		this.add(this.textFieldAnotation);
	}
	
	private void construtorNota(){
		
	}
	
	public Long geIdAluno(){
		return idAluno;
	}
	
	public int getValorChamada(){
		if(this.radioAtrasado.isSelected()){
			this.valorChamada = Chamada.ALUNO_ATRASADO;
		}
		if(this.radioFalta.isSelected()){
			this.valorChamada = Chamada.ALUNO_AUSENTE;
		}
		if(this.radioPresente.isSelected()){
			this.valorChamada = Chamada.ALUNO_PRESENTE;
		}
		return this.valorChamada;
	}

	public static final int CHAMADA = 1;
	
	public static final int NOTA = 2;
}
