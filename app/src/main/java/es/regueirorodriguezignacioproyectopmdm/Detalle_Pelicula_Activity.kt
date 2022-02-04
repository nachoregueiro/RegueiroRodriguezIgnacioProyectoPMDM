package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
import Dao.retrofit.Usuario
import Dao.retrofit.entities.Token
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class Detalle_Pelicula_Activity : AppCompatActivity() {

    private lateinit var pelicula1: Pelicula


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        setTitle("Detalle de las películas")

        pelicula1 = intent.extras?.get("Pelicula") as Pelicula

        //declaración elementos
        val tvTitulo = findViewById<TextView>(R.id.tveTitulo)
        val tvDirector = findViewById<TextView>(R.id.tvDirector)
        val tvActor = findViewById<TextView>(R.id.tveActor)
        val tvNota = findViewById<TextView>(R.id.tvNota)
        val tvAño = findViewById<TextView>(R.id.tvAnho)
        val tvGenero = findViewById<TextView>(R.id.tvGenero)
        val ivFoto = findViewById<ImageView>(R.id.ivFoto)
        val btllamar = findViewById<Button>(R.id.btLlamar)

        //visualización elementos
        tvTitulo.setText(pelicula1.titulo)
        tvDirector.setText(pelicula1.director)
        tvActor.setText(pelicula1.actor)
        tvNota.setText(pelicula1.nota)
        tvGenero.setText(pelicula1.genero)
        tvAño.setText(pelicula1.año)

        //error al cargar la foto

        if (!pelicula1.url.equals("")) {
            try {
                Picasso.get()
                    .load("https://sercide.com/wp-content/themes/consultix/images/no-image-found-360x260.png")
            } catch (e: Exception) {
                Toast.makeText(getApplicationContext(), "NO IMAGEN", Toast.LENGTH_SHORT).show()
            };
        }
        Picasso.get().load(pelicula1.url).into(ivFoto)


        val actionBar = actionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btllamar.setOnClickListener() {
            val telefono = "tel:12345678"
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(telefono)))
        }

        val context = this
        val loginCall = ClienteRetrofit.apiRetroFit.login(Usuario("", ""))

        loginCall.enqueue(object : Callback<Token> {
            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                Log.d("respuesta: onResponse", response.toString())
                val intent =
                    Intent(this@Detalle_Pelicula_Activity, ListaPeliculasActivity::class.java)
                startActivity(intent)
                if (response.code() > 299 || response.code() < 200) {
                    // Muestro alerta: no se ha podido crear el usuario
                    Toast.makeText(
                        context,
                        "No se ha podido crear el usuario",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    val token = response.body()?.token
                    Log.d("respuesta: token:", token.orEmpty())
                    val intent = Intent(
                        this@Detalle_Pelicula_Activity,
                        ListaPeliculasActivity::class.java
                    )
                    // TODO: Muestro mensaje de usuario creado correctamente.

                    // TODO: Guardo en sharedPreferences el token

                    // TODO: Inicio nueva activity
                }

            }
        })
    }
            override fun onCreateOptionsMenu(menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.menu_borrar, menu)
                return true
            }

            override fun onOptionsItemSelected(item: MenuItem): Boolean {
                if (item.itemId == R.id.borrar) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Eliminar pelicula")
                        .setMessage("La película seleccionada va a ser eliminada, ¿estás seguro?")
                        .setPositiveButton("Aceptar") { _, _ ->
                            peliculas.remove(pelicula1)
                            Toast.makeText(this, "Pelicula eliminada", Toast.LENGTH_SHORT).show()
                            finish()
                        }.setNegativeButton("Cancelar", null)
                        .show()
                    return true
                    finish()
                } else if (item.itemId == R.id.editar) {
                    // Iniciar activity de edición
                    val intent = Intent(this, EdicionActivity::class.java)
                    intent.putExtra("Pelicula", pelicula1)
                    //para editar tvTitulo.text = pelicula1.director.toString()
                    startActivity(intent)
                } else if (item.itemId == item.itemId) {
                    onBackPressed()
                    return true
                }

                return super.onOptionsItemSelected(item)
            }
        }






