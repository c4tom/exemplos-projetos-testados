<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Turma</title>
</head>
<body>
	<div align="center">
		<form method="post" action="TurmaServlet">
			<fieldset>
				<legend>Cadastro de Turma</legend>
				<label>Nome:</label><input
					name="nome" autofocus="autofocus" placeholder="Nome"  value="${turma.nome}"/><br />
				<label>Data Cadastro:</label><input type="date" name="dataCadastro" value="${turma.dataCadastro}"
					placeholder="10/10/2014" /><br /> <label>Ação</label> <select
					name="acao" required>
					<option selected value="Incluir">Incluir</option>
				</select><br /> <input type="submit" value="Enviar"> <input
					type="reset" value="Limpar"> <br />
			</fieldset>
		</form>
	</div>
</body>
</html>