package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
import Dao.retrofit.Usuario
import Dao.retrofit.entities.Token
import android.app.AlertDialog
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


        val tvTitulo = findViewById<TextView>(R.id.tveTitulo)
        val tvDirector = findViewById<TextView>(R.id.tvDirector)
        val tvDuracion = findViewById<TextView>(R.id.tveDuración)
        val tvNota = findViewById<TextView>(R.id.tvNota)
        val tvAño = findViewById<TextView>(R.id.tvAnho)
        val tvGenero = findViewById<TextView>(R.id.tvGenero)
        val ivFoto = findViewById<ImageView>(R.id.ivFoto)
        val btllamar = findViewById<Button>(R.id.btLlamar)

        tvTitulo.setText(pelicula1.titulo)
        tvDirector.setText(pelicula1.director)
        tvDuracion.setText(pelicula1.duracion)
        tvNota.setText(pelicula1.nota)
        tvGenero.setText(pelicula1.genero)
        tvAño.setText(pelicula1.año)
        Picasso.get().load(pelicula1.url).into(ivFoto)



        val actionBar = actionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btllamar.setOnClickListener() {
            val telefono = "tel:12345678"
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(telefono)))
        }

        val context = this
        val loginCall = ClienteRetrofit.apiRetroFit.login(Usuario("", ""))


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

                    val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
                    val Token: String ="Bearer "+ sharedPreferences.getString("TOKEN", null)
                    val llamadaApi=ClienteRetrofit.apiRetroFit.borrar(Token,pelicula1.id)


                    llamadaApi.enqueue(object :Callback<Unit>{
                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            if(response.isSuccessful){
                                Toast.makeText(this@Detalle_Pelicula_Activity,"Pelicula borrada",Toast.LENGTH_SHORT)
                            }
                        }
                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            TODO("La pelicula no se ha borrado")
                        }
                    })
                    finish()
                }.setNegativeButton("Cancelar", null)
                .show()
            return true
            finish()

        } else if (item.itemId == R.id.editar) {
            // Iniciar activity de edición
            val intent = Intent(this, EdicionActivity::class.java)
            intent.putExtra("Pelicula", pelicula1)
            startActivity(intent)
        }
        //Para volver atrás
        else if (item.itemId == item.itemId) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}



