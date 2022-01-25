package Dao.retrofit

import entities.Pelicula
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movies")
    fun getPeliculas(): Call<List<Pelicula>>

    /*
    TODO:declarar los métodos siguiendo la documentación
     */
}