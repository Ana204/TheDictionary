package br.com.mobile.thedictionary.ui.wordList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.mobile.thedictionary.model.WordListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordListViewModel @Inject constructor() : ViewModel() {

    var TAG = "WordListViewModel"
    private lateinit var wordList: ArrayList<WordListModel>
    var mutableListWord: MutableLiveData<ArrayList<WordListModel>> = MutableLiveData()


    fun addWordList(): ArrayList<WordListModel> {

        wordList = ArrayList<WordListModel>()

        wordList.add(WordListModel("Good"))
        wordList.add(WordListModel("HI"))
        wordList.add(WordListModel("By"))

        Log.e("LIST WORD ", wordList.toString())

        mutableListWord.postValue(wordList)

        return wordList
    }
}

