package br.com.mobile.thedictionary.ui.wordDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.mobile.thedictionary.HiltApplication
import br.com.mobile.thedictionary.databinding.FragmentWordDetailsBinding
import br.com.mobile.thedictionary.network.RemoteDataSource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = WordDetailsFragment()

    }

    val TAG = "Word-Details-Fragment"
    val viewModel: WordDetailsViewModel by viewModels()
    private lateinit var binding: FragmentWordDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val remoteDataSource: RemoteDataSource by lazy {
            RemoteDataSource(HiltApplication.apiService)
        }

        binding = FragmentWordDetailsBinding.inflate(layoutInflater)

        var word = binding.textViewWord
        var phonetic = binding.textViewPhonetic
        var sound = binding.buttonAboutSound
        var verb = binding.textViewVerb
        var example = binding.textViewExample

        val _word = remoteDataSource.getWordDetails("hello")

        Log.e(TAG, "onCreateView: $_word")

        return binding.root
    }

}