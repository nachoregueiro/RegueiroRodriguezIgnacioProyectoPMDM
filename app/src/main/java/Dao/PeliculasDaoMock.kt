package Dao

import entities.Pelicula

class PeliculasDaoMock : PeliculasDao {


    override fun getTodos(): ArrayList<Pelicula> {
        val lista = ArrayList<Pelicula>()
        lista.addAll(
            listOf(
                Pelicula(
                    "Interstellar",
                    "Cristopher Nolan",
                    "Matthew McConaughey",
                    9.1,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nrSaXF39nDfAAeLKksRCyvSzI2a.jpg"
                ),
                Pelicula(
                    "La llegada",
                    "Denis Villeneuve",
                    "Amy Adams",
                    8.7,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tbVITeytclB4JKx2LxxasrCCmZx.jpg"
                ),
                Pelicula(
                    "Aniquilación",
                    "Alex Garland",
                    "Natalie Portman",
                    7.25,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zvqp1enRqGmzFXV8jXixmICMYVw.jpg",
                ),
                Pelicula(
                    "Ready Player One",
                    "Steven Spielberg",
                    "Tye Sheridan",
                    8.5,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2iuVrtC5IpwLtSFSgkIIIKLs0Zq.jpg"
                )
            )
        )
        return lista
    }
}