package com.xorez.apppeliculasseries.data.repository

import com.xorez.apppeliculasseries.data.model.MoviesModel
import com.xorez.apppeliculasseries.data.network.MoviesService
import io.reactivex.Flowable

class Repository {
    private val api = MoviesService()

    suspend fun getMovies(): MoviesModel = api.getMoviesList()


}