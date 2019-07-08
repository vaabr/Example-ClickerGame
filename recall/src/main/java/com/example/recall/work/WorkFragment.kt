package com.example.recall.work

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recall.Functions
import com.example.recall.MainActivity
import com.example.recall.R
import kotlinx.android.synthetic.main.fragment_work.*

class WorkFragment : Fragment() {

    private lateinit var beggar: Job
    private lateinit var janitor: Job
    private lateinit var jobArray: Array<Job>
    private lateinit var defaultJob: Job

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onStart() {
        super.onStart()
        beggar = Job(1, getString(R.string.tj_beggar))
        janitor = Job(5, getString(R.string.tj_janitor))
        jobArray = arrayOf(beggar, janitor)
        defaultJob = beggar
        b_reset.setOnClickListener { (activity as MainActivity).resetMoney() }
        b_work.setOnClickListener { (activity as MainActivity).increaseMoney(findCurrentJob().payment) }
        initializeJobInfo()
    }

    /*private val beggar = Job(1, getString(R.string.tj_beggar))
    private val janitor = Job(5, getString(R.string.tj_janitor))
    private val jobArray = arrayOf(beggar)
    private val defaultJob = beggar*/

    private fun initializeJobInfo() {
        val currentJob = findCurrentJob()
        tv_job.text = getString(R.string.t_job, currentJob.name)
        tv_level.text = getString(R.string.t_level, currentJob.level.toString())
        tv_salary.text = getString(R.string.t_salary, currentJob.salary.toString())


    }

    private fun loadCurrentJob() {
        when (Functions.loadString("Current Job")) {
            beggar.name -> beggar.makeCurrent()
            else -> defaultJob.name
        }
    }

    private fun saveCurrentJob() {
        Functions.saveData("Current Job", findCurrentJob().name)
    }

    private fun findCurrentJob(): Job {
        for (i in 0 until jobArray.size) {
            if (jobArray[i].isCurrent) return (jobArray[i])
        }
        return defaultJob
    }

    override fun onResume() {
        super.onResume()
        loadCurrentJob()
    }

    override fun onPause() {
        super.onPause()
        saveCurrentJob()
    }

}
