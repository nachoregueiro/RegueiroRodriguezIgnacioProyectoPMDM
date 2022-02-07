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
    private lateinit var btAtrás: Button
    private lateinit var binding: ActivityRegistroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("Registro")


        val actionBar = actionBar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }

        binding.btGuardarDatos.setOnClickListener {
            /*   val pattern=Patterns.EMAIL_ADDRESS
            if(binding.tiUsuario.editText.toString().trim()==""||binding.tiApellido.editText.toString().trim()==""||
                binding.tiEmail.editText.toString().trim()==""||binding.tiContraseA.editText.toString().trim()==""
                ||binding.tiRepiteContraseA.editText.toString().trim()==""){
                Toast.makeText(this,"Completa todos los campos",Toast.LENGTH_SHORT).show()
            }else if(pattern.matcher(binding.tiEmail.editText.toString().trim()).matches()==false){
                Toast.makeText(this,"Email no válido",Toast.LENGTH_SHORT).show()
            }
            else{
                var sharedPref=getSharedPreferences("Preferencias de Usuario",Context.MODE_PRIVATE)
                var editor=sharedPref.edit()
                editor.putString("email",binding.tiEmail.editText.toString().trim())
                editor.putString("contraseña",binding.tiContraseA.editText.toString().trim()).commit()
                onBackPressed()
                *//*       editor.apply(){
                     putString("NOMBRER",nombreR)
                     putString("CONTRASEÑAR",contraseñaR)
                 }.apply()*/
        }


        val context = this
        val loginCall = ClienteRetrofit.apiRetroFit.signup(Usuario("gga@gmail.com", "12345"))


     //   val token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0NDIyMTM4MCwiZXhwIjoxNjQ0MzA3NzgwfQ.yMrjSqhiTbg6f85hExusc1X0mpxl1dgmlSyBh1bJfVg";


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
                    Toast.makeText(context, "Se ha creado el usuario1", Toast.LENGTH_SHORT)
                        .show()
                }
            }


        })


    }
}