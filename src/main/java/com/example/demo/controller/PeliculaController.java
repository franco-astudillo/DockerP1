package com.example.demo.controller;


import com.example.demo.model.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaRepository bookRepository;

    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = bookRepository.save(pelicula);
        // Esto asegura que Postman reciba el objeto creado y un estado 201
        return new ResponseEntity<>(nuevaPelicula, HttpStatus.CREATED);

    }
}