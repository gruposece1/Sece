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
	
	
	public List<Chamada> getChamada(Long idTurma, Long idDisciplina,Long idAluno, Calendar data, int condicaoAluno){
		String sql =
					"select "+
					"  c.* "+
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
					" and ad.idAluno =  "+ idAluno + " "+
					" and convert(c.data,date) = " + this.calendar2StringBusca(data) + " " + 
					"  and c.verificacaoAluno = "+ condicaoAluno + " ";
		return (List<Chamada>)this.objSession.createSQLQuery(sql).addEntity(Chamada.class).list();
	}
	
	public List<Aluno> getAlunosVerificacaoChamada(Long idTurma, Long idDisciplina, Calendar data, int condicaoAluno){
		
		
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
						"  and c.verificacaoAluno = "+ condicaoAluno + " "+
						"  and convert(c.data,date) = " + this.calendar2StringBusca(data) + " "+
						"  group by  "+
						"  p.idPessoa";
		
		return (List<Aluno>)this.objSession.createSQLQuery(sql).addEntity(Aluno.class).list();
	}
	
	private String calendar2StringBusca(Calendar data){
		String dataBusca = "str_to_date('"+data.get(Calendar.DAY_OF_MONTH);
		if(data.get(Calendar.MONTH) < 10){
			//dataBusca += "0"+data.get(Calendar.MONTH);
			dataBusca += "02";
			System.out.println("O mes: " + data.get(Calendar.MONTH));
		}
		dataBusca += data.get(Calendar.YEAR)+ "','%d%m%Y')";
		System.out.println("ChamadaDao: " +dataBusca);
		return dataBusca;
	}
	
}
