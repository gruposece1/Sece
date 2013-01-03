package Model;

public class Serie {
	
	String nome;
	int qtdeHorarios, qtdeDias;
	
	public Serie()
	{
		
	}
	
	
	
	public Serie(String nome, int qtdeHorarios, int qtdeDias) {
		super();
		this.nome = nome;
		this.qtdeHorarios = qtdeHorarios;
		this.qtdeDias = qtdeDias;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdeHorarios() {
		return qtdeHorarios;
	}
	public void setQtdeHorarios(int qtdeHorarios) {
		this.qtdeHorarios = qtdeHorarios;
	}
	public int getQtdeDias() {
		return qtdeDias;
	}
	public void setQtdeDias(int qtdeDias) {
		this.qtdeDias = qtdeDias;
	}
	
	
	
	
	
	
	
	

}
