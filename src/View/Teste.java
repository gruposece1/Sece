package View;

public class Teste {
	
	private String nome, local;
	
	public Teste(String nome, String local)
	{
		this.nome = nome;
		this.local = local;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public String toString()
	{
		return nome;
	}
	

}
