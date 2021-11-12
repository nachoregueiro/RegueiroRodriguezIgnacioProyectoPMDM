package es.regueirorodriguezignacioproyectopmdm

import Dao.PeliculasDao
import Dao.PeliculasDaoMock
import adapters.PeliculasListaAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityListaPeliculasBinding
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityMainBinding

class ListaPeliculasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaPeliculasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        binding = ActivityListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peliculasDao =PeliculasDaoMock()
        val listaPeliculas= peliculasDao.getTodos()


        val layoutManager=LinearLayoutManager(this)
        val adapter = PeliculasListaAdapter(listaPeliculas,this)

        binding.rvPeliculasList.adapter =adapter
        binding.rvPeliculasList.layoutManager =layoutManager

    }
}