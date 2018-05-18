package br.com.feltex.academicnet.dao.jdbc;

import java.util.List;

import br.com.feltex.academicnet.entidade.Aluno;

public interface AlunoDAO {

	public abstract void alterar(Aluno aluno);

	public abstract void excluir(Aluno aluno);

	public abstract boolean existe(Aluno aluno);

	public abstract void inserir(Aluno aluno);

	public abstract List<Aluno> listar();

	public abstract Aluno consultar(Aluno aluno);

}