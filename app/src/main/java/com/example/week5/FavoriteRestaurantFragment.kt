package com.example.week5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class FavoriteRestaurantFragment(val favoriteRestaurantAdapter: FavoriteRestaurantAdapter):Fragment(){
    private lateinit var rcList : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite_restaurant,container,false)
        rcList = view.findViewById<RecyclerView>(R.id.rcFavorite)
        rcList.layoutManager = LinearLayoutManager(this.context)
        rcList.adapter = favoriteRestaurantAdapter
        return view
    }
    fun changeLayout(viewType:Int){
        when(viewType){
            LINEAR_LAYOUT->{
                rcList.layoutManager = LinearLayoutManager(this.context)
                favoriteRestaurantAdapter.changeViewType(LINEAR_LAYOUT)
            }
            GRID_LAYOUT->{
                rcList.layoutManager = GridLayoutManager(this.context,2)
                favoriteRestaurantAdapter.changeViewType(GRID_LAYOUT)
            }
            else ->{
                print("error")
            }
        }
    }
}