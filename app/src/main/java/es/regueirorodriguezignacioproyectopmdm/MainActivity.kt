package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.Api
import Dao.retrofit.ClienteRetrofit
import Dao.retrofit.Usuario
import Dao.retrofit.entities.Token
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_RegueiroRodriguezIgnacioProyectoPMDM)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
            else{
            val intent = Intent(this, ListaPeliculasActivity::class.java)
            startActivity(intent)
        }*/

        }

        binding.btRegistro.setOnClickListener {
            val intent = Intent(this@MainActivity, RegistroActivity::class.java)
            startActivity(intent)
        }
/*

        usuario=findViewById(R.id.tiUsuario)
        contrasenha=findViewById(R.id.etContraseña)
        botonEntrar=findViewById(R.id.btEntrar)

*/

        //HACE LO DE RETROFIT SE SUPONE(!) ESTAMOS EN ELLO
        //falta sacar el texto de los editText
        val context = this
        val loginCall = ClienteRetrofit.apiRetroFit.login(Usuario("gga@gmail.com", "12345"))

        loginCall.enqueue(object : Callback<Token> {
            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())

            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                Log.d("respuesta: onResponse", response.toString())

                if (response.code() > 299 || response.code() < 200) {
                    // Muestro alerta: no se ha podido crear el usuario
                    Toast.makeText(context, "No se ha podido crear el usuario", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val token = response.body()?.token
                    Log.d("respuesta: token:", token.orEmpty())

                    // TODO: Muestro mensaje de usuario creado correctamente.

                    // TODO: Guardo en sharedPreferences el token

                    // TODO: Inicio nueva activity
                }
            }
        })
    }
}







