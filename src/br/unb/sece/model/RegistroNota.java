package br.unb.sece.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.unb.sece.model.DAO.ChamadaDAO;
import br.unb.sece.model.DAO.RegistroNotaDAO;

@Entity
public class RegistroNota {
	@Id
	@GeneratedValue
	private Long idRegistroNota;
	
	private double valor;
	
	private int bimestre;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idNota", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Nota nota;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idAlunoDisciplina", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private AlunoDisciplina alunoDisciplina;

	public Long getIdRegistroNota() {
		return idRegistroNota;
	}

	public void setIdRegistroNota(Long idRegistroNota) {
		this.idRegistroNota = idRegistroNota;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getBimestre() {
		return bimestre;
	}

	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public AlunoDisciplina getAlunoDisciplina() {
		return alunoDisciplina;
	}

	public void setAlunoDisciplina(AlunoDisciplina alunoDisciplina) {
		this.alunoDisciplina = alunoDisciplina;
	}
	
	public void salvar(){
		final RegistroNotaDAO dao = new RegistroNotaDAO();
		dao.save(this);
	}
	
	public void salvar(Session session){
		final RegistroNotaDAO dao = new RegistroNotaDAO();
		dao.save(this,session);
	}
	
	public static HashMap<Integer,Double> getNotas(Aluno aluno, Disciplina disciplina, Nota nota){
		HashMap<Integer,Double> notas = new HashMap<Integer,Double>();
		final RegistroNotaDAO dao = new RegistroNotaDAO();
		List<RegistroNota> registros = dao.getNotasPorAluno(aluno.getIdPessoa(), disciplina.getId(),nota.getIdNota());
		Iterator<RegistroNota> inRegistros = registros.iterator();
		while(inRegistros.hasNext()){
			RegistroNota obRegistroNota = inRegistros.next();
			notas.put(obRegistroNota.getBimestre(), obRegistroNota.getValor());
		}
		for(int i = notas.size()+1; i <= 4; i++){
			notas.put(i, 0.00);
		}
		return notas;
	}
	
	public static final int PRIMEIRO_BIMESTRE = 1;
	
	public static final int SEGUNDO_BIMESTRE = 2;
	
	public static final int TERCEIRO_BIMESTRE = 3;
	
	public static final int QUARTO_BIMESTRE = 4;

}
