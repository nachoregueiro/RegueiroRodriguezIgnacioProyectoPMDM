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
        binding.etDirector.setText(pelicula.director)
        binding.etActor.setText(pelicula.actor)
        binding.etNota.setText(pelicula.nota)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edicion,menu)
        return true
    }

       if(item.itemId==R.id.anhadir) {
           peliculas.remove(pelicula)
        val ePr1=binding.etDirector.text.toString()
       val ePr2= binding.etActor.text.toString()
        val ePr3=binding.etNota.text.toString()
        val pel=Pelicula("a", ePr1, ePr2, ePr3, "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zvqp1enRqGmzFXV8jXixmICMYVw.jpg")
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