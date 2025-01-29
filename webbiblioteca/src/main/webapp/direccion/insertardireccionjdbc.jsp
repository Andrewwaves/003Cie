<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="es.ascender.biblioteca.negocio.Direccion" %>
<%@ page import="es.ascender.biblioteca.repositories.DireccionRepository" %>
<%@ page import="es.ascender.biblioteca.repositories.jdbc.DireccionRepositoryJDBC" %>


<% //ESTE JSP SIRVE PARA QUE EL JDBC.JAVA PUEDA LEERSE EN EL NAVEGADOR, COMO UN TRADUCTOR %>


<%

String dni= request.getParameter("dni");
String calle= request.getParameter("calle");
String numero= request.getParameter("numero");
String codigopostal= request.getParameter("codigopostal");

Direccion d= new Direccion(dni,calle,numero,codigopostal);
DireccionRepository repo= new DireccionRepositoryJDBC();
repo.insertar(d);

response.sendRedirect("listadireccionjdbc.jsp");
%>

