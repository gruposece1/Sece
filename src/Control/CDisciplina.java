package Control;

import javax.swing.JPanel;

import exceptions.AtributoNuloException;

import Model.Disciplina;
import View.VDisciplina;
import View.PanelCadastroPadrao.VCadDisciplina;

public class CDisciplina extends CPadrao {
	
	private Disciplina disciplina;

	public CDisciplina() {
		super("Model.Disciplina");
		// TODO Auto-generated constructor stub
		this.disciplina = new Disciplina();
	}

	@Override
	public void definirTitulosEMetodos() {
		// TODO Auto-generated method stub
		Object[] titulos = {"Nome"};
		
		this.titulos = titulos;
		
		Object [] metodos = {"getNome"};
		
		this.metodos = metodos;
		
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		this.disciplina.salvar();
		
	}
	
	@Override
	public void excluir(Object obj) {
		// TODO Auto-generated method stub
		Disciplina d = (Disciplina)obj;
		d.excluir();
		
	}
	
	@Override
	public void verificarDados() throws Exception{
		
		if(this.disciplina.getNome().equals("")){
			System.out.println("Teste");
			throw new AtributoNuloException();
		}
	}
	
	public void receberDados(Object obj) throws Exception{
		VCadDisciplina panel = (VCadDisciplina)this.getPanelPadrao(obj);
		disciplina.setNome(panel.getTextField().getText());
		this.verificarDados();
		panel.getTextField().setText("");
		
		
	}

}
