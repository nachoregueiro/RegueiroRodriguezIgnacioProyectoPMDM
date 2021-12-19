package es.regueirorodriguezignacioproyectopmdm

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.App.Companion.peliculas

class Formulario_Pelicula : AppCompatActivity() {

    private lateinit var tveTitulo :TextInputEditText
    private lateinit var tveGenero :TextInputEditText
    private lateinit var tvDirector :TextInputEditText
    private lateinit var tveAño :TextInputEditText
    private lateinit var tveNota:TextInputEditText
    private lateinit var tveUrl:TextInputEditText

    private lateinit var pelicula1: Pelicula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pelicula)

        //formulario detalle peliculas
       tveTitulo=findViewById(R.id.tveTitulo)
        tveGenero=findViewById<TextInputEditText>(R.id.tveGénero)
        tvDirector=findViewById<TextInputEditText>(R.id.tveDirector)
        tveAño=findViewById<TextInputEditText>(R.id.tveAño)
        tveNota=findViewById<TextInputEditText>(R.id.tveNota)
        tveUrl=findViewById<TextInputEditText>(R.id.tveUrl)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_personaje,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.check -> {
                val titulo = tveTitulo.text.toString()
                val actor = tveGenero.text.toString()
                val director = tvDirector.text.toString()
                val nota = tveNota.text.toString()
                //el problema era de imagen Como una imagen aqui que no está por defecto es decir la ruta?
                val url = tveUrl.text.toString()
                peliculas.add(Pelicula(titulo, director, actor, nota, url))
                Toast.makeText(this, "Pelicula añadida correctamente", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
            //para editar
            R.id.editar -> {
                tveTitulo.isEnabled=true
                tveGenero.isEnabled=true
                tvDirector.isEnabled=true
                tveAño.isEnabled=true
                tveNota.isEnabled=true
                tveUrl.isEnabled=true

                pelicula1 = intent.extras?.get("Pelicula") as Pelicula

                tveTitulo.setText(pelicula1.titulo)
               tveNota.setText(pelicula1.nota)
                tvDirector.setText(pelicula1.director)
                tveUrl.setText(pelicula1.url)

                return true
            }

            R.id.borrar -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Eliminar personaje")
                    .setMessage("La película seleccionada va a ser eliminada, ¿está seguro?")
                    .setPositiveButton("Aceptar") {_, _ ->
                        Toast.makeText(this, "Personaje eliminado.", Toast.LENGTH_SHORT).show()
                        finish()
                    }.setNegativeButton("Cancelar", null)
                    .show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }


        }

}
