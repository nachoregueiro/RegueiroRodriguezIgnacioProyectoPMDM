package es.regueirorodriguezignacioproyectopmdm

import adapters.PeliculasListaAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityListaPeliculasBinding

class ListaPeliculasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaPeliculasBinding
    private lateinit var adapter: PeliculasListaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        binding = ActivityListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val layoutManager=GridLayoutManager(this,2)
        adapter = PeliculasListaAdapter(peliculas,this)

        binding.rvPeliculasList.adapter =adapter
        binding.rvPeliculasList.layoutManager =layoutManager

        setTitle("Lista de peliculas")

        binding.botNFlotante.setOnClickListener {
            val intent = Intent(this, Formulario_Pelicula::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        adapter!!.notifyDataSetChanged()
    }
}