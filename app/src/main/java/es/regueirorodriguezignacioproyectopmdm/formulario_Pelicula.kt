package es.regueirorodriguezignacioproyectopmdm

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class formulario_Pelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_pelicula)
    //formulario detalle peliculas
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_personaje,menu)
        return true
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