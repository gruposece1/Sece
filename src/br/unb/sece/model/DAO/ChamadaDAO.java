package br.unb.sece.model.DAO;

import java.util.Calendar;
import java.util.List;

import br.unb.sece.model.Aluno;
import br.unb.sece.model.Chamada;

public class ChamadaDAO extends Persistencia {

	public ChamadaDAO() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public Object findById(Class classe, Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> listAll(Class classe) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Chamada getChamada(Long idTurma, Long idDisciplina,Long idAluno, Calendar data){
		String sql =
					"select "+
					"  c.*, "+
					" from "+
					"  pessoa p "+ 
					"  inner join aluno a "+
					"  on p.idPessoa = a.idPessoa "+
					"  inner join alunodisciplina ad "+ 
					"  on ad.idAluno = a.idPessoa "+
					"  inner join turmadisciplina td "+
					"  on ad.idTurmaDisciplina = td.idTurmaDisciplina "+
					"  inner join chamada c "+
					"  on c.idAlunoDisciplina = ad.idAlunoDisciplina "+
					" where "+
					"  td.idTurma = "+ idTurma + " "+
					"  and td.idDisciplina = "+ idDisciplina + " "+
					" and ad.idAluno =  "+ idAluno;
		return (Chamada)this.objSession.createSQLQuery(sql).addEntity(Chamada.class).uniqueResult();
	}
	
	public List<Aluno> getAlunosVerificacaoChamada(Long idTurma, Long idDisciplina, Calendar data, int condicaoAluno){
		System.out.println( "o dia" + data.get(Calendar.DAY_OF_MONTH)); 
		System.out.println("o mes:"+data.get(Calendar.MONTH));
		System.out.println("o ano"+data.get(Calendar.YEAR));
		
		if(idTurma == null || idDisciplina == null || data == null){
			throw new NullPointerException();
		}
		String sql =
						"select "+
						"  p.*, "+
						"  a.* "+
						" from "+
						"  pessoa p "+ 
						"  inner join aluno a "+
						"  on p.idPessoa = a.idPessoa "+
						"  inner join alunodisciplina ad "+ 
						"  on ad.idAluno = a.idPessoa "+
						"  inner join turmadisciplina td "+
						"  on ad.idTurmaDisciplina = td.idTurmaDisciplina "+
						"  inner join chamada c "+
						"  on c.idAlunoDisciplina = ad.idAlunoDisciplina "+
						" where "+
						"  td.idTurma = "+ idTurma + " "+
						"  and td.idDisciplina = "+ idDisciplina + " "+
						"  and c.verificacaoAluno = "+ condicaoAluno;
		
		return (List<Aluno>)this.objSession.createSQLQuery(sql).addEntity(Aluno.class).list();
	}
	
}
