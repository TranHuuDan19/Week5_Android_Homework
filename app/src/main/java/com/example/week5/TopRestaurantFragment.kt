package com.example.week5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TopRestaurantFragment(val topRestaurantAdapter: TopRestaurantAdapter):Fragment() {
    private lateinit var rcList : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top_restaurant,container,false)
        rcList = view.findViewById<RecyclerView>(R.id.rcTop)
        rcList.layoutManager = LinearLayoutManager(this.context)
        rcList.adapter = topRestaurantAdapter
        return view
    }
    fun changeLayout(viewType:Int){
        when(viewType){
            LINEAR_LAYOUT->{
                rcList.layoutManager = LinearLayoutManager(this.context)
                topRestaurantAdapter.changeViewType(LINEAR_LAYOUT)
            }
            GRID_LAYOUT->{
                rcList.layoutManager = GridLayoutManager(this.context,2)
                topRestaurantAdapter.changeViewType(GRID_LAYOUT)
            }
            else ->{
                print("error")
            }
        }
    }
}