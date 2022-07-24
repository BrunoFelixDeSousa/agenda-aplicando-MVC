<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="model.Contato"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<Contato> lista = (ArrayList<Contato>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>

<link rel="icon" href="img/fone.png">
<link rel="stylesheet" href="css/main.css">
</head>
<body>

	<div class="container">
		<h1>Agenda de Contatos</h1>
		<a class="btn btn-primary" href="novo.html">Novo Contato</a>
	</div>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td>
					<a href="select?idcon=<%=lista.get(i).getIdcon()%>"
					class="btn btn-primary">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)"
					class="btn btn-primary">Excluir</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>