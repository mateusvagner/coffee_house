package com.ifrs.coffeehouse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ifrs.coffeehouse.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        binding.addCoffee.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToAddCoffeeFragment()
            )
        }

        binding.allCoffees.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToAllCoffeesFragment()
            )
        }
    }
}
