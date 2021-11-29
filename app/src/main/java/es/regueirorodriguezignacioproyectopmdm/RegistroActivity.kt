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
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityRegistroBinding
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity() {
    private lateinit var  btAtrás : Button
    private lateinit var binding: ActivityRegistroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btAtrás=findViewById(R.id.btAtrás)
        setTitle("Registro")


        btAtrás.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btGuardarDatos=findViewById<TextView>(R.id.etEmail)
        val etEmail=findViewById<TextView>(R.id.etEmail)

        binding.btGuardarDatos.setOnClickListener{

            val sharedPrefs = getSharedPreferences(
            "moviespreference", Context.MODE_PRIVATE)
            var editor=sharedPrefs.edit()
            editor.putString("email",etEmail.text.toString())
            val intent=Intent(this,ListaPeliculasActivity::class.java)
            startActivity(intent)
        }
        }


    }
    private fun validarEmail(email: String): Boolean { //Metodo que comprueba si el email es correcto
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }


