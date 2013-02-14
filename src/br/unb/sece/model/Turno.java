package br.unb.sece.model;

import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.TurnoDAO;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turno {
	
	public static final String MANHA = "Manha";
	public static final String TARDE = "Tarde";
	
	@Id
	@GeneratedValue
	private Long id;
	
	private float inicio;
	private float fim;
	private String turno;
	
	public Turno() {
		
	}
	
	public Turno(float inicio, float fim, String turno) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.turno = turno;
	}

	public float getInicio() {
		return this.inicio;
	}
	
	public void setInicio(float inicio) {
		this.inicio = inicio;
	}
	
	public float getFim() {
		return this.fim;
	}
	
	public void setFim(float fim) {
		this.fim = fim;
	}
	
	public String getTurno() {
		return this.turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List getAll(){
		final TurnoDAO dao = new TurnoDAO();
		
		return dao.listAll(Turno.class);

	}
	
	public void salvar() {
		final TurnoDAO dao = new TurnoDAO();

		dao.save(this);
	}
	
	public void excluir() throws BancoDeDadosException {
		final TurnoDAO dao = new TurnoDAO();
		
		dao.remove(this);
	}
	
	public void alterar(){
		final TurnoDAO dao = new TurnoDAO();
		
		dao.update(this);
	}
	
	public static String[] getTurnos() {
		final String[] tipo = {"Matutino", "Vespertino", "Noturno"};
		
		return tipo;
	}
	
	public static int getIndiceTurno(String turno) {
		int retorno = 0;
		final String[] turnos = Turno.getTurnos();
		
		for (int i = 0; i <turnos.length; i++) {
			if (turnos[i].equals(turno)) {
				retorno=i;
				break;
			}
		}
		
		return retorno;
	}

}
	

