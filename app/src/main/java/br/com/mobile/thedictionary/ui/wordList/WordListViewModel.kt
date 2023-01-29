package br.com.mobile.thedictionary.ui.wordList

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordListViewModel @Inject constructor() : ViewModel() {

    private lateinit var wordlList: ArrayList<String>

    fun addWordList(): ArrayList<String> {

        wordlList = ArrayList()

        wordlList.add("Hello")
        wordlList.add("HI")
        wordlList.add("By")

        Log.e("LIST WORD ", wordlList.toString())

        return wordlList
    }
}

