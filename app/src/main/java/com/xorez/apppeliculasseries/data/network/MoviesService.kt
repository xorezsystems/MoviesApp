package com.xorez.apppeliculasseries.data.network

import android.util.Log
import com.xorez.apppeliculasseries.core.RetrofitHelper
import com.xorez.apppeliculasseries.data.model.MoviesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MoviesService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getMoviesList(): MoviesModel {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(MoviesApiClient::class.java).getMoviesList()
            response.body()!!
        }
    }
}