package Model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.unb.sece.model.DAO.DisciplinaDAO;
import br.com.unb.sece.model.entities.Horario;
import br.com.unb.sece.util.HibernateUtil;

@Entity
public class Disciplina {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public List getAll(){
		
		ArrayList<Disciplina> disciplina = new ArrayList<Disciplina>();
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Matemática");
		disciplina.add(disciplina1);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Lingua Portuguesa");
		disciplina.add(disciplina2);
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setNome("História");
		disciplina.add(disciplina3);
		
		Disciplina disciplina4 = new Disciplina();
		disciplina4.setNome("Geografia");
		disciplina.add(disciplina1);
		
		DisciplinaDAO dao = new DisciplinaDAO();
		
		
		
		return dao.getAll() ;
	}
	
	public void salvar(){
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.save(this);
	}
	
	public void excluir(){
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.remove(this);
	}

	
}
