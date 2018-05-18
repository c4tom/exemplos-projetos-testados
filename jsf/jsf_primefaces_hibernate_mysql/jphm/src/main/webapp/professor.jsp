<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Professor</title>
</head>
<body>
	<div align="center">
		<form method="post" action="ProfessorServlet">
			<fieldset>
				<legend>Cadastro de Professores</legend>
				<label>Matrícula: </label><input name="matricula" required
				    value="${professor.matricula}"
					placeholder="2236541" /><br /> 
				<label>Name:</label><input
					name="nome" autofocus="autofocus" placeholder="Nome"  value="${professor.nome}"/><br />
					
				 <label>Telefone:</label><input
					type="tel" name="telefone" placeholder="9999-9999" value="${professor.telefone}" /><br />
				 <label>Email:</label><input
					type="email" name="email" placeholder="rafaeldebusd@htomail.com"  value="${professor.email}"/><br />	
				<label>Data Cadastro:</label><input type="date" name="dataCadastro" value="${professor.dataCadastro}"
					placeholder="10/10/2014" /><br /> <label>Ação</label> <select
					name="acao" required>
					<option selected value="Incluir">Incluir</option>
					<option value="Alterar">Alterar</option>
					<option value="Excluir">Excluir</option>
					<option value="Consultar">Consultar</option>
				</select><br /> <input type="submit" value="Enviar"> <input
					type="reset" value="Limpar"> <br />
			</fieldset>
		</form>
	</div>
</body>
</html>