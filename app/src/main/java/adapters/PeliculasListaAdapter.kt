package adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.R

class PeliculasListaAdapter(val peliculas: List<Pelicula>,val miActivity:Activity) :
//(val personajes: List <Personaje> , val ativity: Activity)

    RecyclerView.Adapter<PeliculasListaAdapter.PeliculasViewHolder>() {
    // Este método se ocupa de INFLAR la vista (el item_country.xml)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)

        return PeliculasViewHolder(inflater)

    }

    override fun getItemCount(): Int {
        return peliculas.size
    }



    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas.get(position)

       // holder.tvPersonaje.setText(pelicula.titulo)

        /*Picasso.get().
        load(pelicula.url)
            .into(holder.iv_character)*/
    }


    //Referencia el layout entero para establecer el evento de click
    //val layoutItem=itemView.findViewById<CardView>(R.id.layoutItem)


    //holder.tvNombre.setText(personaje.nombre)
    //holder.tvTitulo.setText(personaje.titulo)

    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre =itemView.findViewById<TextView>(R.id.tvPersonaje)
//        val tvTitulo =itemView.findViewById<TextView>(R.id.)
        val ivFoto =itemView.findViewById<ImageView>(R.id.iv_character)

    }


}