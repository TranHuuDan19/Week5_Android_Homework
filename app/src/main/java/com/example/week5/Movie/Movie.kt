package com.example.week5.Movie

import com.google.gson.annotations.SerializedName

data class Result (

        val adult: Boolean? = null,
        @SerializedName("backdrop_Path")
        val backdropPath: String? = null,
        @SerializedName("genre_IDS:")
        val genreIDS: List<Long>? = null,
        val id: Long? = null,
        @SerializedName("original_Language")
        val originalLanguage: OriginalLanguage? = null,
        @SerializedName("original_Title")
        val originalTitle: String? = null,
        val overview: String? = null,
        val popularity: Double? = null,
        @SerializedName("poster_Path")
        val posterPath: String? = null,
        @SerializedName("release_Date")
        val releaseDate: String? = null,
        val title: String? = null,
        val video: Boolean? = null,
        @SerializedName("vote_Average")
        val voteAverage: Double? = null,
        @SerializedName("vote_Count")
        val voteCount: Long? = null
)

enum class OriginalLanguage {
    En,
    Ja,
    Ko,
    Ru
}