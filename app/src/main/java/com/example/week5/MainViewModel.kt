package com.example.week5

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week5.Rest.RestClient
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    fun getNowplaying(){
        viewModelScope.launch {
            val movieResp = RestClient.getInstance().API.listNowPlayMovies(language ="en-US",page =1)
            Log.e("TAG",movieResp.javaClass.toString())
        }
    }
    fun getToprated()
    {
        viewModelScope.launch {
            val toprateRest = RestClient.getInstance().API.listTopRatedMovies(language = "en-US",page = 1)
            Log.e("TopRated",toprateRest.results.toString())
        }
    }
}