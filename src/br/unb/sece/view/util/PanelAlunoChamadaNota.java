package br.unb.sece.view.util;


import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.unb.sece.model.Chamada;
import br.unb.sece.model.RegistroNota;

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
	
	private JTextField txtNota01;
	
	private JTextField txtNota02;
	
	private JTextField txtNota03;
	
	private JTextField txtNota04;
	
	private int bimestre;
	
	private HashMap<Integer,Double> notas;
	
	public PanelAlunoChamadaNota(Long idAluno,String nomeAluno,String matricula,int tamanho, int tipoPanel) {
		
		
		this.construtorPadrao(idAluno, nomeAluno, matricula, tamanho, tipoPanel);
		
	}
	
	public PanelAlunoChamadaNota(Long idAluno,String nomeAluno,String matricula,int tamanho, int tipoPanel, int bimestre, HashMap<Integer, Double> notas)
	{
		this.bimestre = bimestre;
		
		this.notas = notas;
		
		this.construtorPadrao(idAluno, nomeAluno, matricula, tamanho, tipoPanel);
		
		
	}
	
	private void construtorPadrao(Long idAluno,String nomeAluno,String matricula,int tamanho, int tipoPanel){
		
		this.idAluno = idAluno;
		this.setBounds(10, tamanho, 1103, 33);
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
		
		this.radioPresente.setName("Presente");
		this.radioFalta.setName("Falta");
		this.radioAtrasado.setName("Atrasado");
		
		this.textFieldAnotation = new JTextField();
		this.textFieldAnotation.setBounds(427, 8, 666, 20);
		this.textFieldAnotation.setColumns(10);
		
		this.add(radioPresente);
		this.add(radioAtrasado);
		this.add(radioFalta);
		this.add(this.textFieldAnotation);
		
		this.textFieldAnotation.setName("obsAluno");
	}
	
	private void construtorNota(){
		
		this.txtNota01 = new JTextField();
		this.txtNota01.setBounds(247, 7, 42, 23);
		
		this.txtNota02 = new JTextField();
		this.txtNota02.setBounds(302, 7, 42, 23);
		
		this.txtNota03 = new JTextField();
		this.txtNota03.setBounds(355, 7, 42, 23);
		
		this.txtNota04 = new JTextField();
		this.txtNota04.setBounds(407, 8, 42, 23);
		
		//System.out.println(this.bimestre);
		
		this.add(txtNota01);
		this.add(txtNota02);
		this.add(txtNota03);
		this.add(txtNota04);
		
		this.preencherNotas();
		
		this.validarCamposNota();
		
	}
	
	private void preencherNotas(){
		
		
		for(int i = 1; i <= this.notas.size();i++){
		
			Double nota = this.notas.get(i);
			switch(i){
				case 1:
					this.txtNota01.setText(String.valueOf(nota));
					break;
				case 2:
					this.txtNota02.setText(String.valueOf(nota));
					break;
				case 3:
					this.txtNota03.setText(String.valueOf(nota));
					break;
				case 4:
					this.txtNota04.setText(String.valueOf(nota));
					break;
			}
		}
	}
	
	private void validarCamposNota()
	{
		if(bimestre==1){
			
			this.txtNota02.setEnabled(false);
			this.txtNota03.setEnabled(false);
			this.txtNota04.setEnabled(false);
		}
		else if(bimestre == 2){
			
			this.txtNota01.setEnabled(false);
			this.txtNota03.setEnabled(false);
			this.txtNota04.setEnabled(false);
		}
		else if(bimestre == 3)
		{
			this.txtNota01.setEnabled(false);
			this.txtNota02.setEnabled(false);
			this.txtNota04.setEnabled(false);
		}
		else
		{
			this.txtNota01.setEnabled(false);
			this.txtNota02.setEnabled(false);
			this.txtNota03.setEnabled(false);
		}
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
	
	public String getObsAluno(){
		return this.textFieldAnotation.getText();
	}
	
	public HashMap<Integer, Double> getNotas()
	{
		HashMap<Integer, Double> notas = new HashMap<Integer, Double>() ;
		
		notas.put(RegistroNota.PRIMEIRO_BIMESTRE, Double.parseDouble(this.txtNota01.getText()));
		
		notas.put(RegistroNota.SEGUNDO_BIMESTRE, Double.parseDouble(this.txtNota02.getText()));
		
		notas.put(RegistroNota.TERCEIRO_BIMESTRE, Double.parseDouble(this.txtNota03.getText()));
		
		notas.put(RegistroNota.QUARTO_BIMESTRE, Double.parseDouble(this.txtNota04.getText()));
		
		return notas;
		
		
	}

	public static final int CHAMADA = 1;
	
	public static final int NOTA = 2;
}
