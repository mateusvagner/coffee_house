package com.ifrs.coffeehouse.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ifrs.coffeehouse.databinding.LayoutItemCoffeeBinding
import com.ifrs.coffeehouse.domain.Coffee

class CoffeeItemAdapter : ListAdapter<Coffee, CoffeeItemAdapter.CoffeeItemViewHolder>(
    CoffeeDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CoffeeItemViewHolder(
            LayoutItemCoffeeBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoffeeItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class CoffeeItemViewHolder(private val binding: LayoutItemCoffeeBinding) :
        ViewHolder(binding.root) {
        fun bind(coffee: Coffee) {
            binding.name.text = coffee.name
            binding.country.text = coffee.country
            binding.roastingLevel.backgroundTintList = binding.root.context.getColorStateList(coffee.roastingLevel.color)
        }
    }

    companion object {
        class CoffeeDiffUtil : DiffUtil.ItemCallback<Coffee>() {
            override fun areItemsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
                return oldItem == newItem
            }

        }

    }
}