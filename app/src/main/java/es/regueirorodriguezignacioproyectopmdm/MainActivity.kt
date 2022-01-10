package es.regueirorodriguezignacioproyectopmdm

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_RegueiroRodriguezIgnacioProyectoPMDM)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*

        usuario=findViewById(R.id.tiUsuario)
        contrasenha=findViewById(R.id.etContraseña)
        botonEntrar=findViewById(R.id.btEntrar)

*/



        binding.btEntrar.setOnClickListener {
         /*   val sharedPref:SharedPreferences=getSharedPreferences("Preferencias de Usuario",MODE_PRIVATE)
          *//*  textoUsuario=usuario.text.toString()
            textoContrasenha=contrasenha.text.toString()*//*
            val usuario=sharedPref.getString("usuario","Preferencias de Usuario")
            val contrasenha=sharedPref.getString("contraseña","Preferencias de Usuario")
            if(contrasenha!=binding.tiContraseA.editText.toString().trim()){
                Toast.makeText(this,"Usuario incorrecto",Toast.LENGTH_SHORT).show()
            }
            else if(usuario!=binding.tiUsuario.editText.toString().trim()){
                Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show()
            }
            else{*/
            val intent = Intent(this, ListaPeliculasActivity::class.java)
            startActivity(intent)
        }

        binding.btRegistro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

    }


    }





