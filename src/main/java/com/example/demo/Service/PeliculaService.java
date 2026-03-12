package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula getPeliculaById(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula savePelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void deleteBook(Long id) {
        peliculaRepository.deleteById(id);
    }

    public Pelicula patchPelicula(Long id, Pelicula parcialPelicula){
    Optional<Pelicula> peliculaOptional = peliculaRepository.findById(id);
    if(peliculaOptional.isPresent()){

        Pelicula peliculaToUpdate = peliculaOptional.get();

        if(parcialPelicula.getAuthor() != null){
            peliculaToUpdate.setAuthor(parcialPelicula.getAuthor());
        }
        if(parcialPelicula.getTitle() != null){
            peliculaToUpdate.setTitle(parcialPelicula.getTitle());
        }
        return peliculaRepository.save(peliculaToUpdate);
    }else {
        return null;
        }
    }


}
