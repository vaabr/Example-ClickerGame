package com.example.recall.fragments.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recall.MainActivity
import com.example.recall.R
import com.example.recall.databinding.FragmentWorkBinding
import com.example.recall.fragments.work.JobsObject.KEY_BEGGAR
import com.example.recall.fragments.work.JobsObject.KEY_JANITOR
import com.example.recall.fragments.work.JobsObject.doWork
import com.example.recall.fragments.work.JobsObject.findNameOfCurrent
import com.example.recall.fragments.work.JobsObject.loadCurrentJob
import com.example.recall.fragments.work.JobsObject.findCurrent
import com.example.recall.fragments.work.JobsObject.saveCurrentJob
import com.example.recall.fragments.work.JobsObject.setCurrent
import com.example.recall.fragments.work.findJob.FindJobFragment
import com.example.recall.log.L

class WorkFragment : Fragment() {

    private lateinit var binding: FragmentWorkBinding
    private lateinit var viewModel: WorkViewModel

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
        viewModel = ViewModelProviders.of(this).get(WorkViewModel::class.java)

        loadCurrentJob()
        initializeOnClickListeners()
        updateJobInfo()

        return binding.root
    }

    private fun initializeOnClickListeners() {
        binding.apply {
            bWork.setOnClickListener {
                doWork()
                (activity as MainActivity).updateCounters()
            }
            bFindJob.setOnClickListener {
                (activity as MainActivity).setFragment(FindJobFragment())
            }
        }
        /*binding.bAsk.setOnClickListener {
            if (findNameOfCurrent() == KEY_BEGGAR) setCurrent(KEY_JANITOR)
            else setCurrent(KEY_BEGGAR)
            updateJobInfo()
        }*/
    }

    private fun updateJobInfo() {
        L.s()
        val currentJob = findCurrent()
        binding.apply {
            tvJob.text = getString(R.string.t_job, currentJob.name).capitalize()
            tvLevel.text = getString(R.string.t_level, currentJob.level.toString())
            tvSalary.text = getString(R.string.t_salary, currentJob.salary.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        L.s()
        loadCurrentJob()
    }

    override fun onPause() {
        super.onPause()
        L.s()
        saveCurrentJob()
    }

}
