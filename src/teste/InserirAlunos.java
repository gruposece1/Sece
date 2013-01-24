package teste;

import Model.Aluno;

public class InserirAlunos {

	/**
	 * @param args
	 */
	public static void insere(){
		
		// TODO Auto-generated method stub

		
		Aluno a = new Aluno();
		a.setDtNascimento("30/04/1992");
		a.setMatricula("11");
		a.setNome("Arthur");
		a.setSexo("M");
		a.salvar();
		Aluno b = new Aluno();
		b.setDtNascimento("30/04/1992");
		b.setMatricula("12");
		b.setNome("Eliana");
		b.setSexo("F");
		b.salvar();
		Aluno c = new Aluno();
		c.setDtNascimento("30/04/1992");
		c.setMatricula("13");
		c.setNome("Lucas");
		c.setSexo("M");
		c.salvar();
		Aluno d = new Aluno();
		d.setDtNascimento("30/04/1992");
		d.setMatricula("14");
		d.setNome("Dandara");
		d.setSexo("F");
		d.salvar();
		
		
	}

}
