package es.cie.springbootlibro.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.cie.springbootlibro.negocio.Libro;
import es.cie.springbootlibro.repositories.LibroRepositoryMemoria;

@Controller
public class LibroController {

     @Autowired
    private LibroRepositoryMemoria libroRepository;

    public LibroController(){

    }

@GetMapping("/listalibros")
    public String listalibros(Model modelo) {
        modelo.addAttribute("listalibros",libroRepository.buscarTodos());
        return "listalibros";
    }

    @PostMapping("/insertarlibro")
    public String insertarlibro(@ModelAttribute Libro libro) {
        
        libroRepository.insertarlibro(libro);
        
        return "redirect:listalibros";
    }

    @PostMapping("/salvarlibro")
    public String salvarLibro(@ModelAttribute Libro libro , @RequestParam String libroAntiguo) {
        
        Optional<Libro>oLibro=libroRepository.buscarUno(libroAntiguo);
        
        if(oLibro.isPresent()){
            Libro libroActual=oLibro.get();
            libroActual.setIsbn(libro.getIsbn());
            libroActual.setTitulo(libro.getTitulo());
            libroActual.setAutor(libro.getAutor());
        }
        return "redirect:listalibros";
    }

    @GetMapping("/formulariolibro")
    public String formulariolibro() {
        
        return "formulariolibro";
    }

    @GetMapping("/borrar")
    public String borrarLibro(@RequestParam("isbn")String isbn) {
        libroRepository.borrarLibro(isbn);
        return "redirect:listalibros";
    }

    @GetMapping("/detalle")
    public String detalleLibro(@RequestParam ("isbn") String isbn,Model modelo) {
        Optional<Libro> oLibro=libroRepository.buscarUno(isbn);
        if(oLibro.isPresent()){
            modelo.addAttribute("libro",oLibro.get());
        }
        return "detallelibro";
    }
    @GetMapping("/editar")
    public String editarLibro(@RequestParam ("isbn") String isbn,Model modelo) {
        Optional<Libro>oLibro=libroRepository.buscarUno(isbn);

        if(oLibro.isPresent()){
            modelo.addAttribute("libro",oLibro.get());
        }
        return "formularioeditarlibro";
    }

     @GetMapping(value="/listalibros",params="orden")
    public String listasocios(Model modelo, @RequestParam String orden) {

        List<Libro> listaOrdenada= libroRepository.buscarTodosOrdenados(orden);
        modelo.addAttribute("listalibros",listaOrdenada);
        return "listalibros";

    }
}
