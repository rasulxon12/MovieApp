package uz.akra.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.akra.movieapp.databinding.ActivityEditMovieBinding
import uz.akra.movieapp.models.Movie
import uz.akra.movieapp.utils.MySharedPreference

class EditMovie : AppCompatActivity() {
    private val binding by lazy { ActivityEditMovieBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        MySharedPreference.init(this)
        val list = MySharedPreference.list

        val position = intent.getIntExtra("keyPosition", 0)
        val myMovie = list[position]
        binding.apply {
            edtName.setText(myMovie.name)
            edtAuthor.setText(myMovie.author)
            edtAbout.setText(myMovie.about)
            edtDate.setText(myMovie.date)
        }

        binding.btnEdit.setOnClickListener {

            myMovie.name = binding.edtName.text.toString()
            myMovie.author = binding.edtAuthor.text.toString()
            myMovie.about = binding.edtAbout.text.toString()
            myMovie.date = binding.edtDate.text.toString()

            list[position] = myMovie
            MySharedPreference.list = list
            finish()
        }
    }
}