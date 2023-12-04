package uz.akra.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.akra.movieapp.databinding.ActivityAddMovieBinding
import uz.akra.movieapp.models.Movie
import uz.akra.movieapp.utils.MySharedPreference

class AddMovie : AppCompatActivity() {
    private val binding by lazy { ActivityAddMovieBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        MySharedPreference.init(this)
        binding.btnSave.setOnClickListener{
            val list = MySharedPreference.list
            list.add(Movie(binding.edtName.text.toString().capitalize(),binding.edtAuthor.text.toString().capitalize(),binding.edtAbout.text.toString().capitalize(),binding.edtDate.text.toString().capitalize()))
            MySharedPreference.list = list
            finish()
        }
    }
}