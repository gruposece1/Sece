package br.unb.sece.model;


import br.unb.sece.exceptions.BancoDeDadosException;
import br.unb.sece.model.DAO.DisciplinaDAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;



@Entity
public class Disciplina {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	 

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public List getAll(){
		
		final ArrayList<Disciplina> disciplina = new ArrayList<Disciplina>();
		
		final Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Matemática");
		disciplina.add(disciplina1);
		
		final Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Lingua Portuguesa");
		disciplina.add(disciplina2);
		
		final Disciplina disciplina3 = new Disciplina();
		disciplina3.setNome("História");
		disciplina.add(disciplina3);
		
		final Disciplina disciplina4 = new Disciplina();
		disciplina4.setNome("Geografia");
		disciplina.add(disciplina1);
		
		final DisciplinaDAO dao = new DisciplinaDAO();
		
		return dao.getAll() ;
	}
		
	
	public void salvar() {
		final DisciplinaDAO dao = new DisciplinaDAO();
		dao.save(this);
	}
	
	public void excluir() throws BancoDeDadosException {
		final DisciplinaDAO dao = new DisciplinaDAO();
		dao.remove(this);
	}
	
	public void alterar() {
		final DisciplinaDAO dao = new DisciplinaDAO();
		dao.update(this);
	}
	
	public static Disciplina getDisciplina(Long id){
		
		final DisciplinaDAO dao = new DisciplinaDAO();
		return dao.findById(Disciplina.class, id);
	} 
	
	/**
	 * Converter List de Strings para List Disciplinas. 
	 * @param strings Lista com as Strings a serem convertidas, no formato: idDisciplina nomeDisciplina.
	 * @return Lista de Disciplinas
	 */
	public static List getString2Disciplina(List strings){
		
		ArrayList disciplinas = new ArrayList();
		
		for (int i = 0; i<strings.size(); i++){
			
			String obAtual = (String)strings.get(i);
			String[] obAtualPartido = obAtual.split(" ");
			
			Disciplina obDisciplina = Disciplina.getDisciplina(Long.valueOf(obAtualPartido[0]));
			
			if (obDisciplina != null){
				disciplinas.add(obDisciplina);	
				
			}
			
		}
		
		return disciplinas;
		
	}
	
	public static Disciplina getDisciplina(Horario obHorario){
		final DisciplinaDAO dao = new DisciplinaDAO();
		if(obHorario == null){
			throw new NullPointerException();
		}
		return dao.getDisciplina(obHorario.getIdHorario());
	}

}
