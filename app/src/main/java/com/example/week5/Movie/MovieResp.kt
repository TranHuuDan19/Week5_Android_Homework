package com.example.week5.Movie

import android.graphics.Movie

data class MovieResp (
        val dates: Dates? = null,
        val page: Long? = null,
        val results: List<Movie>? = null,
        val totalPages: Long? = null,
        val totalResults: Long? = null
)
data class TopMovieResp (
        val page: Long? = null,
        val results: List<Movie>? = null,
        val totalPages: Long? = null,
        val totalResults: Long? = null
)

data class Dates (
        val maximum: String? = null,
        val minimum: String? = null
)
