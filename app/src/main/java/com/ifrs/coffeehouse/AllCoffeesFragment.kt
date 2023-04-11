package com.ifrs.coffeehouse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ifrs.coffeehouse.databinding.FragmentAllCoffeesBinding

class AllCoffeesFragment : Fragment() {

    private lateinit var binding: FragmentAllCoffeesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllCoffeesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    private fun setupListeners() {

    }
}
