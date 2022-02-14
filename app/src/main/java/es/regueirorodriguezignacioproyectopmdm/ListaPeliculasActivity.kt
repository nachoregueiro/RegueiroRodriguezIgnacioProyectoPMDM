package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.Api
import Dao.retrofit.ClienteRetrofit
import Dao.retrofit.Usuario
import adapters.PeliculasListaAdapter
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityEdicionBinding
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityListaPeliculasBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.prefs.Preferences

class ListaPeliculasActivity : AppCompatActivity() {
    private lateinit var  rvPeliculasAdapter:RecyclerView
    private lateinit var binding: ActivityListaPeliculasBinding
    private lateinit var adapter: PeliculasListaAdapter
    private lateinit var pref: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        binding = ActivityListaPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val context=this

        val actionBar = actionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        //Obtenemos las peliculas de la api utilizando retrofit
        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val Token: String ="Bearer "+ sharedPreferences.getString("TOKEN", null)
        val llamadaApi=ClienteRetrofit.apiRetroFit.getPeliculas(Token)


        llamadaApi.enqueue(object :Callback<List<Pelicula>> {
            override fun onResponse(call: Call<List<Pelicula>>,
                                    response: Response<List<Pelicula>>) {

                val listaPelicula: List<Pelicula>? = response.body()

                if (response.isSuccessful){
                    Toast.makeText(context,"Todo correcto", Toast.LENGTH_LONG).show()
                }
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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cerrarsesion,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if(item.itemId == R.id.salir){
                val context=this
            val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply() {
                putString("TOKEN", null)
            }.apply()

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_SHORT).show()
            finish()
        }
            return super.onOptionsItemSelected(item)
        }

    override fun onResume() {
        super.onResume()
        val context=this
        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val Token: String ="Bearer "+ sharedPreferences.getString("TOKEN", null)
        val llamadaApi = ClienteRetrofit.apiRetroFit.getAll(Token) //Llamamos a Retrofit


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