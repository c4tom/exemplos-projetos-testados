package br.com.feltex.academicnet.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.feltex.academicnet.dao.DAO;
import br.com.feltex.academicnet.entidade.Turma;


public class TurmaJDBCDAO extends DAO implements TurmaDAO 
{

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.TurmaDAO#alterar(br.com.feltex.academicnet.entidade.Turma)
	 */
	@Override
	public void alterar(Turma turma) {
		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao
					.prepareStatement("Update tbturma SET nome = ?, datacadastro = ?"
							+ " WHERE id = ? ");
			pstmt.setString(1, turma.getNome());
			pstmt.setDate(2, new java.sql.Date(turma.getDataCadastro().getTime()));
			pstmt.setLong(3, turma.getId());
			pstmt.execute();
			pstmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.TurmaDAO#excluir(br.com.feltex.academicnet.entidade.Turma)
	 */
	@Override
	public void excluir(Turma turma) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from	tbturma where id = ? ");
			pstm.setLong(1, turma.getId());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.TurmaDAO#existe(br.com.feltex.academicnet.entidade.Turma)
	 */
	@Override
	public boolean existe(Turma turma) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbturma where nome =	?");
			pstm.setString(1,turma.getNome());
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

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.TurmaDAO#inserir(br.com.feltex.academicnet.entidade.Turma)
	 */
	@Override
	public void inserir(Turma turma) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into tbturma (nome, datacadastro) values (?,?)");
			pstm.setString(1, turma.getNome());
			pstm.setDate(2, new java.sql.Date(turma.getDataCadastro()
					.getTime()));
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.TurmaDAO#listar()
	 */
	@Override
	public List<Turma> listar() {
		List<Turma> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from tbturma");
			while (rs.next()) {
				Turma turma = new Turma();
				turma.setId(rs.getInt("id"));
				turma.setNome(rs.getString("nome"));
				turma.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
				lista.add(turma);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.TurmaDAO#consultar(br.com.feltex.academicnet.entidade.Turma)
	 */
	@Override
	public Turma consultar(Turma turma) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbturma where id =	?");
			pstm.setLong(1, turma.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				turma.setId(rs.getInt("id"));
				turma.setNome(rs.getString("nome"));
				turma.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return turma;
	}

}

