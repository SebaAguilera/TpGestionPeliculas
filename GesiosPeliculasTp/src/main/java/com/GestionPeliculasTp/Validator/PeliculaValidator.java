package com.GestionPeliculasTp.Validator;

import com.GestionPeliculasTp.Exception.BussinesException;
import com.GestionPeliculasTp.Model.Pelicula;
import com.GestionPeliculasTp.Repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeliculaValidator {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public void verificarDatos (Pelicula pelicula) throws BussinesException {
        Boolean flag = peliculaRepository.existsByTituloAndDirector(pelicula.getTitulo(), pelicula.getDirector());
        if (flag){
            throw new BussinesException ("Pelicula ya existente");
        }
    }

    public void verificarGenero (Pelicula pelicula) throws BussinesException{
        if (pelicula.getAnio()<1920 && pelicula.getGenero().equals("Documental")){
            throw new BussinesException("No existe documentales previos a 1920");
        }
    }

    public void verificarAnio (Pelicula pelicula)throws BussinesException{
        if (pelicula.getAnio()<1895 || pelicula.getAnio()>2027){
            throw new BussinesException("El anio de lanzamiento, se encuentra fuera del rango");
        }
    }

}
