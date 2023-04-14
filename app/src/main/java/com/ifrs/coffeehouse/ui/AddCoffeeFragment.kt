package com.ifrs.coffeehouse.ui

import android.R.layout
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ifrs.coffeehouse.data.CoffeeHouseAppDatabase
import com.ifrs.coffeehouse.data.dao.CoffeeDao
import com.ifrs.coffeehouse.databinding.FragmentAddCoffeeBinding
import com.ifrs.coffeehouse.domain.Coffee
import com.ifrs.coffeehouse.domain.RoastingLevel
import com.ifrs.coffeehouse.domain.mapper.CoffeeMapper

class AddCoffeeFragment : Fragment() {

    private lateinit var binding: FragmentAddCoffeeBinding

    private lateinit var coffeeDao: CoffeeDao

    private val mapper = CoffeeMapper()

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

        setupDao()
        setupSpinner()
        setupListeners()
    }

    private fun setupDao() {
        val database = CoffeeHouseAppDatabase.getInstance(requireContext())
        coffeeDao = database.coffeeDao()
    }

    private fun setupSpinner() {
        binding.roastingLevelSpinner.adapter = ArrayAdapter(
            requireContext(),
            layout.simple_spinner_item,
            RoastingLevel.values()
        )
    }

    private fun setupListeners() {
        binding.saveButton.setOnClickListener {
            saveCoffee()
            findNavController().popBackStack()
        }
    }

    private fun saveCoffee() {
        val coffeeName = binding.nameInput.text.toString()
        val coffeeCountry = binding.countryInput.text.toString()
        val roastingLevel = binding.roastingLevelSpinner.selectedItem as RoastingLevel

        val coffee = Coffee(
            id = 0,
            name = coffeeName,
            country = coffeeCountry,
            roastingLevel = roastingLevel
        )

        coffeeDao.insertAll(mapper.toEntity(coffee).copy(id = null))
    }
}
