<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="es.ascender.biblioteca.negocio.Direccion" %>
<%@ page import="es.ascender.biblioteca.repositories.DireccionRepository" %>
<%@ page import="es.ascender.biblioteca.repositories.jdbc.DireccionRepositoryJDBC" %>


<% //ESTE JSP SIRVE PARA QUE EL JDBC.JAVA PUEDA LEERSE EN EL NAVEGADOR, COMO UN TRADUCTOR %>


<%

String calle= request.getParameter("calle");
String numero= request.getParameter("numero");

Direccion d=new Direccion(calle,numero);
DireccionRepository repo= new DireccionRepositoryJDBC();
repo.borrar(d);

response.sendRedirect("listadireccionjdbc.jsp");
%>

