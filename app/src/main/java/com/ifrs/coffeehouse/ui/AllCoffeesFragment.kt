package com.ifrs.coffeehouse.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifrs.coffeehouse.data.CoffeeHouseAppDatabase
import com.ifrs.coffeehouse.data.dao.CoffeeDao
import com.ifrs.coffeehouse.databinding.FragmentAllCoffeesBinding
import com.ifrs.coffeehouse.domain.mapper.CoffeeMapper

class AllCoffeesFragment : Fragment() {

    private lateinit var binding: FragmentAllCoffeesBinding

    private lateinit var coffeeItemAdapter: CoffeeItemAdapter

    private val mapper = CoffeeMapper()

    private lateinit var coffeeDao: CoffeeDao
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
        setupDao()
        setupAdapter()
        setupListeners()
    }

    private fun setupDao() {
        val database = CoffeeHouseAppDatabase.getInstance(requireContext())
        coffeeDao = database.coffeeDao()
    }

    private fun setupAdapter() {
        coffeeItemAdapter = CoffeeItemAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = coffeeItemAdapter

        val allCoffees = coffeeDao.getAll().map(mapper::toDomain)
        coffeeItemAdapter.submitList(allCoffees)
    }
    private fun setupListeners() {

    }
}
