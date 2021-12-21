package es.regueirorodriguezignacioproyectopmdm

import android.app.ActionBar
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
        val btGuardarDatos=findViewById<TextView>(R.id.etEmail)
        val etEmail=findViewById<TextView>(R.id.etEmail)

        binding.btGuardarDatos.setOnClickListener{
            onBackPressed()
        }


        val actionBar = actionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        binding.btAtrS.setOnClickListener(){
            onBackPressed()
            finish()
        }

        }
   /* fun guardarDatos(){
        val nombreR = binding.etNombre.text.toString()
        val contraseñaR = binding.etContraseA.text.toString()
        val sharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("NOMBRER",nombreR)
            putString("CONTRASEÑAR",contraseñaR)
        }.apply()
        Toast.makeText(this,"Registrado",Toast.LENGTH_SHORT).show()
    }*/

    }




