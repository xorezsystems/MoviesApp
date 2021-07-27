package com.xorez.apppeliculasseries.ui.mainActivity

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xorez.apppeliculasseries.data.repository.Repository
import androidx.lifecycle.viewModelScope
import com.squareup.picasso.Picasso

import com.xorez.apppeliculasseries.data.model.MoviesModel
import com.xorez.apppeliculasseries.data.network.MoviesApiClient
import com.xorez.apppeliculasseries.data.network.MoviesService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = Repository()
    private val _movies: MutableLiveData<List<Any>> = MutableLiveData()
    val movies: LiveData<List<Any>> = _movies


    fun onGetMoviesData(){
        viewModelScope.launch {
            val result = repository.getMovies()
            //val result = service.getMoviesList()
            val moviesL=addMovies(result)
            _movies.postValue(moviesL)
            if (result != null) {
                Log.d("TAG", "Name:"+result.name)
                Log.d("TAG", "Name:"+result.items[0].toString())

            }else{

            }
        }
    }

    private fun addMovies(movies: MoviesModel): List<Any> {
        val moviesList= ArrayList<Any>()
        movies.items.forEach{movieItem ->
            moviesList.add(movieItem)
        }
        return moviesList.toList()

    }
}