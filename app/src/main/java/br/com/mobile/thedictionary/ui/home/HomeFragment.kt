package br.com.mobile.thedictionary.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.mobile.thedictionary.R
import br.com.mobile.thedictionary.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val navController = requireActivity().findNavController(R.id.nav_host_fragment_activity_main)

        binding.buttonList.setOnClickListener {
            navController.navigate(R.id.action_navigation_home_to_wordListFragment)
        }

        binding.buttonFavorites.setOnClickListener {
            navController.navigate(R.id.action_navigation_home_to_favoritesFragment)
        }

        binding.buttonHistoric.setOnClickListener {
            navController.navigate(R.id.action_navigation_home_to_historicFragment)
        }

        //val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }

        return binding.root
    }
}