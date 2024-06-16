package com.example.ganheinamegasena

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ganheinamegasena.adapter.NumbersBetsAdapter
import com.example.ganheinamegasena.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        NumbersBetsAdapter()
    }

    private val editAmountBets by lazy {
        binding.editAmountBets
    }

    private val editAmountNumbersBets by lazy {
        binding.editAmountNumbersBets
    }

    private val btnGenerate by lazy {
        binding.btnGenerate
    }

    private val txtAmountBets by lazy {
        binding.txtAmountBets
    }

    private val txtAmountNumbersBets by lazy {
        binding.txtAmountNumbersBets
    }

    private val recyclerNumbersBets by lazy {
        binding.recyclerNumbersBets
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        editAmountNumbersBets.isEnabled = false
        btnGenerate.isEnabled = false

        //Layout
        recyclerNumbersBets.layoutManager = LinearLayoutManager(applicationContext)

        //Adapter
        recyclerNumbersBets.adapter = adapter

    }

    override fun onResume() {
        super.onResume()

        editAmountBets.doOnTextChanged { text, start, before, count ->
            text?.apply {
                editAmountNumbersBets.isEnabled = this.isNotEmpty()
            }
        }

        editAmountNumbersBets.doOnTextChanged { text, start, before, count ->
            text?.apply {
                btnGenerate.isEnabled = this.isNotEmpty() && this.toString().toInt() in 6..9
            }
        }

        btnGenerate.setOnClickListener {
            val amountBet = editAmountBets.text.toString().toInt()
            val amountNumbers = editAmountNumbersBets.text.toString().toInt()

            txtAmountBets.text = "Apostas: $amountBet"
            txtAmountNumbersBets.text = "Jogo com: $amountNumbers numeros"

            adapter.getList(amountBet, amountNumbers)
            recyclerNumbersBets.visibility = View.VISIBLE
        }
    }
}