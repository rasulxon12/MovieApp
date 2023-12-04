package uz.akra.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.akra.movieapp.databinding.ActivityShowAboutMovieBinding
import uz.akra.movieapp.models.Movie

class ShowAboutMovie : AppCompatActivity() {
    private val binding by lazy { ActivityShowAboutMovieBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val movie:Movie = intent.getSerializableExtra("keyMovie") as Movie
        binding.apply {
                movName.text = movie.name
                movAuthor.text = movie.author
                movAbout.text = movie.about
                movDate.text = movie.date
        }

        

    }
}