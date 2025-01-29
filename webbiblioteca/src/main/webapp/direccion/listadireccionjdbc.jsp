<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="es.ascender.biblioteca.negocio.Direccion"%>
<%@ page
	import="es.ascender.biblioteca.repositories.DireccionRepository"%>
<%@ page
	import="es.ascender.biblioteca.repositories.jdbc.DireccionRepositoryJDBC"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
DireccionRepository repo= new DireccionRepositoryJDBC();
List<Direccion> lista=repo.buscarTodos();

if(request.getParameter("orden")!=null){
	out.println("Jerarquía a base de "+request.getParameter("orden"));
	lista=repo.buscarTodosOrdenados(request.getParameter("orden"));
}else {
	out.println("No Jerarquía");
	lista=repo.buscarTodos();
}

%>

	<table>
	<thead>
	<tr>
	<th><a href="?orden=dni">Dni</a></th>
	<th><a href="?orden=nombre">Calle</a></th>
	<th><a href="?orden=apellidos">Numero</a></th>
	<th><a href="?orden=codigopostal">Codigo postal</a></th>
	<th>Borrar</th>
	</tr>
	</thead>
	
		<% for(Direccion d:lista) {%>
		<!--  esto es una fila -->
		<tr>
			<!--  esto es una columna o celda -->
			<td><%=d.getDni() %></td>
			<td><%=d.getCalle() %></td>
			<td><%=d.getNumero() %></td>
			<td><%=d.getCodigopostal() %></td>
			<td><a href="borrardireccionjdbc.jsp?calle=<%=d.getCalle()%>&numero=<%=d.getNumero()%>">borrar</a></td>
			
		</tr>
		<%} %>
	</table>
	<a href="formulariodireccion.html">insertar nueva direccion</a>

</body>
</html>