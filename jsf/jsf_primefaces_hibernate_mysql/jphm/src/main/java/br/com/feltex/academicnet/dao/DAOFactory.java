package br.com.feltex.academicnet.dao;

import br.com.feltex.academicnet.dao.hibernate.AlunoHibernateDAO;
import br.com.feltex.academicnet.dao.jdbc.ProfessorDAO;
import br.com.feltex.academicnet.dao.jdbc.ProfessorJDBCDAO;
import br.com.feltex.academicnet.dao.jdbc.TurmaDAO;
import br.com.feltex.academicnet.dao.jdbc.TurmaJDBCDAO;
import br.com.feltex.academicnet.dao.jdbc.UsuarioJDCBDAO;

public class DAOFactory {

	public static AlunoDAO getAlunoDAO() {
		return new AlunoHibernateDAO();
	}

	public static ProfessorDAO getProfessorDAO() {
		return new ProfessorJDBCDAO();
	}

	public static TurmaDAO getTurmaDAO() {
		return new TurmaJDBCDAO();
	}

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioJDCBDAO();
	}
}