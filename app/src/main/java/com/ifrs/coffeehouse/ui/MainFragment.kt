package com.ifrs.coffeehouse.ui

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.ifrs.coffeehouse.R
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

        binding.aboutUs.setOnClickListener {
            showDraftDialog()
        }

        binding.history.setOnClickListener {
            showDraftDialog()
        }
    }

    private fun showDraftDialog() {
        val alertDialog: AlertDialog = requireActivity().let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle(R.string.not_implemented)
                setPositiveButton(R.string.ok) { dialog, _ ->
                    dialog.dismiss()
                }
            }

            builder.create()
        }

        alertDialog.show()
    }
}
