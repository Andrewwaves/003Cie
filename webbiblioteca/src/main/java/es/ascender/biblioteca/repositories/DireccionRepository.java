package es.ascender.biblioteca.repositories;

import java.util.List;

import es.ascender.biblioteca.negocio.Direccion;
import es.ascender.biblioteca.negocio.Socio;

public interface DireccionRepository {
	
	List <Direccion> buscarTodos();
	void insertar (Direccion direccion);
	void borrar (Direccion direccion);
	List<Direccion> buscarTodosOrdenados(String orden);

}
