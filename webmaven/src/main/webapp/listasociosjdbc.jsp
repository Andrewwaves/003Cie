<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.ascender.biblioteca.negocio.Socio"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<div class="container">

	<%
	
	List<Socio> lista=(List<Socio>)request.getAttribute("lista");

	%>
	<table class="table table-striped table-hover">
	<thead>
	<tr class="table-warning">
	<th><a href="?orden=dni">Dni</a></th>
	<th><a href="?orden=nombre">Nombre</a></th>
	<th><a href="?orden=apellidos">Apellidos</a></th>
	<th>Borrar</th>
	</tr>
	</thead>
	
	<% for (Socio s:lista) {%>
		<!--  esto es una fila -->
		<tr>
			<!--  esto es una columna o celda -->
			<td><%=s.getDni() %></td>
			<td><%=s.getNombre() %></td>
			<td><%=s.getApellidos() %></td>
			<td><a href="?comando=borrarsocio&dni=<%=s.getDni()%>" 
			class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">borrar</a></td>
			
		</tr>
		<%} %>
	</table>
	
	<!-- ancla, es un enlace a otra página -->
	<a href="?comando=formulariosocio">insertar nuevos socios</a>
	</div>
</body>
</html>