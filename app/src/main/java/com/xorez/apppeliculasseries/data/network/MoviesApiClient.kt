package com.xorez.apppeliculasseries.data.network

import com.xorez.apppeliculasseries.data.model.MoviesModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApiClient {

    @GET("list/1?api_key=c381ea1b1385164d24bd61c6395f1ec4&language=en-US")
    suspend fun getMoviesList(): Response<MoviesModel>

    @GET("list/1?api_key=c381ea1b1385164d24bd61c6395f1ec4&language=en-US")
    fun getRaw(): Call<ResponseBody>
}