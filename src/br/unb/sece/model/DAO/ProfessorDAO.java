package br.unb.sece.model.DAO;

import java.util.List;

import org.hibernate.Session;

import br.unb.sece.model.Professor;

public class ProfessorDAO extends Persistencia {

	public ProfessorDAO(){
		super();
	}
	public ProfessorDAO(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public Object findById(Class classe, Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> listAll(Class classe) {
		// TODO Auto-generated method stub
		List<Object> lista = (List<Object>) this.objSession.createQuery("select o from " + classe.getSimpleName() + " o").list();
		//this.session.close();
		return lista;
	}
	
	public List getProfessoresDisponiveis(int diaDaSemana, Long disciplina, String hrInicial, String hrFinal){
		String sql =
			"select p.idPessoa,pe.nome,pe.sexo,pe.cpf, f.senha, f.telefone, f.tipoFuncionario from   professor p,   professordisciplina pd,funcionario f, pessoa pe where " +
			"  p.idPessoa = pd.idProfessor and "+
			"  p.idPessoa = f.idPessoa and "+
			"  f.idPessoa = pe.idPessoa and "+
			
					"pd.idDisciplina = " + disciplina + " and " +
					"p.idPessoa not in( "+ 
						"select idProfessor from  horario h inner join turmadisciplina td on h.idTurmaDisciplina = td.idTurmaDisciplina   where "+
						"(CONVERT(h.hrInicial,TIME)  between CONVERT('" + hrInicial + " ',TIME) and CONVERT('"+hrFinal+"',TIME) or "+
						"CONVERT(h.hrFinal,TIME) between CONVERT('" + hrInicial +" ',TIME) and CONVERT('"+hrFinal+"',TIME)) "+
					    "and diaSemana = " + diaDaSemana + 
					    " and td.idDisciplina = " + disciplina +
					    ")" ;
		System.out.println(sql);
		List retorno = this.objSession.createSQLQuery(sql).addEntity(Professor.class).list();
		return retorno;	
	} 

}
