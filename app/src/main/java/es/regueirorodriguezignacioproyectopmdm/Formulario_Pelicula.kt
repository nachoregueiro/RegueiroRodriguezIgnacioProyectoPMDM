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

    private lateinit var pelicula1: Pelicula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pelicula)

        //Formulario detalle peliculas
        tveTitulo = findViewById(R.id.tveTitulo)
        tveGenero = findViewById<TextInputEditText>(R.id.tveGénero)
        tvDirector = findViewById<TextInputEditText>(R.id.tveDirector)
        tveAño = findViewById<TextInputEditText>(R.id.tveAño)
        tveNota = findViewById<TextInputEditText>(R.id.tveNota)
        tveUrl = findViewById<TextInputEditText>(R.id.tveUrl)


    /*    val context = this
        val llamadaApi: Call<List<Pelicula>> =
            ClienteRetrofit.apiRetroFit.getPeliculas("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0Mzk2NzUwNywiZXhwIjoxNjQ0MDUzOTA3fQ.vynx3nsnb8X204_zvPwUK7KVVBFM5E-yNv9iNz4_m04")

        llamadaApi.enqueue(object : Callback<List<Pelicula>> {
            override fun onResponse(
                call: Call<List<Pelicula>>,
                response: Response<List<Pelicula>>
            ) {
                var respon = response.body()
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                //actualizar el adapter
                binding.rvPeliculasList.adapter = adapter
            }
            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }
        }
        )
*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_personaje, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.check -> {
                val titulo = tveTitulo.text.toString()
                val actor = tveGenero.text.toString()
                val director = tvDirector.text.toString()
                val nota = tveNota.text.toString()
                val genero = tveGenero.text.toString()
                val año = tveAño.text.toString()
                //El problema era de imagen Como una imagen aqui que no está por defecto es decir la ruta?
                val url = tveUrl.text.toString()
                peliculas.add(Pelicula(titulo, director, actor, nota, genero, año, url))
                Toast.makeText(this, "Pelicula añadida correctamente", Toast.LENGTH_SHORT).show()
                finish()



                val context = this
                val llamadaApi: Call<Unit> = ClienteRetrofit.apiRetroFit.create(Pelicula(titulo,director,actor,nota,genero,año,url),"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0NDMwODAyOSwiZXhwIjoxNjQ0Mzk0NDI5fQ.Fk1ANBsuD_QiJYUvJbdI9uBzTDrGypZaFVRPg1tH7Ow")


                llamadaApi.enqueue(object : Callback<Unit> {


                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        Toast.makeText(context, "chupate un huevo", Toast.LENGTH_SHORT).show()
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
}
