package entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    @SerializedName("title") var titulo:String,
    @SerializedName("directorLastname") var director:String,
    var actor:String,
    var nota:String,
    var genero:String,
    var año:String,
    var url:String,
)
    :Serializable
{}
