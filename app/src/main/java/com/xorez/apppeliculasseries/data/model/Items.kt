package com.xorez.apppeliculasseries.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Items(
    @SerializedName("adult") var adult : Boolean,
    @SerializedName("backdrop_path") var backdropPath : String,
    @SerializedName("genre_ids") var genreIds : List<Int>,
    @SerializedName("id") var id : Int,
    @SerializedName("media_type") var mediaType : String,
    @SerializedName("original_language") var originalLanguage : String,
    @SerializedName("original_title") var originalTitle : String,
    @SerializedName("overview") var overview : String,
    @SerializedName("popularity") var popularity : Double,
    @SerializedName("poster_path") var posterPath : String,
    @SerializedName("release_date") var releaseDate : String,
    @SerializedName("title") var title : String,
    @SerializedName("video") var video : Boolean,
    @SerializedName("vote_average") var voteAverage : Double,
    @SerializedName("vote_count") var voteCount : Int
): Parcelable
