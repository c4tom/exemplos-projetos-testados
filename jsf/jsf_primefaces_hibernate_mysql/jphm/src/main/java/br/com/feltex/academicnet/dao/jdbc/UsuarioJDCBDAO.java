package br.com.feltex.academicnet.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.feltex.academicnet.dao.DAO;
import br.com.feltex.academicnet.dao.UsuarioDAO;
import br.com.feltex.academicnet.entidade.Usuario;

public class UsuarioJDCBDAO extends DAO implements UsuarioDAO 
{

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.UsuarioDAO#alterar(br.com.feltex.academicnet.entidade.Usuario)
	 */
	@Override
	public void alterar(Usuario usuario) {
		try {
			Connection conexao = getConexao();

			PreparedStatement pstmt = conexao
					.prepareStatement("Update tbusuario SET nome = ?, telefone = ?, email = ?, datacadastro = ?"
							+ " WHERE id = ? ");
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getTelefone());
			pstmt.setString(3, usuario.getEmail());
			pstmt.setDate(4, new java.sql.Date(usuario.getDataCadastro().getTime()));
			pstmt.setLong(5, usuario.getId());
			pstmt.execute();
			pstmt.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.UsuarioDAO#excluir(br.com.feltex.academicnet.entidade.Usuario)
	 */
	@Override
	public void excluir(Usuario usuario) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from	tbusuario where id = ? ");
			pstm.setLong(1, usuario.getId());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.UsuarioDAO#existe(br.com.feltex.academicnet.entidade.Usuario)
	 */
	@Override
	public boolean existe(Usuario usuario) {
		boolean achou = false;
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbusuario where login =	?");
			pstm.setString(1,usuario.getLogin());
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
	 * @see br.com.feltex.academicnet.dao.jdbc.UsuarioDAO#inserir(br.com.feltex.academicnet.entidade.Usuario)
	 */
	@Override
	public void inserir(Usuario usuario) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Insert into tbusuario (nome, login, senha, telefone, email, datacadastro) values (?,?,?,?,?,?)");
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getTelefone());
			pstm.setString(5, usuario.getEmail());
			pstm.setDate(6, new java.sql.Date(usuario.getDataCadastro()
					.getTime()));
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.UsuarioDAO#listar()
	 */
	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from tbusuario");
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
				lista.add(usuario);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	/* (non-Javadoc)
	 * @see br.com.feltex.academicnet.dao.jdbc.UsuarioDAO#consultar(br.com.feltex.academicnet.entidade.Usuario)
	 */
	@Override
	public Usuario consultar(Usuario usuario) {
		try {
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao
					.prepareStatement("Select * from tbusuario where id =	?");
			pstm.setLong(1, usuario.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDataCadastro(new java.util.Date(rs.getDate("datacadastro").getTime()));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
