package com.example.ganheinamegasena.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.ganheinamegasena.databinding.ItemNumbersBetsBinding

class NumbersBetsViewHolder(
    private val binding: ItemNumbersBetsBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun init(megaSenaBet: Pair<Int, List<Int>>) {
        binding.itemBet.text = megaSenaBet.first.toString()
        binding.itemNumbers.text = megaSenaBet.second.joinToString("-") { it.toString() }
    }
}