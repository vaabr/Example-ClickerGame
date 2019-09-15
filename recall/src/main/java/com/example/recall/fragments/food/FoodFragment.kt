package com.example.recall.fragments.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recall.MainActivity
import com.example.recall.R
import com.example.recall.Stats
import com.example.recall.databinding.FragmentFoodBinding
import com.example.recall.money.Money

class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_food,
            container,
            false
        )
        binding.bBuyFood.setOnClickListener {
            if (Money.amount > 0) {
                Stats.increaseHunger(5); (activity as MainActivity).increaseMoney(-1)
            }
        }
        return binding.root
    }

}