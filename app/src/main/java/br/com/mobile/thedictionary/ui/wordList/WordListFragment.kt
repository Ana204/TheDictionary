package br.com.mobile.thedictionary.ui.wordList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mobile.thedictionary.R

class WordListFragment : Fragment() {

    companion object {
        fun newInstance() = WordListFragment()
    }

    private lateinit var viewModel: WordListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_word_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WordListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}