package com.xorez.apppeliculasseries.ui.mainActivity.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.xorez.apppeliculasseries.R
import com.xorez.apppeliculasseries.data.model.Items
import kotlinx.android.synthetic.main.card_view_movies.view.*

class MoviesAdapter(private val clickListener: (movies: Items) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var moviesList = ArrayList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.card_view_movies,
            parent, false
        )

        return MoviesViewHolder(view, clickListener)
    }

    fun addMovies(newMovies: List<Any>) {
        moviesList.clear()
        moviesList.addAll(newMovies)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(generalHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = generalHolder as MoviesViewHolder
        holder.bind(moviesList[position] as Items)

    }

    override fun getItemCount(): Int = moviesList.size


    inner class MoviesViewHolder(itemView: View, val clickListener: (movies: Items)-> Unit): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Items){
            itemView.lbl_movie_title.text = movie.title
            itemView.lbl_release_date.text = itemView.context.getString(R.string.release_date, movie.releaseDate)
            itemView.lbl_vote_average.text = itemView.context.getString(R.string.vote_average, movie.voteAverage.toString())
            itemView.lbl_popularity.text = itemView.context.getString(R.string.popularity, movie.popularity.toString())
            itemView.setOnClickListener { clickListener(movie) }
            Log.d("TAG", "URL= https://image.tmdb.org/t/p/w500${movie.posterPath}")

            if (movie.posterPath != null) {
                Picasso.get()
                    .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                    .fit()
                    .error(R.drawable.empty_poster)
                    .centerCrop()
                    .into(itemView.imgMoviePoster)
            }
        }
    }
}