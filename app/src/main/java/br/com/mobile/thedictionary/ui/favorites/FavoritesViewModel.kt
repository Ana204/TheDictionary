package br.com.mobile.thedictionary.ui.favorites

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mobile.thedictionary.model.FavoriteListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor() : ViewModel() {

    var TAG = "FavoritesViewModel"
    private lateinit var favoritesList: ArrayList<FavoriteListModel>
    var mutableListFavorites: MutableLiveData<ArrayList<FavoriteListModel>> = MutableLiveData()

    fun addWordFavoritesList(): ArrayList<FavoriteListModel>{
        favoritesList = ArrayList<FavoriteListModel>()

        favoritesList.add(FavoriteListModel("Favorites"))
        favoritesList.add(FavoriteListModel("List"))
        favoritesList.add(FavoriteListModel("Success"))

        Log.e(TAG, "addWordFavoritesList: $favoritesList")

        mutableListFavorites.postValue(favoritesList)

        return favoritesList
    }
}