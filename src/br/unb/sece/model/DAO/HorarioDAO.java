package br.unb.sece.model.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.unb.sece.model.Horario;
import br.unb.sece.model.Turma;


public class HorarioDAO extends Persistencia {

	public HorarioDAO(){
		super();
	}
	
	public HorarioDAO(Session session) {
		super(session);
	}

	

	@Override
	public Object findById(Class classe, Long pk) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Horario horarioAtualTurma(Class classe,Turma turma){
		
		Date d = new Date();
		
		String sql = "select "+ 
					  "h.*  "+
					"from "+
					 " turmadisciplina td "+
					  "inner join horario h "+
					  "on td.idTurmaDisciplina = h.idTurmaDisciplina "+
					"where "+
					 " td.idTurma = "+ turma.getIdTurma() + " " +
					  "and diaSemana = 1";
		//String sql = "select o from "  + classe.getSimpleName() + " o where diaSemana = 0 and idTurma = " + turma.getIdTurma();
		List horarios = this.objSession.createSQLQuery(sql).addEntity(classe).list();
		for(int i =0; i < horarios.size(); i++){
			Horario h = (Horario)horarios.get(i);
			if(d.getHours() >=   h.getHrInicial().getTime().getHours() && d.getMinutes() >= h.getHrInicial().getTime().getMinutes()){
				if(d.getHours() >=   h.getHrInicial().getTime().getHours() && d.getMinutes() >= h.getHrInicial().getTime().getMinutes()){
					
				}
			}
		}
		Horario h = (Horario)horarios.get(0);
		return h;
	}
	
	public List<Horario> listHorarioTurma(Class<Horario> classe, Turma turma) {
		return (List<Horario>) this.objSession.createQuery("select o from " + classe.getSimpleName() + " o where idturma = "+turma.getIdTurma()).list();
	}

	@Override
	public List<Object> listAll(Class classe) {
		// TODO Auto-generated method stub
		List<Object> lista = (List<Object>) this.objSession.createQuery("select o from " + classe.getSimpleName() + " o").list();
		//this.session.close();
		return lista;
	}
	
	public List<Horario> getHorariosTurmaSemRepeticaoDisciplina(Turma turma){
		String sql = "select * "+
					 "from horario where " +
					 "horario.idTurma = " + turma.getIdTurma()+ " " +
					 "group by   horario.idDisciplina ";
		System.out.println(sql);
		
		//List lista = this.objSession.createCriteria(Horario.class).setProjection(Projections.groupProperty("disciplina")).add(Restrictions.eq("turma", turma)).list();
		List lista = this.objSession.createSQLQuery(sql).addEntity(Horario.class).list();
		return lista;
	}

	
	public List<Horario> getHorariosTurmaDisciplina(Long idTurma, Long idDisciplina){
		String sql = 
						" select "+
						"  h.* "+
						" from "+
						"  horario h "+
						"  inner join turmadisciplina td "+
						"  on td.idTurmaDisciplina = h.idTurmaDisciplina "+
						" where "+
						"  td.idDisciplina =  "+ idDisciplina + " " +
						"  and td.idTurma = "+idTurma + " " ;
		return (List<Horario>)this.objSession.createSQLQuery(sql).addEntity(Horario.class).list();
	}

	

	

}
