package com.xorez.apppeliculasseries.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xorez.apppeliculasseries.ui.MovieDetails.MovieDetailsViewModel
import com.xorez.apppeliculasseries.ui.mainActivity.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelProviderFactory (

        ): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel() as T
        }
        if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)){
            return MovieDetailsViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}