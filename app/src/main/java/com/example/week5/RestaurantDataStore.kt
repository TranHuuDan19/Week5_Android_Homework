package com.example.week5

import android.util.Log

object RestaurantDataStore{
    private val favoriteRestaurantList = mutableListOf<Restaurant>()
    private val defaultRestaurantList = listOf<Restaurant>(
            Restaurant(1,"Du Miên Garden Cage - Phan Văn Trị","7 Phan Văn Trị, P. 10","https://images.foody.vn/res/g4/33760/prof/s180x180/foody-mobile-du-mien-garden-mb-jp-309-635785114907746480.jpg",false),
            Restaurant(2,"Country House Cafe","18C Phan Văn Trị, P. 10","https://images.foody.vn/res/g1/978/prof/s180x180/foody-mobile-countryhouse-jpg-246-635683259648435945.jpg",false),
            Restaurant(3,"Hẻm Spaghetti - Nguyễn Oanh","212/22 Nguyễn Oanh, P. 17","https://images.foody.vn/res/g9/82801/prof/s180x180/foody-upload-api-foody-mobile-gi4-jpg-181001160804.jpg",false),
            Restaurant(4,"Lava Coffee - Quang Trung","61 Quang Trung, P. 10","https://images.foody.vn/res/g15/149154/prof/s180x180/foody-upload-api-foody-mobile-4-190111100956.jpg",false),
            Restaurant(5,"Mì Cay Naga - 224 Phạm Văn Đồng", "224 Phạm Văn Đồng, P.1 ", "https://images.foody.vn/res/g20/194867/prof/s180x180/foody-mobile-9zbk996o-jpg-112-636143635496125338.jpg",false),
            Restaurant(6,"City House Cafe - Sân Vườn Lãng Mạn","21 Huỳnh Khương An, P. 5","https://images.foody.vn/res/g3/25656/prof/s180x180/foody-mobile-city-house-jpg-354-636133373358973749.jpg",false),
            Restaurant(7,"Nhi Nhi Quán - Đặc Sản Phan Rang","125/48 Lê Đức Thọ, P. 17", "https://images.foody.vn/res/g7/66844/prof/s180x180/foody-mobile-bpzy3ni3-jpg-841-636143721820688231.jpg",false),
            Restaurant(8,"Yuri Yuri - Ẩm Thực Hàn Quốc", "358 Nguyễn Văn Nghi, P. 7","https://images.foody.vn/res/g4/33645/prof/s180x180/foody-mobile-bayef6n3-jpg-308-636023635570133301.jpg",false),
            Restaurant(9,"Trà Sữa Gong Cha - 貢茶 - Phan Văn Trị","595 Phan Văn Trị, P. 5","https://images.foody.vn/res/g26/252442/prof/s180x180/foody-mobile-12-jpg-323-636148043123028599.jpg",false),
            Restaurant(10,"Oasis Cafe","26/14 Phạm Văn Đồng, P. 3","https://images.foody.vn/res/g2/12513/prof/s180x180/foody-mobile-oasis-cafe-tp-hcm.jpg",false),
            Restaurant(11,"Buzza Pizza - Emart Gò Vấp","Tầng Trệt Emart Gò Vấp - 366 Phan Văn Trị, P. 5","https://images.foody.vn/res/g20/199622/prof/s180x180/201652411519-mobile-foody-logo-2-640x400.jpg",false),
            Restaurant(12,"Dallas Cakes & Coffee - Quang Trung","6 Quang Trung, P. 10","https://images.foody.vn/res/g66/651063/prof/s180x180/foody-mobile-11090821_80492442289-251-636277684533992519.jpg",false),
            Restaurant(13,"Hot & Cold - Trà Sữa & Xiên Que - Quang Trung","804 Quang Trung","https://images.foody.vn/res/g7/60915/prof/s180x180/foody-upload-api-foody-mobile-1-190605180036.jpg",false),
            Restaurant(14,"Papaxốt - Quang Trung","458 Quang Trung","https://images.foody.vn/res/g12/112585/prof/s180x180/foody-upload-api-foody-mobile-7-190109171633.jpg",false),
            Restaurant(15,"SaiGon Chic Cafe","82 Đường Số 27, P. 6","https://images.foody.vn/res/g10/91979/prof/s180x180/foody-mobile-kjuxujry-jpg-982-635838930416211667.jpg",false),
            Restaurant(16,"Pizza Hut - Quang Trung","283 Quang Trung","https://images.foody.vn/res/g3/28883/prof/s180x180/foody-mobile-p-jpg-800-635757703358128351.jpg",false),
            Restaurant(17,"Bánh Mì Chảo & Món Ngon Hoa Việt - Quán Cô 3 Hậu","36 Đường Số 18, P. 8","https://images.foody.vn/res/g13/129725/prof/s180x180/foody-mobile-foody-quan-co-3-hau--960-635652896252263911.jpg",false),
            Restaurant(18,"Kichi Kichi Lẩu Băng Chuyền - Quang Trung","1 Quang Trung","https://images.foody.vn/res/g5/46668/prof/s180x180/foody-mobile-rfokfbsk-jpg-859-635796372049634356.jpg",false),
            Restaurant(19,"The Coffee House - Quang Trung","293 Quang Trung","https://images.foody.vn/res/g16/158187/prof/s180x180/foody-mobile-coffeehousequangtrun-822-635754530645782536.jpg",false),
            Restaurant(20,"Cánh Đồng Quán - Lẩu Nướng Tại Bàn","310/14 Dương Quảng Hàm, P. 5","https://images.foody.vn/res/g4/30102/prof/s180x180/foody-mobile-shwadjuj-jpg-413-636204369735412311.jpg",false)
    )
    fun toggleFavoriteRestaurant(restaurant: Restaurant):List<Restaurant>{
        if(restaurant.isFavorite){
            addFavoriteRestaurant(restaurant)
        } else {
            removeFavoriteRestaurant(restaurant)
        }
        return getRestaurantList(isFavoriteList = true)
    }
    fun removeFavoriteRestaurant(restaurant: Restaurant){
        if (favoriteRestaurantList.filter { it.name == restaurant.name }.size == 1){
            favoriteRestaurantList.removeAll { it.name == restaurant.name }
            return
        }
    }
    fun addFavoriteRestaurant(restaurant: Restaurant){
        if (favoriteRestaurantList.filter { it.name == restaurant.name }.size !=1){
            restaurant.isFavorite = true
            favoriteRestaurantList.add(restaurant.copy())
            return
        }
    }
    fun getRestaurantList(isFavoriteList:Boolean = false):List<Restaurant>{
        if(isFavoriteList){
            return favoriteRestaurantList
        }
        return defaultRestaurantList
    }
}