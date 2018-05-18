<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Turmas</title>
</head>
<body>
	<div align="center">
		<P>Lista de Turmas</P>
		<table border="1">
			<tr>
				<td>Nome</td>
				<td>Data Cadastro</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="turma" items="${listaTurma}">
				<tr>
					<td>${turma.nome}</td>
					<td><fmt:formatDate value="${turma.dataCadastro}" type="both" pattern="dd/MM/yyyy"/>  
					<td><a href="TurmaServlet?acao=Excluir&id=${turma.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaTurma) > 0}">
   		Existem ${fn:length(listaTurma)} turmas!
 		</c:if><br> 		
	</div>
	<a href="menu.jsp">Voltar</a>	
</body>
</html>