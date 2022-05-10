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
    lateinit var etUsuario: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_RegueiroRodriguezIgnacioProyectoPMDM)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        etUsuario = findViewById(R.id.etUsuario)
        val context = this

        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val Token: String? = sharedPreferences.getString("TOKEN", null)
        val email = sharedPreferences.getString("EMAIL", null)
        etUsuario.setText(email)



        //Comprobamos si el token está vacio
        if (Token == null){
            binding.btEntrar.setOnClickListener() {
                acceder()
            }
        }else{
            val intent = Intent(context, ListaPeliculasActivity::class.java)
            startActivity(intent)
            finish()
        }


        //Para entrar en la lista recibe la función
        binding.btEntrar.setOnClickListener {
            acceder()
        }
        binding.btRegistro.setOnClickListener {
            val intent = Intent(this@MainActivity, RegistroActivity::class.java)
            startActivity(intent)
        }

    }

    //Función para comprobar si se puede registrar el usuario o no
    fun acceder() {
        val context = this
        var usuario = binding.etUsuario.text.toString()
        var contraseña = binding.etContraseA.text.toString()
        val u = Usuario(usuario, contraseña)
        val llamadaApi: Call<Token> = ClienteRetrofit.apiRetroFit.login(u)

        llamadaApi.enqueue(object : Callback<Token> {
            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.d("respuesta: onFailure", t.toString())
            }
            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                Log.d("respuesta: onResponse", response.toString())

                if (response.code() > 299 || response.code() < 200) {
                    Toast.makeText(context, "Error,no se pudo entrar", Toast.LENGTH_SHORT).show()
                } else {
                    val token: String? = response.body()?.token
                    val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.apply() {
                        putString("TOKEN", token)
                    }.apply()
                    val intent = Intent(context, ListaPeliculasActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })
    }

}


