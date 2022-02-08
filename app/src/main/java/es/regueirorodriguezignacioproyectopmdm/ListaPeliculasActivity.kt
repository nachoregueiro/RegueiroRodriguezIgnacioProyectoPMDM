package es.regueirorodriguezignacioproyectopmdm

import Dao.Preferences
import Dao.retrofit.Api
import Dao.retrofit.ClienteRetrofit
import Dao.retrofit.Usuario
import adapters.PeliculasListaAdapter
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityListaPeliculasBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaPeliculasActivity : AppCompatActivity() {
    private lateinit var   rvPeliculasAdapter:RecyclerView
    private lateinit var binding: ActivityListaPeliculasBinding
    private lateinit var adapter: PeliculasListaAdapter
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)


        binding = ActivityListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val context=this
        val llamadaApi:Call<List<Pelicula>> = ClienteRetrofit.apiRetroFit.getPeliculas("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0NDMwODAyOSwiZXhwIjoxNjQ0Mzk0NDI5fQ.Fk1ANBsuD_QiJYUvJbdI9uBzTDrGypZaFVRPg1tH7Ow")

        llamadaApi.enqueue(object :Callback<List<Pelicula>> {
            override fun onResponse(call: Call<List<Pelicula>>,
                                    response: Response<List<Pelicula>>) {

                val listaPelicula: List<Pelicula>? = response.body()


                if (response.isSuccessful){
                    Toast.makeText(context,"Todo correcto", Toast.LENGTH_LONG).show()
                }


//                //actualizar el adapter para ver las peliculas
//                binding.rvPeliculasList.adapter = adapter
//                var adapter=PeliculasListaAdapter(listaPelicula, this@ListaPeliculasActivity)
//                rvPeliculasAdapter.adapter=adapter



                Toast.makeText(context,"Prueba",Toast.LENGTH_SHORT).show()




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
        val context=this

       // val token=pref.sacarToken()

        val llamadaApi = ClienteRetrofit.apiRetroFit.getAll("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0NDMwODAyOSwiZXhwIjoxNjQ0Mzk0NDI5fQ.Fk1ANBsuD_QiJYUvJbdI9uBzTDrGypZaFVRPg1tH7Ow" ) //Llamamos a Retrofit


        llamadaApi.enqueue(object : Callback<List<Pelicula>> {
            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())
            }

            override fun onResponse(call: Call<List<Pelicula>>, response: Response<List<Pelicula>>) {
                if (response.code() > 299 || response.code() < 200) {
                    val adb = AlertDialog.Builder(context)
                    adb.setTitle("Lista de peliculas")
                    adb.setMessage("La lista de películas no pudo cargarse correctamente")
                    adb.setPositiveButton("Aceptar") { dialog, which -> }
                    adb.show()
                } else {
                    val listaPelicula: List<Pelicula>? = response.body()

                    val layoutManager = LinearLayoutManager(context)
                    val adapter = PeliculasListaAdapter(listaPelicula, context)

                    binding.rvPeliculasList.adapter = adapter
                    binding.rvPeliculasList.layoutManager = layoutManager
                }
            }
        })
    }


}