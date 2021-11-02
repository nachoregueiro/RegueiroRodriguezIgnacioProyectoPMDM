package es.regueirorodriguezignacioproyectopmdm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    private lateinit var  btAtrás : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        btAtrás=findViewById(R.id.btAtrás)

        btAtrás.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
       /*
        val tvguardarDatos=findViewById<TextView>(R.id.etEmail)
        val etmail=findViewById<TextView>(R.id.etEmail)
        tvguardardatos.setOnClickListener{
            val SharedPrefs =getPreferences(Context.MODE_PRIVATE)
            var editor=sharedPrefs.edit()
            editor.putString("email",etEmail.text.ToString())
        */
        }

    }