package entities

import java.io.Serializable

data class Pelicula(
    var titulo:String,
    var director:String,
    var actor:String,
    var nota:String,
    var genero:String,
    var año:String,
    var url:String,
)
    :Serializable
{}
