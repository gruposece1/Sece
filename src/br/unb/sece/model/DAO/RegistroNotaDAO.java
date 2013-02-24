package br.unb.sece.model.DAO;

import java.util.List;

import br.unb.sece.model.RegistroNota;

public class RegistroNotaDAO extends Persistencia{


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
	
	public List<RegistroNota> getNotasPorAluno(Long idAluno, Long idDisciplina, Long idNota){
		String sql =
				
					"select "+
					"  rn.* "+
					"from  "+
					"  registronota rn "+
					"  inner join alunodisciplina ad "+
					"  on rn.idAlunoDisciplina = ad.idAlunoDisciplina "+
					"  inner join turmadisciplina td "+
					"  on ad.idTurmaDisciplina = td.idTurmaDisciplina "+
					" where  "+
					"  a.idPessoa = "+  idAluno + " " +
					"  and td.idDisciplina = "+ idDisciplina + 
					"  and rn.idNota = "+ idNota ;
		return (List<RegistroNota>)this.objSession.createSQLQuery(sql).list();
	}
	

}
