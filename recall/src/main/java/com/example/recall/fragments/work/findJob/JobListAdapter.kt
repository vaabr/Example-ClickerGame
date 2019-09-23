package com.example.recall.fragments.work.findJob

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recall.fragments.work.Job
import com.example.recall.fragments.work.JobsObject
import com.example.recall.fragments.work.JobsObject.KEY_BEGGAR

class JobListAdapter(val jobs: Map<String, Job>): RecyclerView.Adapter<JobListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return JobListViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: JobListViewHolder, position: Int) {
        val job: Job = jobs[JobsObject.arrayOfKeys[position]] ?: jobs[KEY_BEGGAR]!!
        holder.bind(job)
    }

    override fun getItemCount(): Int = jobs.size




}