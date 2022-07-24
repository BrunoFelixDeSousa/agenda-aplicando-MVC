<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Contato</title>

<link rel="icon" href="img/fone.png">
<link rel="stylesheet" href="css/main.css">
</head>
<body>

	<div class="container">
		<h1 class="m-10">Editar Contato</h1>
		<form name="formularioContato" action="update">
			<table class="col-sm-7">
				<tr>
					<td><input type="text" name="idcon" class="form-control m-1" aria-label="Disabled input example" disabled value="<% out.print(request.getAttribute("idcon")); %>">
					</td>
				</tr>
				<tr>
					<td><input type="text" name="nome" class="form-control m-1" value="<% out.print(request.getAttribute("nome")); %>">
					</td>
				</tr>
				<tr>
					<td><input type="text" name="fone" class="form-control m-1" value="<% out.print(request.getAttribute("fone")); %>">
					</td>
				</tr>
				<tr>
					<td><input type="text" name="email" class="form-control m-1" value="<% out.print(request.getAttribute("email")); %>">
					</td>
				</tr>
			</table>
			
			<input class="btn btn-primary m-1" type="button" value="Salvar" onclick="validar()">
		</form>
	</div>


<script src="scripts/validador.js"></script>
</body>
</html>