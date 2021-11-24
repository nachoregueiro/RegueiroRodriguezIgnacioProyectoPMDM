package entities

import java.io.Serializable

class Pelicula(
    var titulo:String,
    var director:String,
    var actor:String,
    var nota: Double,
    var url:String
)
    :Serializable
{}
