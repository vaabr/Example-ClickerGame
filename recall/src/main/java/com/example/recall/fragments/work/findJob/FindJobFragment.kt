package com.example.recall.fragments.work.findJob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recall.MainActivity
import com.example.recall.R
import com.example.recall.databinding.FragmentWorkFindjobBinding
import com.example.recall.fragments.work.JobsObject

class FindJobFragment : Fragment() {

    private lateinit var binding: FragmentWorkFindjobBinding
    private lateinit var viewModel: FindJobViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_work_findjob, container, false)
        viewModel = ViewModelProviders.of(this).get(FindJobViewModel::class.java)
        binding.rvJobslist.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = JobListAdapter(JobsObject.jobsMap)
        }

        return binding.root
    }
}
