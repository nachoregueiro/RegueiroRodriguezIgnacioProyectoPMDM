package Dao.retrofit

import Dao.retrofit.entities.Token
import entities.Pelicula
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @POST("users/signup")
    fun signup(@Body user: Usuario): Call<Unit>

    @POST("users/login")
    fun login(@Body user: Usuario): Call<Token>

    @GET("movies")
    fun getPeliculas(@Header("Authorization")token: String): Call<List<Pelicula>>

    /*
        TODO:declarar los métodos siguiendo la documentación
     */

}