package br.com.feltex.academicnet.entidade;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable 
{
	
	private static final long serialVersionUID = -309513637403441998L;

	private Long id;
	
	private String login;
	
	private String senha;

	private String nome;

	private String telefone;

	private String email;

	private Date dataCadastro;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha
				+ ", nome=" + nome + ", telefone=" + telefone + ", email="
				+ email + ", dataCadastro=" + dataCadastro + "]";
	}
	
}
