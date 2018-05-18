<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Professores</title>
</head>
<body>
	<div align="center">
		<P>Lista de Professores</P>
		<table border="1">
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Telefone</td>
				<td>Data Cadastro</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="professor" items="${listaProfessor}">
				<tr>
					<td>${professor.matricula}</td>
					<td>${professor.nome}</td>
					<td>${professor.telefone}</td>
					<td><fmt:formatDate value="${professor.dataCadastro}" type="both" pattern="dd/MM/yyyy"/>  
					<td><a href="ProfessorServlet?acao=Excluir&matricula=${professor.matricula}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaProfessor) > 0}">
   		Existem ${fn:length(listaProfessor)} professores!
 		</c:if><br> 		
	</div>
	<a href="menu.jsp">Voltar</a>	
</body>
</html>