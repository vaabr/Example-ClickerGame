package com.example.recall.fragments.fitness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recall.R
import com.example.recall.databinding.FragmentFitnessBinding

class FitnessFragment : Fragment(){

    private lateinit var binding: FragmentFitnessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_fitness,
            container,
            false
        )
        return binding.root
    }
}