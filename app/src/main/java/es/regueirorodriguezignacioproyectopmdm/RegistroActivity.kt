package es.regueirorodriguezignacioproyectopmdm

import Dao.retrofit.ClienteRetrofit
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
    private lateinit var  btAtrás : Button
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

            binding.btGuardarDatos.setOnClickListener{
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
        /*    val context = this
            val llamadaApi: Call<List<Pelicula>> =
                ClienteRetrofit.apiRetroFit.getPeliculas("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYxZjdhMmE2ODgxM2Q2ZTRlNDVmZWQ4MiIsImlhdCI6MTY0Mzk2NzUwNywiZXhwIjoxNjQ0MDUzOTA3fQ.vynx3nsnb8X204_zvPwUK7KVVBFM5E-yNv9iNz4_m04")


            llamadaApi.enqueue(object : Callback<List<Pelicula>> {
                override fun onResponse(
                    call: Call<List<Pelicula>>,
                    response: Response<List<Pelicula>>
                ) {

                    var respon = response.body()
                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
                    //actualizar el adapter
                    binding.rvPeliculasList.adapter = adapter

                }

                override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                    Log.d("Error", t.message.toString())
                }
            }*/





            }
   }




