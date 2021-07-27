package com.xorez.apppeliculasseries.ui.mainActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xorez.apppeliculasseries.databinding.ActivityMainBinding
import com.xorez.apppeliculasseries.ui.MovieDetails.MovieDetailsActivity
import com.xorez.apppeliculasseries.ui.mainActivity.adapter.MoviesAdapter
import com.xorez.apppeliculasseries.utils.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createViewModel()
        setAdapter()
        setObservers()
        setListeners()

        

        mainViewModel.onGetMoviesData()

    }

    private fun setObservers() {
        mainViewModel.movies.observe(this, Observer {
            moviesAdapter.addMovies(it)
        })
    }

    private fun setAdapter() {
        moviesAdapter = MoviesAdapter(){movie ->
            val intent = Intent(this, MovieDetailsActivity::class.java)
                intent.putExtra("MOVIE_DETAILS", movie)
                //intent.putExtra("IMG_URL", movie.backdropPath)

            Log.d("TAG", movie.toString())
            startActivity(intent)
        }
        rvMoviesList.layoutManager = LinearLayoutManager(this)
        rvMoviesList.adapter = moviesAdapter
    }

    private fun createViewModel() {
        val viewModelProviderFactory = ViewModelProviderFactory()
        mainViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)
    }

    private fun setListeners() {
    }
}