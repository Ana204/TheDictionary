package br.com.mobile.thedictionary.ui.historic

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.mobile.thedictionary.R
import br.com.mobile.thedictionary.databinding.FragmentHistoricBinding
import br.com.mobile.thedictionary.ui.historic.adapter.AdapterHistoricList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoricFragment : Fragment() {

    companion object {
        fun newInstance() = HistoricFragment()
    }

    val TAG = "Historic_fragment"
    private lateinit var adapterWordHistoricList: AdapterHistoricList
    private lateinit var viewModel: HistoricViewModel
    private lateinit var binding: FragmentHistoricBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoricBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = requireActivity().findNavController(R.id.nav_host_fragment_content_main)
        viewModel = ViewModelProvider(this)[HistoricViewModel::class.java]

        viewModel.addWordFavoritesList()

        viewModel.mutableListHistoric.observe(viewLifecycleOwner){
            val recyclerViewHistoricList = binding.RecyclerViewWordHistoric
            recyclerViewHistoricList.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewHistoricList.setHasFixedSize(true)
            adapterWordHistoricList = AdapterHistoricList(requireContext(), AdapterHistoricList.OnClickListener{
                navController.navigate(R.id.action_historicFragment_to_wordDetailsFragment)
            }, it)
            recyclerViewHistoricList.adapter = adapterWordHistoricList

            Log.e(TAG, "onViewCreated Historic: $it")
        }

    }

}