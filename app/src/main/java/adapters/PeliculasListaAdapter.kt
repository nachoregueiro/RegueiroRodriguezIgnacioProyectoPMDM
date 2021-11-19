package adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.R
import es.regueirorodriguezignacioproyectopmdm.detalle_Pelicula_Activity

class PeliculasListaAdapter(val peliculas: List<Pelicula>,val miActivity:Activity) : RecyclerView.Adapter<PeliculasListaAdapter.PeliculasViewHolder>() {
    // Este método se ocupa de INFLAR la vista (el item_pelicula.xml)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculasViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    //este método sirve para permitir pasar los datos al Activity
    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        //esto que muestre el número de elementos que va a aparecer
        val pelicula = peliculas.get(position)
        holder.tvNombre.setText(pelicula.titulo)
        Picasso.get().load(pelicula.url).into(holder.ivFoto)

        holder.layoutItemPeliculas.setOnClickListener(){
            val intent= Intent(holder.itemView.rootView.context,detalle_Pelicula_Activity::class.java)
            holder.itemView.rootView.context.startActivity(intent)
        }

    }



    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre =itemView.findViewById<TextView>(R.id.tvPersonaje)
        val ivFoto =itemView.findViewById<ImageView>(R.id.iv_character)
        val layoutItemPeliculas=itemView.findViewById<ConstraintLayout>(R.id.layoutItemPeliculas)
    }


}