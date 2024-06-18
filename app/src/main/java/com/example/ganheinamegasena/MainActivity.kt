package com.example.ganheinamegasena

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ganheinamegasena.adapter.NumbersBetsAdapter
import com.example.ganheinamegasena.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var amountBet = 0
    private var amountNumbers = 0

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        NumbersBetsAdapter()
    }

    private val btnGenerate by lazy {
        binding.btnGenerate
    }

    private val recyclerNumbersBets by lazy {
        binding.recyclerNumbersBets
    }

    private val txtAmountBetOne by lazy {
        binding.txtOption1
    }

    private val txtAmountBetTwo by lazy {
        binding.txtOption2
    }

    private val txtAmountBetThree by lazy {
        binding.txtOption3
    }

    private val txtAmountBetFour by lazy {
        binding.txtOption4
    }

    private val txtAmountBetFive by lazy {
        binding.txtOption5
    }

    private val txtAmountNumbersSix by lazy {
        binding.txtOptionNumber6
    }

    private val txtAmountNumbersSeven by lazy {
        binding.txtOptionNumber7
    }

    private val txtAmountNumbersEight by lazy {
        binding.txtOptionNumber8
    }

    private val txtAmountNumbersNine by lazy {
        binding.txtOptionNumber9
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.limeGreen)

        //Layout
        recyclerNumbersBets.layoutManager = LinearLayoutManager(applicationContext)

        //Adapter
        recyclerNumbersBets.adapter = adapter

    }

    override fun onResume() {
        super.onResume()

        txtAmountBetOne.setOnClickListener { changeState(txtAmountBetOne) }
        txtAmountBetTwo.setOnClickListener { changeState(txtAmountBetTwo) }
        txtAmountBetThree.setOnClickListener { changeState(txtAmountBetThree) }
        txtAmountBetFour.setOnClickListener { changeState(txtAmountBetFour) }
        txtAmountBetFive.setOnClickListener { changeState(txtAmountBetFive) }
        txtAmountNumbersSix.setOnClickListener { changeState(txtAmountNumbersSix) }
        txtAmountNumbersSeven.setOnClickListener { changeState(txtAmountNumbersSeven) }
        txtAmountNumbersEight.setOnClickListener { changeState(txtAmountNumbersEight) }
        txtAmountNumbersNine.setOnClickListener { changeState(txtAmountNumbersNine) }

        btnGenerate.setOnClickListener {
            adapter.getList(amountBet, amountNumbers)
            recyclerNumbersBets.visibility = View.VISIBLE
        }
    }



    private fun changeState(view: TextView) {

        when(view.text.toString().toInt()) {
            1,2,3,4,5 -> {
                amountBet = view.text.toString().toInt()
                val amountBetList = listOf(
                    txtAmountBetOne,
                    txtAmountBetTwo,
                    txtAmountBetThree,
                    txtAmountBetFour,
                    txtAmountBetFive,
                )

                for (txtView in amountBetList) {
                    if (txtView.id == view.id) {
                        view.setTextColor(getColor(R.color.white))
                        view.background = AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.custom_selected_amount_bet
                        )
                    } else {
                        txtView.setTextColor(getColor(R.color.limeGreen))
                        txtView.background = AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.custom_unselected_amount_bet
                        )
                    }
                }
            }

            else -> {
                amountNumbers = view.text.toString().toInt()
                val amountNumbersList = listOf(
                    txtAmountNumbersSix,
                    txtAmountNumbersSeven,
                    txtAmountNumbersEight,
                    txtAmountNumbersNine,
                )

                for (txtView in amountNumbersList) {
                    if (txtView.id == view.id) {
                        view.setTextColor(getColor(R.color.white))
                        view.background = AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.custom_selected_amount_bet
                        )
                    } else {
                        txtView.setTextColor(getColor(R.color.limeGreen))
                        txtView.background = AppCompatResources.getDrawable(
                            applicationContext,
                            R.drawable.custom_unselected_amount_bet
                        )
                    }
                }
            }
        }


    }
}


//editAmountBets.doOnTextChanged { text, start, before, count ->
//            text?.apply {
//                editAmountNumbersBets.isEnabled = this.isNotEmpty()
//            }
//        }
//
//        editAmountNumbersBets.doOnTextChanged { text, start, before, count ->
//            text?.apply {
//                btnGenerate.isEnabled = this.isNotEmpty() && this.toString().toInt() in 6..9
//            }
//        }
//
