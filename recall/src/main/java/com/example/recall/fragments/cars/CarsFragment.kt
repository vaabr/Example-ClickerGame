package com.example.recall.fragments.cars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recall.R
import com.example.recall.databinding.FragmentCarsBinding

class CarsFragment : Fragment(){

    private lateinit var binding: FragmentCarsBinding
    private lateinit var viewModel: CarsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cars,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(CarsViewModel::class.java)

        return binding.root
    }
}