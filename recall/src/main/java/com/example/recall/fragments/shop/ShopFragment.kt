package com.example.recall.fragments.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recall.R
import com.example.recall.databinding.FragmentShopBinding

class ShopFragment : Fragment(){

    private lateinit var binding: FragmentShopBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentShopBinding>(
            inflater,
            R.layout.fragment_shop,
            container,
            false
        )
        return binding.root
    }
}