package com.example.ganheinamegasena.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.ganheinamegasena.databinding.ItemBetBinding

class NumbersBetsViewHolder(
    private val binding: ItemBetBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun init(megaSenaBet: Pair<Int, List<Int>>) {
        binding.itemBet.text = megaSenaBet.first.toString()
        binding.numbersBet.text = megaSenaBet.second.joinToString("-") { it.toString() }
    }
}