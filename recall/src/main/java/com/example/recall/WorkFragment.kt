package com.example.recall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment(), View.OnClickListener {
    var money = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onResume() {
        super.onResume()
        //.setOnClickListener(this)
        money = Functions.loadInt("money")
        updateCounters()
    }

    override fun onPause() {
        super.onPause()
        Functions.saveData("money", money)
    }

    override fun onClick(v: View?) {
        when (v) {
            TODO() -> TODO()
        }
    }

    private fun updateCounters(){
    }
}