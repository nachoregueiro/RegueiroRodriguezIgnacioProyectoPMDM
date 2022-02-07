package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.Api
import Dao.retrofit.ClienteRetrofit
import Dao.retrofit.Usuario
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
import retrofit2.converter.gson.GsonConverterFactory

class ListaPeliculasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaPeliculasBinding
    private lateinit var adapter: PeliculasListaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)


        binding = ActivityListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val context=this
        val llamadaApi:Call<List<Pelicula>> = ClienteRetrofit.apiRetroFit.getPeliculas("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0NDIyMTM4MCwiZXhwIjoxNjQ0MzA3NzgwfQ.yMrjSqhiTbg6f85hExusc1X0mpxl1dgmlSyBh1bJfVg")

        llamadaApi.enqueue(object :Callback<List<Pelicula>> {
            override fun onResponse(call: Call<List<Pelicula>>,
                                    response: Response<List<Pelicula>>) {

                var respon = response.body()
                Toast.makeText(context,"",Toast.LENGTH_SHORT).show()
                //actualizar el adapter
                binding.rvPeliculasList.adapter = adapter
                //adapter
            }
            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("Error",t.message.toString())
            }
        }
        )

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