package br.com.feltex.academicnet.dao.jdbc;

import java.util.List;

import br.com.feltex.academicnet.entidade.Professor;

public interface ProfessorDAO {

	public abstract void alterar(Professor professor);

	public abstract Professor consultar(Professor professor);

	public abstract void excluir(Professor professor);

	public abstract boolean existe(Professor professor);

	public abstract void inserir(Professor professor);

	public abstract List<Professor> listar();

}