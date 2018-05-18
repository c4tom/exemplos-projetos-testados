package br.com.feltex.academicnet.dao;

import java.util.List;

import br.com.feltex.academicnet.entidade.Usuario;

public interface UsuarioDAO {

	public abstract void alterar(Usuario usuario);

	public abstract void excluir(Usuario usuario);

	public abstract boolean existe(Usuario usuario);

	public abstract void inserir(Usuario usuario);

	public abstract List<Usuario> listar();

	public abstract Usuario consultar(Usuario usuario);

}