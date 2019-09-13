package com.example.recall.fragments.apartments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recall.R
import com.example.recall.databinding.FragmentApartmentsBinding

class ApartmentsFragment : Fragment(){

    private lateinit var binding: FragmentApartmentsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentApartmentsBinding>(
            inflater,
            R.layout.fragment_apartments,
            container,
            false
        )
        return binding.root
    }
}