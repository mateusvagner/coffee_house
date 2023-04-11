package com.ifrs.coffeehouse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ifrs.coffeehouse.databinding.FragmentAddCoffeeBinding

class AddCoffeeFragment : Fragment() {

    private lateinit var binding: FragmentAddCoffeeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddCoffeeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {

    }
}
