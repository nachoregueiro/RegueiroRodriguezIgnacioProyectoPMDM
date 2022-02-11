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
        binding.etActor.setText(pelicula.duracion)
        binding.etNota.setText(pelicula.nota)
        binding.etUrl.setText(pelicula.url)
        binding.etGenero.setText(pelicula.genero)
        binding.etDuraciN.setText(pelicula.duracion)

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
          /*  pelicula.director=binding.etUsuario.text.toString()
            pelicula. binding.et.text.toString()
            val ePrNota=binding.etNota.text.toString()
            val ePrUrl=binding.etUrl.text.toString()
            val ePrTitulo=binding.etTitulo.text.toString()
            val ePrGenero=binding.etGenero.text.toString()
            val ePrAño=binding.etAO.text.toString()*/
            pelicula.director=binding.etUsuario.text.toString()
            pelicula.titulo=binding.etTitulo.text.toString()
            pelicula.duracion=binding.etDuraciN.text.toString()
            pelicula.nota=binding.etNota.text.toString()
            pelicula.url=binding.etUrl.text.toString()


            val retrofit=ClienteRetrofit.apiRetroFit.update(pelicula,"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0NDU3NzQxNiwiZXhwIjoxNjQ0NjYzODE2fQ.gNeGE_YiPK4UclZ_DW4EhIhvCd9gElE4xs1KyKn7dqw")

            retrofit.enqueue(object :Callback<Unit>{
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@EdicionActivity,"Pelicula Actualizada correctamente",Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
        if(item.itemId==item.itemId){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
