package es.regueirorodriguezignacioproyectopmdm

import Dao.PeliculasDaoMock
import adapters.PeliculasListaAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityListaPeliculasBinding

class ListaPeliculasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaPeliculasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        binding = ActivityListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peliculasDao =PeliculasDaoMock()
        val listaPeliculas= peliculasDao.getTodos()


        val layoutManager=GridLayoutManager(this,2)
        val adapter = PeliculasListaAdapter(listaPeliculas,this)

        binding.rvPeliculasList.adapter =adapter
        binding.rvPeliculasList.layoutManager =layoutManager

        setTitle("Lista de peliculas")

        binding.botNflotante.setOnClickListener {
            val intent = Intent(this, formulario_Pelicula::class.java)
            startActivity(intent)
        }

    }
}