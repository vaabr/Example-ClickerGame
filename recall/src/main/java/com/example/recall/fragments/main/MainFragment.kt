package com.example.recall.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recall.Functions.loadLong
import com.example.recall.Functions.saveData
import com.example.recall.R
import com.example.recall.databinding.FragmentMainBinding
import com.example.recall.fragments.work.WorkViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        return binding.root
    }
}
