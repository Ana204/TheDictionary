package br.com.mobile.thedictionary.ui.favorites

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
import br.com.mobile.thedictionary.databinding.FragmentFavoritesBinding
import br.com.mobile.thedictionary.ui.favorites.adapter.AdapterFavoritesList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    companion object {
        fun newInstance() = FavoritesFragment()
    }

    val TAG = "Favorites_Fragment"
    private lateinit var adapterWordFavoritesList: AdapterFavoritesList
    private lateinit var viewModel: FavoritesViewModel
    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(layoutInflater)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = requireActivity().findNavController(R.id.nav_host_fragment_content_main)

        viewModel = ViewModelProvider(this)[FavoritesViewModel::class.java]

        viewModel.addWordFavoritesList()

        viewModel.mutableListFavorites.observe(viewLifecycleOwner){
            val recyclerViewFavoritesList = binding.RecyclerViewWordFavorites
            recyclerViewFavoritesList.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewFavoritesList.setHasFixedSize(true)
            adapterWordFavoritesList = AdapterFavoritesList(requireContext(), AdapterFavoritesList.OnClickListener{
                navController.navigate(R.id.action_favoritesFragment_to_wordDetailsFragment)
            }, it )
            recyclerViewFavoritesList.adapter = adapterWordFavoritesList

            Log.e(TAG, "onViewCreated: $it")
        }
    }

}