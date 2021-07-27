package com.xorez.apppeliculasseries.ui.MovieDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.xorez.apppeliculasseries.R
import com.xorez.apppeliculasseries.data.model.Items
import com.xorez.apppeliculasseries.databinding.ActivityMainBinding
import com.xorez.apppeliculasseries.databinding.ActivityMovieDetailsBinding
import com.xorez.apppeliculasseries.ui.mainActivity.MainViewModel
import com.xorez.apppeliculasseries.utils.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.card_view_movies.view.*
import java.io.Serializable

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var movieDetailsViewModel: MovieDetailsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createViewModel()

        //Log.d("TAG", intent.getParcelableExtra<>("MOVIE_DETAILS").toString())
        val movie = intent.extras!!.getParcelable<Items>("MOVIE_DETAILS")
        Log.d("TAG", movie!!.toString())
        loadMovieDetails(movie!!)


        
        
        
    }

    private fun loadMovieDetails(movie: Items) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
            .fit()
            .error(R.drawable.empty_poster)
            .centerCrop()
            .into(imgDetBackgroud)
        lblDetTitle.text = movie.title
        lblReleaseDate.text = getString(R.string.release_date, movie.releaseDate)
        lblOverview.text = getString(R.string.overview, movie.overview)
        lblForAdults.text = if (movie.adult) "Adults Only" else "For All"
        lblVoteAverage.text = getString(R.string.vote_average, movie.voteAverage.toString())
        lblPopularity.text = getString(R.string.popularity, movie.popularity.toString())
        lblLang.text = getString(R.string.original_lang, movie.originalLanguage.uppercase())


    }


    private fun createViewModel() {
        val viewModelProviderFactory = ViewModelProviderFactory()
        movieDetailsViewModel = ViewModelProvider(this, viewModelProviderFactory).get(MovieDetailsViewModel::class.java)
    }


}