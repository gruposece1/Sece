package br.unb.sece.control;
import br.unb.sece.model.Serie;

public class CSerie extends CPadrao {
	private Serie obSerie;
	
	public CSerie() {
		super("br.unb.sece.model.Serie");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void definirTitulosEMetodos() {
		// TODO Auto-generated method stub
		Object[] titulos = {"Nome","Qtde Horários","Qtde Dias"};

		this.titulos = titulos;

		Object [] metodos = {"getNome","getQtdeHorarios","getQtdeDias"};

		this.metodos = metodos;

	}


}
