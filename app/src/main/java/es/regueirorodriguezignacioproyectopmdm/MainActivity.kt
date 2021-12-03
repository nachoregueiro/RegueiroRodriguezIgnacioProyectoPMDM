package es.regueirorodriguezignacioproyectopmdm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()


        binding.btEntrar.setOnClickListener {

            val nombreL = binding.etNombre.text.toString()
            val contraseñaL = binding.etContraseA.text.toString()
            val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

            val editor = sharedPreferences.edit()
            editor.apply(){
                putString("NOMBREL",nombreL)
                putString("CONTRASEÑAL",contraseñaL)
                            }.apply()

            loadData()


        }

        binding.btRegistro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

    }

            fun loadData(){
                val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                val nombreL = sharedPreferences.getString("NOMBREL",null)
                val contraseñaL = sharedPreferences.getString("CONTRASEÑAL",null)
                val nombreR = sharedPreferences.getString("NOMBRER",null)
                val contraseñáR = sharedPreferences.getString("CONTRASEÑAR",null)

                if ( nombreL == nombreR && contraseñaL == contraseñáR   ){
                    val intent = Intent(this, ListaPeliculasActivity::class.java)
                    startActivity(intent)
                } else  {
                    Toast.makeText(this,"Datos Erroneos", Toast.LENGTH_SHORT).show()
                }

            }





}