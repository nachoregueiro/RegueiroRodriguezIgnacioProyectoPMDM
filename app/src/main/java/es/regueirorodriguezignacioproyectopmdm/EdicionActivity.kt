package es.regueirorodriguezignacioproyectopmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.remove
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
