package br.com.mobile.thedictionary.ui.wordList

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mobile.thedictionary.MainActivity
import br.com.mobile.thedictionary.R
import br.com.mobile.thedictionary.databinding.FragmentWordListBinding
import br.com.mobile.thedictionary.model.WordListModel
import br.com.mobile.thedictionary.ui.wordDetails.WordDetailsFragment
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
        val navController = requireActivity().findNavController(R.id.nav_host_fragment_content_main)

        viewModel.addWordList()

        viewModel.mutableListWord.observe(viewLifecycleOwner){

            val recyclerViewWordList = binding.RecyclerViewWord
            recyclerViewWordList.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewWordList.setHasFixedSize(true)
            adapterWordList = AdapterWordList(requireContext(), AdapterWordList.OnClickListener{
                navController.navigate(R.id.action_wordListFragment_to_wordDetailsFragment)
            }, it)
            recyclerViewWordList.adapter = adapterWordList

            Log.e(TAG, "Array List $it")
        }

        return binding.root
    }

}