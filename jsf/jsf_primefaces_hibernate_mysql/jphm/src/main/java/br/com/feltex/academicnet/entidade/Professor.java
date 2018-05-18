package br.com.feltex.academicnet.entidade;

import java.io.Serializable;
import java.util.Date;

public class Professor implements Serializable 
{
	
	private static final long serialVersionUID = -309513637403441999L;

	private Long matricula;

	private String nome;

	private String telefone;

	private String email;

	private Date dataCadastro;
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Professor [matricula=" + matricula + ", nome=" + nome
				+ ", telefone=" + telefone + ", email=" + email
				+ ", dataCadastro=" + dataCadastro + "]";
	}
	
}
