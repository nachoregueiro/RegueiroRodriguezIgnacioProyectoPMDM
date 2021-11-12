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
    // Este método se ocupa de INFLAR la vista (el item_pelicula.xml)

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

        }


    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre =itemView.findViewById<TextView>(R.id.tvPersonaje)
        val ivFoto =itemView.findViewById<ImageView>(R.id.iv_character)

    }


}