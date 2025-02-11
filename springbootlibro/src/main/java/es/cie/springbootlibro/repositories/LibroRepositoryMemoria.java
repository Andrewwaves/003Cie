package es.cie.springbootlibro.repositories;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.cie.springbootlibro.negocio.Libro;

@Repository
public class LibroRepositoryMemoria {

     List<Libro> libros = new ArrayList<Libro>();

    public LibroRepositoryMemoria() {

        libros.add(new Libro("1", "hola", "tu"));
        libros.add(new Libro("2", "el", "pati"));
        libros.add(new Libro("3", "90", "tusabequien"));

    }

    public List<Libro> buscarTodos(){
        return libros;
    }


    public void insertarlibro( Libro libro) {
        libros.add(libro);
    }

    public Optional<Libro> buscarUno (String isbn){
        return libros.stream().filter((l)->l.getIsbn().equals(isbn)).findFirst();

    }

    public void borrarLibro (String isbn) {
        Libro l=new Libro(isbn);
        libros.remove(l);

    }

     public List<Libro> buscarTodosOrdenados(String orden){

         List <Libro> listaOrdenada = new ArrayList<>();
        if (orden.equals("isbn")){

            listaOrdenada =libros.stream().sorted(Comparator.comparing(Libro::getIsbn)).toList();

        }else if (orden.equals("titulo")){

            listaOrdenada = libros.stream().sorted(Comparator.comparing(Libro::getTitulo)).toList();

        }else{
            listaOrdenada = libros.stream().sorted(Comparator.comparing(Libro::getAutor)).toList();
        }

        return listaOrdenada;

    }


}
