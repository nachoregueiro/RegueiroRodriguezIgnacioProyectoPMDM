package Dao

import entities.Pelicula

class PeliculasDaoMock :PeliculasDao {


    override fun getTodos(): List<Pelicula> {
        val peli = Pelicula("interstellar", "christopher nolan", "Matthew McConaughey","https://pics.filmaffinity.com/Eternals-388789083-large.jpg")

        val listaPersonajes = listOf(peli, peli, peli)
        return listaPersonajes

    }
}