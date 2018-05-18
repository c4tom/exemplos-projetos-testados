package br.com.feltex.academicnet.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.feltex.academicnet.dao.DAOFactory;
import br.com.feltex.academicnet.dao.UsuarioDAO;
import br.com.feltex.academicnet.entidade.Usuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "sucessoUsuario.jsp";
		String mensagem = "";
		List<Usuario> lista = new ArrayList<>();

		Usuario usuario = new Usuario();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		
		try {

			//Se a aÃ§Ã£o for DIFERENTE de Listar sÃ£o lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				usuario.setNome(request.getParameter("nome"));
				usuario.setLogin(request.getParameter("login"));
				usuario.setTelefone(request.getParameter("telefone"));
				usuario.setEmail(request.getParameter("email"));
				usuario.setSenha(request.getParameter("senha"));
				
				//Faz a leitura da data de cadastro. Caso ocorra um erro de formataÃ§Ã£o
				// o sistema utilizarÃ¡ a data atual
				try {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");					
					usuario.setDataCadastro(df.parse(request.getParameter("dataCadastro")));
				} catch (Exception e) {
					usuario.setDataCadastro(new Date());	
				}
				
			}

			if (acao.equalsIgnoreCase("Incluir")) {
				// Verifica se a matrÃ­cula informada jÃ¡ existe no Banco de Dados
				// Se existir enviar uma mensagem senÃ£o faz a inclusÃ£o
				if (dao.existe(usuario)) {
					mensagem = "Usuário informado já existe!";
				} else {
					dao.inserir(usuario);
				}
			} else if (acao.equalsIgnoreCase("Alterar")) 
			{
				usuario.setId(Long.parseLong(request.getParameter("id")));
				dao.alterar(usuario);
			} else if (acao.equalsIgnoreCase("Excluir")) {
				usuario.setId(Long.parseLong(request.getParameter("id")));
				dao.excluir(usuario);
			} else if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("usuario", usuario);
				usuario = dao.consultar(usuario);
				destino = "usuario.jsp";
			}
		} catch (Exception e) {
			mensagem += e.getMessage();
			destino = "erro.jsp";
			e.printStackTrace();
		}
		
		// Se a mensagem estiver vazia significa que houve sucesso!
		// SenÃ£o serÃ¡ exibida a tela de erro do sistema.
		if (mensagem.length() == 0) {
			mensagem = "Usuário Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}

		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		request.setAttribute("listaUsuario", lista);
		request.setAttribute("mensagem", mensagem);
		

		//O sistema Ã© direcionado para a pÃ¡gina 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
}
