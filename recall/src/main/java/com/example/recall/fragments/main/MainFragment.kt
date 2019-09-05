package com.example.recall.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recall.Functions.loadLong
import com.example.recall.Functions.saveData
import com.example.recall.R

class MainFragment : Fragment() {

    var money: Long = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        money = loadLong("money")
    }

    override fun onPause() {
        super.onPause()
        saveData("money", money)
    }
}