package com.example.recall.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recall.Functions
import com.example.recall.MainActivity
import com.example.recall.R
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onResume() {
        super.onResume()
        b_work.setOnClickListener(this)
        b_reset.setOnClickListener(this)
        (activity as MainActivity).money = Functions.loadLong("money")
    }

    override fun onPause() {
        super.onPause()
        Functions.saveData("money", (activity as MainActivity).money)
    }

    override fun onClick(v: View?) {
        when (v) {
            b_work -> (activity as MainActivity).increaseMoney(5000000)
            b_reset -> (activity as MainActivity).money = 0
        }
    }
}