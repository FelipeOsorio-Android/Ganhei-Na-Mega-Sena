package com.example.ganheinamegasena.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ganheinamegasena.databinding.ItemNumbersBetsBinding
import com.example.ganheinamegasena.viewholder.NumbersBetsViewHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random
import kotlin.random.nextInt

class NumbersBetsAdapter : RecyclerView.Adapter<NumbersBetsViewHolder>() {

    private var amountBets = 0
    private val bets: MutableList<Pair<Int, List<Int>>> = mutableListOf()
    private val _listNumberBet: MutableStateFlow<List<Pair<Int, List<Int>>>> =
        MutableStateFlow(bets)
    private val listNumberBet get() = _listNumberBet.asStateFlow()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersBetsViewHolder {
        val item = ItemNumbersBetsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return NumbersBetsViewHolder(item)
    }

    override fun onBindViewHolder(holder: NumbersBetsViewHolder, position: Int) {
        holder.init(listNumberBet.value[position])
    }

    override fun getItemCount(): Int = amountBets


    fun getList(amountBet: Int, amountNumbers: Int) {
        notifyItemChanged(amountBet)
        notifyItemChanged(amountNumbers)

        amountBets = amountBet

        val numbersBet = mutableListOf<Int>()

        for (bet in 1..amountBet) {
            for (number in 1..amountNumbers) {
                var randomNumber = Random.nextInt(1..60)

                while (numbersBet.contains(randomNumber)) {
                    randomNumber = Random.nextInt(1..60)
                }

                numbersBet.add(randomNumber)

            }
            bets.add(Pair(first = bet, second = numbersBet.toList()))
            numbersBet.clear()
        }
    }
}

