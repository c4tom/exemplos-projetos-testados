package br.com.feltex.academicnet.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = -309513637403441997L;

	@Id
	@GeneratedValue
	private int id;

	private String nome;

	private Date dataCadastro;

	public Turma() {
	}

	public int getId() {
		return id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", nome=" + nome + ", dataCadastro="
				+ dataCadastro + "]";
	}

}
