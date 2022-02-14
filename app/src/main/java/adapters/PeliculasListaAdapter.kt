package adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import entities.Pelicula
import es.regueirorodriguezignacioproyectopmdm.Detalle_Pelicula_Activity
import es.regueirorodriguezignacioproyectopmdm.R

class PeliculasListaAdapter(val peliculas: List<Pelicula>?,val miActivity:Activity) : RecyclerView.Adapter<PeliculasListaAdapter.PeliculasViewHolder>() {


    //Método para inflar la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculasViewHolder(inflater)
    }

    //Devuelve el número de elementos
    override fun getItemCount(): Int {
        return peliculas!!.size
    }

    //Método para permitir pasar los datos al Activity
    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {

        //Muestra el número de elementos que van a aparecer
        val pelicula = peliculas?.get(position)
        try{
            Picasso.get().load(pelicula?.url).into(holder.ivFoto)
        }catch(e:Exception){
            e.printStackTrace()
        }

        holder.layoutItemPeliculas.setOnClickListener(){
            val intent = Intent(holder.itemView.context, Detalle_Pelicula_Activity::class.java)
            intent.putExtra("Pelicula",pelicula)
            holder.itemView.context.startActivity(intent)

        }
    }
    class PeliculasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivFoto =itemView.findViewById<ImageView>(R.id.iv_character)
        val layoutItemPeliculas=itemView.findViewById<ConstraintLayout>(R.id.layoutItemPeliculas)
    }
}