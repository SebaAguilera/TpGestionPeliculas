package com.GestionPeliculasTp.Service;

import com.GestionPeliculasTp.Exception.BussinesException;
import com.GestionPeliculasTp.Model.Pelicula;
import com.GestionPeliculasTp.Repository.PeliculaRepository;
import com.GestionPeliculasTp.Validator.PeliculaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PeliculaValidator peliculaValidator;

    //Obtener todas las peliculas
    public List<Pelicula> getAllPeliculas (){return  peliculaRepository.findAll();}

    //Buscar por id
    public Optional<Pelicula> getById (Long id){return peliculaRepository.findById(id);}

    //Eliminar por id
    public void DeleteById (Long id) {peliculaRepository.deleteById(id);}

    //AgregarPelicula
    public Pelicula addPelicula (Pelicula pelicula) throws BussinesException{
        peliculaValidator.verificarDatos(pelicula);
        peliculaValidator.verificarGenero(pelicula);
        peliculaValidator.verificarAnio(pelicula);

        return peliculaRepository.save(pelicula);
    }

    //Buscar por anio
    public List<Pelicula> findByAnio (Integer anio){
        List<Pelicula> peliculaList = peliculaRepository.findByAnio(anio);
        return peliculaList;
    }

    //Buscar por director y titulo
    public List<Pelicula> BuscarPorDirectorYTitulo (String titulo, String director){
        return peliculaRepository.findByTituloAndDirector(titulo, director);
    }






}
