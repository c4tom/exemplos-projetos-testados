<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Usuario</title>
</head>
<body>
	<div align="center">
		<form method="post" action="UsuarioServlet">
			<fieldset>
				<legend>Cadastro de Usuario</legend>
				<label>Nome:</label><input
					name="nome" autofocus="autofocus" placeholder="Nome"  value="${usuario.nome}"/><br />
				<label>Login:</label><input
					name="login" autofocus="autofocus" placeholder="Login"  value="${usuario.login}"/><br />
				<label>Senha:</label><input
					name="senha" autofocus="autofocus" placeholder="Senha"  value="${usuario.senha}"/><br />
				 <label>Telefone:</label><input
					type="tel" name="telefone" placeholder="9999-9999" value="${usuario.telefone}" /><br />
				 <label>Email:</label><input
					type="email" name="email" placeholder="rafaeldebusd@htomail.com"  value="${usuario.email}"/><br />	
				<label>Data Cadastro:</label><input type="date" name="dataCadastro" value="${usuario.dataCadastro}"
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