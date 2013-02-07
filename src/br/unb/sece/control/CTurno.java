package br.unb.sece.control;

import br.unb.sece.exceptions.AtributoInvalidoException;
import br.unb.sece.exceptions.AtributoNuloException;
import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.Disciplina;
import br.unb.sece.model.Serie;
import br.unb.sece.model.Turno;
import br.unb.sece.view.panelcadastropadrao.VCadDisciplina;
import br.unb.sece.view.panelcadastropadrao.VCadSerie;
import br.unb.sece.view.panelcadastropadrao.VCadTurno;

public class CTurno extends CPadrao {
	
	private Turno turno;

	public CTurno() {
		super("br.unb.sece.model.Turno");
		// TODO Auto-generated constructor stub
		this.turno = new Turno();
		
	}
	
	@Override
	public void definirTitulosEMetodos() {
		// TODO Auto-generated method stub
		Object[] titulos = {"Inicio","Fim","Turno"};

		this.titulos = titulos;

		Object [] metodos = {"getInicio","getFim","getTurno"};

		this.metodos = metodos;

	}
	
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	@Override
	public void alterar(){
		Serie d = (Serie)this.objAlterar;
		d.alterar();
	}

	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		this.turno.salvar();
		this.turno = new Turno();

	}

	@Override
	public void excluir(Object obj) throws BancoDeDadosException {
		// TODO Auto-generated method stub
		Turno turno = (Turno)obj;
		turno.excluir();

	}
	
	@Override
	public void verificarDados() throws Exception{

		if(this.turno.getInicio()== 0 || this.turno.getFim()== 0){
			throw new AtributoInvalidoException("Horarios de Turnos Inválidos!");}
		
		if (this.turno.getInicio()>= this.turno.getFim()){
			throw new AtributoInvalidoException("Horarios de Turnos Inválidos!");
			
			
		}
		
	}
	
	public void receberDados(Object obj) throws Exception{
		VCadTurno panel = (VCadTurno)this.getPanelPadrao(obj);
		turno.setInicio(Integer.parseInt(String.valueOf(panel.getTxtInicio().getText())));
		turno.setFim(Integer.parseInt(String.valueOf(panel.getTxtFim().getText())));
		turno.setTurno(String.valueOf(panel.getCBTipo().getSelectedItem()));
		this.verificarDados();
		panel.getTxtInicio().setText("");
		panel.getTxtFim().setText("");
		
		


	}
	
	public void receberDados(Object obj,int operacao) throws Exception{
		VCadTurno panel = (VCadTurno)this.getPanelPadrao(obj);
		
		switch(operacao){
			case CPadrao.OPERACAO_INSERIR:
				turno.setInicio(Integer.parseInt(String.valueOf(panel.getTxtInicio().getText())));
				turno.setFim(Integer.parseInt(String.valueOf(panel.getTxtFim().getText())));
				turno.setTurno(String.valueOf(panel.getCBTipo().getSelectedItem()));
				this.verificarDados();
				panel.getTxtInicio().setText("");
				panel.getTxtFim().setText("");
				break;
	
			case CPadrao.OPERACAO_ALTERAR:
				Turno turno = (Turno)this.objAlterar;
				
				turno.setInicio(Integer.parseInt(String.valueOf(panel.getTxtInicio().getText())));
				turno.setFim(Integer.parseInt(String.valueOf(panel.getTxtFim().getText())));
				turno.setTurno(String.valueOf(panel.getCBTipo().getSelectedItem()));
				this.verificarDados();
				panel.getTxtInicio().setText("");
				panel.getTxtFim().setText("");
				
				break;
		}
		


	}
	
	public static String[] getTurnos(){
		
		return Turno.getTurnos();
		
		
	}
	
	public static int getIndiceTurno(String turno){
		return Turno.getIndiceTurno(turno);
	}
}
