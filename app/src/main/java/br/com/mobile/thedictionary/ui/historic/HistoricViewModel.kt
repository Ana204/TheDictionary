package br.com.mobile.thedictionary.ui.historic

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mobile.thedictionary.model.FavoriteListModel
import br.com.mobile.thedictionary.model.HistoricListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoricViewModel @Inject constructor() : ViewModel() {

    var TAG = "Historic_view_model"
    private lateinit var historicList: ArrayList<HistoricListModel>
    var mutableListHistoric: MutableLiveData<ArrayList<HistoricListModel>> = MutableLiveData()

    fun addWordFavoritesList(): ArrayList<HistoricListModel>{
        historicList = ArrayList()

        historicList.add(HistoricListModel("Historic"))
        historicList.add(HistoricListModel("Marven"))
        historicList.add(HistoricListModel("Mobile"))

        Log.e(TAG, "addWordFavoritesList: $historicList")

        mutableListHistoric.postValue(historicList)

        return historicList
    }
}