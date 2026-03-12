package com.example.demo.controller;

import com.example.demo.model.Pelicula;
import com.example.demo.Service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    // Crear una nueva película
    @PostMapping
    public ResponseEntity<Pelicula> createPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nuevaPelicula = peliculaService.savePelicula(pelicula);
        return new ResponseEntity<>(nuevaPelicula, HttpStatus.CREATED);
    }

    // Obtener el listado de todas las películas
    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    // Obtener una película específica por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Long id) {
        Pelicula pelicula = peliculaService.getPeliculaById(id);
        if (pelicula != null) {
            return ResponseEntity.ok(pelicula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar parcialmente una película (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<Pelicula> patchPelicula(@PathVariable Long id, @RequestBody Pelicula parcialPelicula) {
        Pelicula actualizada = peliculaService.patchPelicula(id, parcialPelicula);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}