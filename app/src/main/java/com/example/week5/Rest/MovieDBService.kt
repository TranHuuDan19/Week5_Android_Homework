package com.example.week5.Rest

import com.example.week5.Movie.TopMovieResp
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBService {
    @GET("movie/now_playing")
    suspend fun listNowPlayMovies (@Query("language") language: String,@Query("page") page:Int //,@Query("api_key") api_key: String
    )
    @GET("movie/top_rated")
    suspend fun listTopRatedMovies(@Query("language") language: String, @Query("page") page: Int
    ): TopMovieResp
}