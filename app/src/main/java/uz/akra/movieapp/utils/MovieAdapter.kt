package uz.akra.movieapp.utils

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import uz.akra.movieapp.AddMovie
import uz.akra.movieapp.EditMovie
import uz.akra.movieapp.databinding.ActivityMainBinding
import uz.akra.movieapp.databinding.ItemRecvBinding
import uz.akra.movieapp.models.Movie

class MovieAdapter (val context: Context,val rvAction: RvAction, var list: ArrayList<Movie> = ArrayList()) :
    RecyclerView.Adapter<MovieAdapter.Vh>() {
    inner class Vh(private val itemRvBinding: ItemRecvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

        fun onBind(movie: Movie, position: Int) {
            itemRvBinding.tvName.text = movie.name
            itemRvBinding.tvAuthor.text = movie.author
            itemRvBinding.tvDate.text = movie.date
            itemRvBinding.root.setOnClickListener {
                rvAction.itemClick(movie)
            }
            itemRvBinding.btnDelete.setOnClickListener {
                rvAction.deleteMovie(movie, position)
            }
            itemRvBinding.btnEdt.setOnClickListener {
                rvAction.editMovie(movie, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRecvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    interface RvAction {
        fun deleteMovie(movie: Movie, position: Int)
        fun editMovie(movie: Movie, position: Int)
        fun itemClick(movie: Movie)
    }

}