package br.com.feltex.academicnet.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.feltex.academicnet.dao.DAO;
import br.com.feltex.academicnet.entidade.Professor;

/**
 * 
 * Classe de Persistência de dados dos objetos de Professor
 * é "filha" da Classe DAO. 
 *
 */

public class ProfessorJDBCDAO extends DAO implements ProfessorDAO  {

	public void alterar(Professor professor) {
		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao
					.prepareStatement("Update tbprofessor SET nome = ?, telefone = ?, email = ?, datacadastro = ?"
							+ " WHERE matricula = ? ");
			pstmt.setString(1, professor.getNome());
			pstmt.setString(2, professor.getTelefone());
			pstmt.setString(3, professor.getEmail());
			pstmt.setDate(4, new java.sql.Date(professor.getDataCadastro().getTime()));
			pstmt.setLong(5, professor.getMatricula());
			pstmt.execute();
			pstmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Professor consultar(Professor professor) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbprofessor where matricula =	?");
			pstm.setLong(1, professor.getMatricula());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				professor.setMatricula(rs.getLong("matricula"));
				professor.setNome(rs.getString("nome"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setEmail(rs.getString("email"));
				professor.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professor;
	}

	public void excluir(Professor professor) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from	tbprofessor where matricula = ? ");
			pstm.setLong(1, professor.getMatricula());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existe(Professor professor) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbprofessor where matricula =	?");
			pstm.setLong(1, professor.getMatricula());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
	}

	public void inserir(Professor professor) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	tbprofessor (matricula, nome, telefone, email, datacadastro) values	(?,?,?,?,?)");
			pstm.setLong(1, professor.getMatricula());
			pstm.setString(2, professor.getNome());
			pstm.setString(3, professor.getTelefone());
			pstm.setString(4, professor.getEmail());
			pstm.setDate(5, new java.sql.Date(professor.getDataCadastro()
					.getTime()));
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Professor> listar() {
		List<Professor> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from tbprofessor");
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setMatricula(rs.getLong("matricula"));
				professor.setNome(rs.getString("nome"));
				professor.setTelefone(rs.getString("telefone"));
				professor.setEmail(rs.getString("email"));
				professor.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
				lista.add(professor);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}