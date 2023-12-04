package uz.akra.movieapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import uz.akra.movieapp.databinding.ActivityMainBinding
import uz.akra.movieapp.models.Movie
import uz.akra.movieapp.utils.MovieAdapter
import uz.akra.movieapp.utils.MySharedPreference
import uz.akra.movieapp.databinding.ItemRecvBinding as ItemRecvBinding1

class MainActivity : AppCompatActivity(), MovieAdapter.RvAction {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var movieAdapter: MovieAdapter
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddMovie::class.java))
        }




    }

    override fun onResume() {
        super.onResume()

        MySharedPreference.init(this)
        movieAdapter = MovieAdapter(this, this, MySharedPreference.list)
        binding.recView.adapter = movieAdapter

    }

    override fun deleteMovie(movie: Movie, position: Int) {
        val list = MySharedPreference.list
        list.remove(movie)
        MySharedPreference.list = list
        movieAdapter.list.remove(movie)
        movieAdapter.notifyItemRemoved(position)
    }

    override fun editMovie(movie: Movie, position: Int) {
        val intent = Intent(this, EditMovie::class.java)
        intent.putExtra("keyPosition", position)
        startActivity(intent)
    }

    override fun itemClick(movie: Movie) {
        val intent = Intent(this, ShowAboutMovie::class.java)
        intent.putExtra("keyMovie", movie)
        startActivity(intent)
    }
}