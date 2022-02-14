package entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    //Clase pelicula con los distintos elementos
    @SerializedName("title") var titulo:String,
    @SerializedName("directorLastname") var director:String,
    @SerializedName("runtimeMinutes") var duracion:String,
    @SerializedName("rating") var nota:String,
    @SerializedName("genre") var genero:String,
    @SerializedName("releaseYear")var año:String,
    @SerializedName("imageUrl")var url:String,
    @SerializedName("id")var id:String?
    )
    :Serializable
{}
