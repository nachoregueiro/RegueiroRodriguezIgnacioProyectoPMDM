package Dao

import entities.Pelicula

class PeliculasDaoMock :PeliculasDao {


    override fun getTodos(): List<Pelicula> {
       val peli=Pelicula("Interstellar","Cristopher Nolan","Matthew McConaughey","https://envymovies.com/wp-content/uploads/2021/02/90869ba8fe6692e207e2ba4c1e939a22.jpg")
        val peli1=Pelicula("La llegada","Denis Villeneuve","Amy Adams","https://upload.wikimedia.org/wikipedia/en/d/df/Arrival%2C_Movie_Poster.jpg")
        val peli2=Pelicula("Aniquilación","Alex Garland","Natalie Portman","https://upload.wikimedia.org/wikipedia/ru/c/cd/Annihilation_%28film%29.jpg")
        val peli3=Pelicula("Ready Player One","Steven Spielberg","Tye Sheridan","https://cps-static.rovicorp.com/2/Open/TMDB4_2462/Program/34986035/_2by3/_derived_jpg_q90_600x800_m0/1fhtcqKMcGqRUu4QNoUGPnpX4bfv.jpg")

        val listaPersonajes = listOf(peli)
        return listaPersonajes

    }
}