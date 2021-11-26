package es.regueirorodriguezignacioproyectopmdm

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import com.squareup.picasso.Picasso
import entities.Pelicula

class detalle_Pelicula_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        setTitle("Detalle de las películas")

        val pelicula1 = intent.extras?.get("Pelicula") as Pelicula

        //declaración elementos
        val tvTitulo=findViewById<TextView>(R.id.tvTitulo)
        val tvDirector=findViewById<TextView>(R.id.tvDirector)
        val tvActor=findViewById<TextView>(R.id.tvActor)
        val tvNota=findViewById<TextView>(R.id.tvNota)
        val ivFoto=findViewById<ImageView>(R.id.ivFoto)

        //visualización elementos
        tvTitulo.setText(pelicula1.titulo)
        tvDirector.setText(pelicula1.director)
        tvActor.setText(pelicula1.actor)
        tvNota.setText(""+pelicula1.nota)
        Picasso.get().load(pelicula1.url).into(ivFoto)



       // val toolbar = findViewById<View>(R.id.toolbar) as Toolbar // get the reference of Toolbar

        // setSupportActionBar(toolbar) // Setting/replace toolbar as the ActionBar

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.check -> {
                Toast.makeText(this, "Personaje guardado correctamente.", Toast.LENGTH_SHORT).show()
                finish()
                true
            }
            R.id.papelera -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Eliminar personaje")
                    .setMessage("La película seleccionada va a ser eliminada, ¿está seguro?")
                    .setPositiveButton("Aceptar") { _, _ ->
                        Toast.makeText(this, "Personaje eliminado.", Toast.LENGTH_SHORT).show()
                        finish()
                    }.setNegativeButton("Cancelar", null)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    }



