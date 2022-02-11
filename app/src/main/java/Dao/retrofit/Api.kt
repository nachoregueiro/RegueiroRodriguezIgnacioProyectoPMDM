package Dao.retrofit

import Dao.retrofit.entities.Token
import entities.Pelicula
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("users/signup")
    fun signup(@Body user: Usuario): Call<Unit>

    @POST("users/login")
    fun login(@Body user: Usuario): Call<Token>

    @GET("movies")
    fun getPeliculas(@Header("Authorization")token: String): Call<List<Pelicula>>

    @GET("movies/{id}")
    fun getId(@Header("Authorization")token: String, @Path("id")id:String?): Call<Pelicula>

    @GET("movies")
    fun getAll(@Header("Authorization:") token:String): Call<List<Pelicula>>

    @POST("movies/")
    fun create(@Body pelicula: Pelicula, @Header("Authorization")token: String ): Call<Unit>

    @PUT("movies/")
    fun update(@Body pelicula: Pelicula, @Header("Authorization")token: String ): Call<Unit>

    @DELETE("movies/{id}")
    fun borrar(@Header("Authorization")token: String,@Path("id")id:String?):Call<Unit>


}