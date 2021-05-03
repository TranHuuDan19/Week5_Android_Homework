package com.example.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week5.databinding.ActivityRestaurantListBinding

class RestaurantListActivity : AppCompatActivity() {
    private var currentLayout : Int = LINEAR_LAYOUT
    private lateinit var topFragment : TopRestaurantFragment
    private lateinit var favoriteFragment: FavoriteRestaurantFragment
    private lateinit var topRestaurantAdapter: TopRestaurantAdapter
    private lateinit var favoriteRestaurantAdapter: FavoriteRestaurantAdapter
    private lateinit var binding: ActivityRestaurantListBinding
    private lateinit var menu: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)
        //
        topRestaurantAdapter = TopRestaurantAdapter(this)
        topRestaurantAdapter.submitList(RestaurantDataStore.getRestaurantList())
        topFragment = TopRestaurantFragment(topRestaurantAdapter)
        //
        favoriteRestaurantAdapter = FavoriteRestaurantAdapter(this)
        favoriteRestaurantAdapter.submitList(RestaurantDataStore.getRestaurantList(isFavoriteList = true))
        favoriteFragment = FavoriteRestaurantFragment(favoriteRestaurantAdapter)
        setCurrentFragment(topFragment)

        topRestaurantAdapter.listener = object : TopRestaurantAdapter.TopRestaurantAdapterListener {
            override fun onClickItem(restaurant: Restaurant) {
                favoriteRestaurantAdapter.submitList(RestaurantDataStore.toggleFavoriteRestaurant(restaurant))
            }
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_list)
        binding.navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_list -> setCurrentFragment(topFragment)
                R.id.navigation_favorite -> setCurrentFragment(favoriteFragment)
            }
            true
        }
        //
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_switch, menu)
        this.menu = menu!!
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sw_layout -> {
                val icon = if (currentLayout == LINEAR_LAYOUT) R.drawable.ic_baseline_grid_off_24 else R.drawable.ic_baseline_grid_on_24
                if (currentLayout == LINEAR_LAYOUT) {
                    favoriteFragment.changeLayout(GRID_LAYOUT)
                    topFragment.changeLayout(GRID_LAYOUT)
                    menu[0].icon =
                        ContextCompat.getDrawable(this, icon)
                    currentLayout = GRID_LAYOUT
                } else {
                    favoriteFragment.changeLayout(LINEAR_LAYOUT)
                    topFragment.changeLayout(LINEAR_LAYOUT)
                    menu[0].icon =
                        ContextCompat.getDrawable(this, icon)
                    currentLayout = LINEAR_LAYOUT
                }
            }
        }
        return true
    }
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }
}