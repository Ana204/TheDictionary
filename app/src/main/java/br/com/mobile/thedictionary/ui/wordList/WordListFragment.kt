package br.com.mobile.thedictionary.ui.wordList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mobile.thedictionary.databinding.FragmentWordListBinding
import br.com.mobile.thedictionary.model.WordListModel
import br.com.mobile.thedictionary.ui.wordList.adapter.AdapterWordList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordListFragment : Fragment() {

    companion object {
        fun newInstance() = WordListFragment()
    }

    var TAG = "WordListFragment"
    private lateinit var adapterWordList: AdapterWordList
    val viewModel: WordListViewModel by viewModels()
    private lateinit var binding: FragmentWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWordListBinding.inflate(layoutInflater)

        viewModel.addWordList()

        viewModel.mutableListWord.observe(viewLifecycleOwner){

            val recyclerViewWordList = binding.RecyclerViewWord
            recyclerViewWordList.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewWordList.setHasFixedSize(true)
            adapterWordList = AdapterWordList(requireContext(), it)
            recyclerViewWordList.adapter = adapterWordList

            Log.e(TAG, "Array List $it")
        }
        return binding.root
    }

}