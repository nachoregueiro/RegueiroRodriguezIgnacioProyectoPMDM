package es.regueirorodriguezignacioproyectopmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
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
        val ivFoto=findViewById<ImageView>(R.id.ivFoto)

        //visualización elementos
        tvTitulo.setText(pelicula1.titulo)
        tvDirector.setText(pelicula1.director)
        tvActor.setText(pelicula1.actor)

    }
}