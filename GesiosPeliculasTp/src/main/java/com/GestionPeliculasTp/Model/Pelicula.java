package com.GestionPeliculasTp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name="peliculas")
public class Pelicula {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El titulo no puede estar vacío")
    @Size (min = 2,max = 100, message ="Debe tener entre 2 y 100 caracteres")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "El director no puede estar vacío")
    private String director;

    @Min(value = 1895, message = "El año debe ser mayor o igual a 1895")
    @Max(value = 2027, message = "El año debe ser menor o igual a 2027")
    @NotNull(message = "El año de lanzamiento no puede ser nulo")
    private Integer anio;

    @Column
    private String genero;

    //CONSTRUCTOR

    public Pelicula(String titulo, String director, Integer anio, String genero) {
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.genero = genero;
    }

    public Pelicula() {
    }

    //Getters y setters

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public void setGenero(String genero){this.genero = genero;}
    public String getGenero (){return this.genero;}


}
