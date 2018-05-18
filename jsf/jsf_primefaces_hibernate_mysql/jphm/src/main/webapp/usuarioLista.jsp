<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>
	<div align="center">
		<P>Lista de Usuários</P>
		<table border="1">
			<tr>
				<td>Nome</td>
				<td>Login</td>
				<td>Telefone</td>
				<td>Data Cadastro</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="usuario" items="${listaUsuario}">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>${usuario.telefone}</td>
					<td><fmt:formatDate value="${usuario.dataCadastro}" type="both" pattern="dd/MM/yyyy"/>  
					<td><a href="UsuarioServlet?acao=Excluir&id=${usuario.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaUsuario) > 0}">
   		Existem ${fn:length(listaUsuario)} usuários!
 		</c:if><br> 		
	</div>
	<a href="menu.jsp">Voltar</a>	
</body>
</html>