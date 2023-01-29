package br.com.mobile.thedictionary.ui.wordList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.mobile.thedictionary.databinding.FragmentWordListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordListFragment : Fragment() {

    companion object {
        fun newInstance() = WordListFragment()
    }

    val viewModel: WordListViewModel by viewModels()
    private lateinit var binding: FragmentWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordListBinding.inflate(layoutInflater)

        viewModel.addWordList()
        //viewModel = ViewModelProvider(this).get(WordListViewModel::class.java)

        return binding.root
    }

}