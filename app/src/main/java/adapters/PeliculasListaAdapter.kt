package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.regueirorodriguezignacioproyectopmdm.R

class PeliculasListaAdapter (val Countries: List<Country> , val context : Context) :
    //(val personajes: List <Personaje> , val ativity: Activity)

        RecyclerView.Adapter<PeliculasListaAdapter.Country>() {

        // Este método se ocupa de INFLAR la vista (el item_country.xml)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Country {
            val inflater =LayoutInflater.from(context).inflate(R.layout.activity_lista_peliculas,parent,false)

            return Country(inflater)
        }

        override fun onBindViewHolder(holder: Country, position: Int) {
            TODO("Not yet implemented")
        }

        //Referencia el layout entero para establecer el evento de click
        //val layoutItem=itemView.findViewById<CardView>(R.id.layoutItem)

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
        //holder.tvNombre.setText(personaje.nombre)
        //holder.tvTitulo.setText(personaje.titulo)

        class Country (view: View) :RecyclerView.ViewHolder(view){

        }



    }