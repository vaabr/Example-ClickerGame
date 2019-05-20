package com.example.recall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recall.Functions.loadInt
import com.example.recall.Functions.saveData

class MainFragment : Fragment() {

    var money = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
        money = loadInt("money")
    }

    override fun onPause() {
        super.onPause()
        saveData("money", money)
    }
}