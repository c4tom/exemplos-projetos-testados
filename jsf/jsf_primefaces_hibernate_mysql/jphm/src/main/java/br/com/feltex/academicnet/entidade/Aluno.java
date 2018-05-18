package br.com.feltex.academicnet.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * Classe de entidade que possui os atributos do aluno
 * 
 */
@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = -309513637403441918L;

	@Id
	@GeneratedValue
	private Long matricula;

	private String nome;

	private String telefone;

	private String email;

	private Date dataCadastro;

	public Aluno() {
	}

	public Aluno(Long matricula) {
		super();
		this.matricula = matricula;
	}

	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public Long getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome
				+ ", telefone=" + telefone + ", email=" + email
				+ ", dataCadastro=" + dataCadastro + "]";
	}
}