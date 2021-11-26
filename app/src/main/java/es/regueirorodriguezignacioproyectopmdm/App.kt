package es.regueirorodriguezignacioproyectopmdm

import Dao.PeliculasDaoMock
import android.app.Application
import entities.Pelicula

class App : Application(){

    companion object {
        var peliculas:ArrayList<Pelicula> = ArrayList()
    }

    override fun onCreate() {
        super.onCreate()
        val dao=PeliculasDaoMock()
        peliculas = dao.getTodos()
    }
}