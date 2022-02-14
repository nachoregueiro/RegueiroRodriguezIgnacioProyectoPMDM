package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
import adapters.PeliculasListaAdapter
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Formulario_Pelicula : AppCompatActivity() {

    private lateinit var tveTitulo: TextInputEditText
    private lateinit var tveGenero: TextInputEditText
    private lateinit var tvDirector: TextInputEditText
    private lateinit var tveAño: TextInputEditText
    private lateinit var tveNota: TextInputEditText
    private lateinit var tveUrl: TextInputEditText
    private lateinit var tveDuracion: TextInputEditText

    private lateinit var pelicula1: Pelicula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pelicula)

        tveTitulo = findViewById(R.id.tveTitulo)
        tveGenero = findViewById<TextInputEditText>(R.id.tveGénero)
        tvDirector = findViewById<TextInputEditText>(R.id.tveDirector)
        tveAño = findViewById<TextInputEditText>(R.id.tveAño)
        tveNota = findViewById<TextInputEditText>(R.id.tveNota)
        tveDuracion = findViewById<TextInputEditText>(R.id.tveDuración)
        tveUrl = findViewById<TextInputEditText>(R.id.tveUrl)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_personaje, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            //Para añadir una pelicula
            R.id.check -> {
                val titulo = tveTitulo.text.toString()
                val duracion = tveDuracion.text.toString()
                val director = tvDirector.text.toString()
                val nota = tveNota.text.toString()
                val genero = tveGenero.text.toString()
                val año = tveAño.text.toString()
                val url = tveUrl.text.toString()

                peliculas.add(Pelicula(titulo, director, duracion, nota, genero, año, url,null))

                finish()

                val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
                val Token: String ="Bearer "+ sharedPreferences.getString("TOKEN", null)
                val context = this
                val llamadaApi: Call<Unit> = ClienteRetrofit.apiRetroFit.create(Pelicula(titulo,director,duracion,nota,genero,año,url,null),Token)


                llamadaApi.enqueue(object : Callback<Unit> {

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()

                    }

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.isSuccessful){

                            Toast.makeText(context, "Correcto", Toast.LENGTH_SHORT).show()

                        }else{
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                        }

                    }
                })

                return true

            }
            //Para editar
            R.id.editar -> {
                tveTitulo.isEnabled = true
                tveGenero.isEnabled = true
                tvDirector.isEnabled = true
                tveAño.isEnabled = true
                tveNota.isEnabled = true
                tveUrl.isEnabled = true

                pelicula1 = intent.extras?.get("Pelicula") as Pelicula

                tveTitulo.setText(pelicula1.titulo)
                tveNota.setText(pelicula1.nota)
                tvDirector.setText(pelicula1.director)
                tveGenero.setText(pelicula1.genero)
                tveAño.setText(pelicula1.año)
                tveUrl.setText(pelicula1.url)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }


    override fun onResume() {
        super.onResume()
    }
}