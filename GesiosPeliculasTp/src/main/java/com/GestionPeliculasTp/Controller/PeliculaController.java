package com.GestionPeliculasTp.Controller;

import com.GestionPeliculasTp.Exception.BussinesException;
import com.GestionPeliculasTp.Model.Pelicula;
import com.GestionPeliculasTp.Service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/anio/{anio}")
    public ResponseEntity<?> buscarPeliculasPorAnio(@PathVariable Integer anio){
        List<Pelicula> listaPeliculas =  peliculaService.findByAnio(anio);
        if (listaPeliculas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(listaPeliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPeliculaPorId(@PathVariable Long id){
        Optional<Pelicula> opt =  peliculaService.getById(id);
        if (opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        System.out.println("all");
        List<Pelicula> listaPeliculas =  peliculaService.getAllPeliculas();
        if(listaPeliculas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(listaPeliculas);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Pelicula pelicula){
        try {
            Pelicula p = peliculaService.addPelicula(pelicula);
            return ResponseEntity.ok(p);
        } catch (BussinesException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> BuscarPorTituloYDirector(@RequestParam String titulo, @RequestParam  String director){
        System.out.println("params");
        List<Pelicula> opt = peliculaService.BuscarPorDirectorYTitulo(titulo, director);
        if (opt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(opt);
    }


}
