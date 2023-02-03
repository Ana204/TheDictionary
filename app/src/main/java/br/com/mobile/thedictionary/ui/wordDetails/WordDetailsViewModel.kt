package br.com.mobile.thedictionary.ui.wordDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mobile.thedictionary.HiltApplication
import br.com.mobile.thedictionary.model.Phonetics
import br.com.mobile.thedictionary.model.WordDetailsModel
import br.com.mobile.thedictionary.network.RemoteDataSource

class WordDetailsViewModel : ViewModel() {

    val TAG = "View-Model"

    private val remoteDataSource: RemoteDataSource by lazy {
        RemoteDataSource(HiltApplication.apiService)
    }
    private val _data = MutableLiveData<WordDetailsModel>()
    val data: LiveData<WordDetailsModel>
        get() = _data

    fun wordDetails(){
        val word = Phonetics("hello")

       //val response = remoteDataSource.getWordDetails()

        //Log.e(TAG, "wordDetails: $response ")

    }
}
