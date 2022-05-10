package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
import Dao.retrofit.Usuario
import Dao.retrofit.entities.Token
import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityRegistroBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var btAtrás: Button
    private lateinit var binding: ActivityRegistroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        etEmail = findViewById(R.id.etEmail)
        setTitle("Registro")

        //Botón que comprueba el registro
        binding.btGuardarDatos.setOnClickListener {
            val context = this
            val loginCall = ClienteRetrofit.apiRetroFit.signup(Usuario(binding.etEmail.text.toString(), binding.etContraseA.text.toString()))
            loginCall.enqueue(object : Callback<Unit> {
                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("respuesta: onFailure", t.toString())
                }
                @SuppressLint("commitPrefEdits")
                override  fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    Log.d("respuesta: onResponse", response.toString())
                    if (response.code() > 299 || response.code() < 200) {
                        // Muestro alerta: no se ha podido crear el usuario
                        Toast.makeText(
                            context,
                            "No se ha podido crear el usuario",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        val intent =
                            Intent(this@RegistroActivity, MainActivity::class.java)
                        Toast.makeText(context, "Usuario creado", Toast.LENGTH_SHORT)
                            .show()
                        startActivity(intent)
                    }
                }
            })
            pasarNombre()
        }
    }
    private fun pasarNombre() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply() {
            putString("EMAIL", etEmail.text.toString())
        }.apply()
    }
}