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
import com.example.recall.databinding.FragmentWorkBinding
import kotlinx.android.synthetic.main.fragment_work.*

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
        return binding.root
    }

    override fun onStart() {
        super.onStart()
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
        jobArray = arrayOf(beggar, janitor)
        defaultJob = beggar
        binding.bWork.setOnClickListener { (activity as MainActivity).increaseMoney(findCurrentJob().payment) }
        initializeJobInfo()
    }

    private fun initializeJobInfo() {
        val currentJob = findCurrentJob()
        binding.apply {
            tvJob.text = getString(R.string.t_job, currentJob.name)
            tvLevel.text = getString(R.string.t_level, currentJob.level.toString())
            tvSalary.text = getString(R.string.t_salary, currentJob.salary.toString())
        }
        /*tv_job.text = getString(R.string.t_job, currentJob.name)
        tv_level.text = getString(R.string.t_level, currentJob.level.toString())
        tv_salary.text = getString(R.string.t_salary, currentJob.salary.toString())*/
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
