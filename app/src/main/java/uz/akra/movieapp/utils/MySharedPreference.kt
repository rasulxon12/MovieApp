package uz.akra.movieapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.akra.movieapp.models.Movie

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor)->Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var list:ArrayList<Movie>
        get() = gsonToList(preferences.getString("movieList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("movieList", listToGson(value))
        }

    private fun gsonToList(str:String):ArrayList<Movie>{
        val list = ArrayList<Movie>()
        val type = object : TypeToken<ArrayList<Movie>>(){}.type
        list.addAll(Gson().fromJson(str,type))

        return list

    }

    private fun listToGson(list:ArrayList<Movie>):String{
        return Gson().toJson(list)
    }


}