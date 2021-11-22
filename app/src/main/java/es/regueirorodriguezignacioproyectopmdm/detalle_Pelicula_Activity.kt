package es.regueirorodriguezignacioproyectopmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityListaPeliculasBinding

class detalle_Pelicula_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

    setTitle("Detalle de las películas")

        val pelicula1 = intent.extras?.get("Pelicula") as Pelicula

        val tv1=findViewById<TextView>(R.id.tv1)

    //falta visualizar

    }
}