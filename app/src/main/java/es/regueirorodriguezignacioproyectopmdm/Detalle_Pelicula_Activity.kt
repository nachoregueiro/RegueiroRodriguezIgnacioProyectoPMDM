package es.regueirorodriguezignacioproyectopmdm

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas

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
        val ivFoto = findViewById<ImageView>(R.id.ivFoto)
        val btllamar = findViewById<Button>(R.id.btLlamar)

        //visualización elementos
        tvTitulo.setText(pelicula1.titulo)
        tvDirector.setText(pelicula1.director)
        tvActor.setText(pelicula1.actor)
        tvNota.setText( pelicula1.nota)
        Picasso.get().load(pelicula1.url).into(ivFoto)



        btllamar.setOnClickListener(){
              val telefono="tel:12345678"
          startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(telefono)))

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_borrar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.borrar){
            peliculas.remove(pelicula1)
            finish()
        }
        else if(item.itemId==R.id.editar){
            // Iniciar activity de edición
            val intent = Intent(this, Formulario_Pelicula::class.java)
            intent.putExtra("Pelicula",pelicula1)
           //para editar tvTitulo.text = pelicula1.director.toString()
            startActivity(intent)
        }


        return super.onOptionsItemSelected(item)
    }


}



