package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.R

class PeliculasListaAdapter(val peliculas: List<Pelicula>, val context: Context) :
//(val personajes: List <Personaje> , val ativity: Activity)

    RecyclerView.Adapter<PeliculasListaAdapter.PeliculasViewHolder>() {
    // Este método se ocupa de INFLAR la vista (el item_country.xml)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val inflater =
            LayoutInflater.from(context).inflate(R.layout.activity_lista_peliculas, parent, false)
        return PeliculasViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }


    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val peliculas = peliculas.get(position)
        //holder.tvPeliculasNombre.text=peliculas.name
    }


    //Referencia el layout entero para establecer el evento de click
    //val layoutItem=itemView.findViewById<CardView>(R.id.layoutItem)


    //holder.tvNombre.setText(personaje.nombre)
    //holder.tvTitulo.setText(personaje.titulo)

    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            //val tvPeliculas=itemView.findViewById<View>(tvPeliculasNombre)
            //RETOMAR VIERNES
    }


}