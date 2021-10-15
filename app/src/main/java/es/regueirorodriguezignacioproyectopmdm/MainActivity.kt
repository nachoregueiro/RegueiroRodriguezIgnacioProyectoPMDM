package es.regueirorodriguezignacioproyectopmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
        private lateinit var btEntrar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btEntrar=findViewById(R.id.btEntrar)

            btEntrar.setOnClickListener{
                val intent = Intent(this, SegundaActivity::class.java)
                startActivity(intent)
            }
    }


}