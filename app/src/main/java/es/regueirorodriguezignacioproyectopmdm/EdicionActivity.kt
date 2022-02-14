package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
import android.content.Intent
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


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edicion,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Para añadir dentro recibe la función
        if(item.itemId==R.id.anhadir){

            añadir()
            finish()

        }
        //para volver atrás
        if(item.itemId==item.itemId){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

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


    }


    //Función que te permite añadir
    fun añadir(){
        pelicula.director=binding.etUsuario.text.toString()
        pelicula.titulo=binding.etTitulo.text.toString()
        pelicula.duracion=binding.etDuraciN.text.toString()
        pelicula.nota=binding.etNota.text.toString()
        pelicula.url=binding.etUrl.text.toString()
        var context = this

        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val Token: String ="Bearer "+ sharedPreferences.getString("TOKEN", null)
        val llamadaApi=ClienteRetrofit.apiRetroFit.update(pelicula,Token)

        llamadaApi.enqueue(object :Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if(response.isSuccessful){
                    Toast.makeText(this@EdicionActivity,"Pelicula Actualizada correctamente",Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, ListaPeliculasActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                TODO("Error")
            }

        })


    }

}