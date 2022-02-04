package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.remove
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View.inflate
import android.widget.Toast
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityDetallePeliculaBinding.inflate
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityEdicionBinding
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityMainBinding
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityRegistroBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EdicionActivity : AppCompatActivity() {

    private lateinit var pelicula: Pelicula
    private lateinit var binding:ActivityEdicionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edicion)

        binding=ActivityEdicionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val actionBar = actionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        pelicula=intent.extras?.get("Pelicula") as Pelicula
        binding.etTitulo.setText(pelicula.titulo)
        binding.etUsuario.setText(pelicula.director)
        binding.etActor.setText(pelicula.actor)
        binding.etNota.setText(pelicula.nota)
        binding.etUrl.setText(pelicula.url)
        binding.etGenero.setText(pelicula.genero)
        binding.etAO.setText(pelicula.año)

  /*      val context = this
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
        )*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edicion,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.anhadir){
            peliculas.remove(pelicula)
            val ePrDirector=binding.etUsuario.text.toString()
            val ePrActor= binding.etActor.text.toString()
            val ePrNota=binding.etNota.text.toString()
            val ePrUrl=binding.etUrl.text.toString()
            val ePrTitulo=binding.etTitulo.text.toString()
            val ePrGenero=binding.etGenero.text.toString()
            val ePrAño=binding.etAO.text.toString()
            val pel=Pelicula(ePrTitulo, ePrDirector, ePrActor, ePrNota, ePrGenero,ePrAño,ePrUrl)
            peliculas.add(pel)
            Toast.makeText(this,"la pelicula se ha actualizado correctamente",Toast.LENGTH_SHORT).show()
            finish()
        }
        if(item.itemId==item.itemId){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
