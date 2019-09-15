package com.example.recall.fragments.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recall.Functions
import com.example.recall.MainActivity
import com.example.recall.R
import com.example.recall.Stats
import com.example.recall.databinding.FragmentWorkBinding

class WorkFragment : Fragment() {
    private lateinit var beggar: Job
    private lateinit var janitor: Job
    private lateinit var jobArray: Array<Job>
    private lateinit var defaultJob: Job

    private lateinit var binding: FragmentWorkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_work,
            container,
            false
        )
        initializeJobs()
        jobArray = arrayOf(beggar, janitor)
        defaultJob = beggar
        binding.bWork.setOnClickListener {
            if (Stats.hungerStat > 0) {
                Stats.increaseHunger(-3); (activity as MainActivity).increaseMoney(findCurrentJob().payment)
            }
        }
        binding.bAsk.setOnClickListener { if (findCurrentJob() == beggar) setCurrentJob(janitor) else setCurrentJob(beggar) }
        initializeJobInfo()
        return binding.root
    }

    private fun initializeJobs() {
        beggar = Job(
            1,
            getString(R.string.tj_beggar).capitalize(),
            getString(R.string.tjd_beggar)
        )
        janitor = Job(
            5,
            getString(R.string.tj_janitor).capitalize(),
            getString(R.string.tjd_janitor)
        )
    }

    private fun initializeJobInfo() {
        val currentJob = findCurrentJob()
        binding.apply {
            tvJob.text = getString(R.string.t_job, currentJob.name)
            tvLevel.text = getString(R.string.t_level, currentJob.level.toString())
            tvSalary.text = getString(R.string.t_salary, currentJob.salary.toString())
        }
    }

    private fun loadCurrentJob() {
        fun check(job: Job):Boolean = Functions.loadString("Current Job") == job.name
        when {
            check(beggar) -> setCurrentJob(beggar)
            check(janitor) -> setCurrentJob(janitor)
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

    private fun setCurrentJob(job: Job) {
        jobArray.forEach { it.isCurrent = false }
        job.makeCurrent()
        initializeJobInfo()
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
