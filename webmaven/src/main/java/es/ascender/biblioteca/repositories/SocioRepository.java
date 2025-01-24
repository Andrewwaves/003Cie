package es.ascender.biblioteca.repositories;

import java.util.List;

import es.ascender.biblioteca.negocio.Socio;

public interface SocioRepository {

	List<Socio> buscarTodos();
	
	void insertar (Socio socio);
	void borrar (Socio socio);
	List<Socio> buscarTodosOrdenados(String orden);
}
