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
import es.regueirorodriguezignacioproyectopmdm.databinding.ActivitySegundaBinding
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
         /*   if(binding.tiNombre.text.toString().trim() == "" || binding.tiApellido.text.toString().trim=""
                || binding.tiEmail.text.toString().trim="" || binding.tiContraseA.text.toString().trim=""
                || binding.tiRepiteContraseA.text.toString().trim=""){
                Toast.makeText(this,"Completa los campos",Toast.LENGTH_SHORT).show()
            }
            else if (pattern.matcher(binding.tiEmail.text.toString().trim().matches()==false)){
                Toast.makeText(this,"Email no válido",Toast.LENGTH_SHORT).show()
            }
            else if (binding.tiContraseA.text.toString().trim().length()>8 || binding.tiContraseA.text.toString().trim()< 5){
                Toast.makeText(this,"La contraseña debe tener entre 5 y 8 caracteres",Toast.LENGTH_SHORT).show()
            }
            else{
            val sharedPrefs = getSharedPreferences(
            "moviespreference", Context.MODE_PRIVATE)
            var editor=sharedPrefs.edit()
            editor.putString("email",etEmail.text.toString())
            val intent=Intent(this,ListaPeliculasActivity::class.java)
            startActivity(intent)
        }*/
        }


    }
    private fun validarEmail(email: String): Boolean { //Metodo que comprueba si el email es correcto
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
//Metodo que comprueba si el email es correcto y las contraseñas son validas y coinciden
    }


