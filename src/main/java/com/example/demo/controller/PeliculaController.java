package com.example.demo.controller;


import com.example.demo.model.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaRepository bookRepository;

    @PostMapping
    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return bookRepository.save(pelicula);
    }
}
