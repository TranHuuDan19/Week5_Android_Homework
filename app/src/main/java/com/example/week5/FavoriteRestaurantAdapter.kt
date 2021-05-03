package com.example.week5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FavoriteRestaurantAdapter(val ctx:Context):ListAdapter<Restaurant,FavoriteRestaurantAdapter.ViewHolder>(FavoriteRestaurantDiffUtilCallback()) {
    private var currentLayout = LINEAR_LAYOUT

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View
        if (viewType == LINEAR_LAYOUT){
            view = LayoutInflater.from(ctx).inflate(R.layout.item_restaurant_linear,parent,false)
        } else {
            view = LayoutInflater.from(ctx).inflate(R.layout.item_restaurant_grid,parent,false)
        }
        return FavoriteRestaurantAdapter.ViewHolder(view)
    }
    override fun getItemViewType(position: Int): Int {
        if (currentLayout == GRID_LAYOUT){
            return GRID_LAYOUT
        }
        return LINEAR_LAYOUT
    }
    override fun onBindViewHolder(holder: FavoriteRestaurantAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    fun changeViewType(viewType: Int){
        currentLayout = viewType
    }
    class ViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val itemName : TextView = itemView.findViewById(R.id.tv_name)
        val itemAddress : TextView = itemView.findViewById(R.id.tv_address)
        val itemPicture : ImageView = itemView.findViewById(R.id.iv_image)
        val itemFavorite : AppCompatButton = itemView.findViewById(R.id.favBtn)
        fun bind(restaurant: Restaurant){
            itemName.text = restaurant.name
            itemAddress.text = restaurant.address
            Glide.with(itemView.context).load(restaurant.picturePath).into(itemPicture)
            itemFavorite.setBackgroundResource(if(restaurant.isFavorite==true) R.drawable.ic_baseline_favorite_red_24 else R.drawable.ic_baseline_favorite_shadow_24)
        }
    }
    class FavoriteRestaurantDiffUtilCallback : DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }
}