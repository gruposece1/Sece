package Model;

public class Turno {
	
	public static final String MANHA = "Manha";
	public static final String TARDE = "Tarde";
	
	private float inicio, fim;
	private String turno;
	
	public Turno()
	{
		
	}
	
	public Turno(float inicio, float fim, String turno) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.turno = turno;
	}

	public float getInicio() {
		return inicio;
	}
	public void setInicio(float inicio) {
		this.inicio = inicio;
	}
	public float getFim() {
		return fim;
	}
	public void setFim(float fim) {
		this.fim = fim;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
