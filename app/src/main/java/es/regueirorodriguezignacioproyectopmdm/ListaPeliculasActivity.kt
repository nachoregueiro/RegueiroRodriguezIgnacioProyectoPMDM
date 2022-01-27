package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
import adapters.PeliculasListaAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityListaPeliculasBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ListaPeliculasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaPeliculasBinding
    private lateinit var adapter: PeliculasListaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        val context = this

        binding = ActivityListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val llamadaApi:Call<List<Pelicula>> = ClienteRetrofit.apiRetroFit.getPeliculas()





        llamadaApi.enqueue(object :Callback<List<Pelicula>> {
            override fun onResponse(call: Call<List<Pelicula>>,response: Response<List<Pelicula>>) {
                Toast.makeText(context,response.body().toString(),Toast.LENGTH_SHORT).show()
            }
            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("PRUEBA",t.message.toString())
            }
        })

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
        val size = peliculas.size
        adapter!!.notifyDataSetChanged()
    }


}