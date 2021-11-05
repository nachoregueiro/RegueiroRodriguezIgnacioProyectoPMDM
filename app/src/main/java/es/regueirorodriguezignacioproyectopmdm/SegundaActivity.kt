package es.regueirorodriguezignacioproyectopmdm

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivitySegundaBinding
import java.util.regex.Pattern

class SegundaActivity : AppCompatActivity() {
    private lateinit var  btAtrás : Button
    private lateinit var binding: ActivitySegundaBinding
//mirar binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btAtrás=findViewById(R.id.btAtrás)

        btAtrás.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btGuardarDatos=findViewById<TextView>(R.id.etEmail)
        val etEmail=findViewById<TextView>(R.id.etEmail)

        btGuardarDatos.setOnClickListener{
            val sharedPrefs = getSharedPreferences(
            "moviespreference", Context.MODE_PRIVATE)
            var editor=sharedPrefs.edit()
            editor.putString("email",etEmail.text.toString())
        }

    }
    private fun validarEmail(email: String): Boolean { //Metodo que comprueba si el email es correcto
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
//Metodo que comprueba si el email es correcto y las contraseñas son validas y coinciden




    }
