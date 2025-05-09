package com.GestionPeliculasTp.Repository;

import com.GestionPeliculasTp.Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {

    List<Pelicula> findByAnio (Integer anio);
    List<Pelicula> findByTituloAndDirector (String titulo, String director);
    Boolean existsByTituloAndDirector (String titulo, String director);
}
