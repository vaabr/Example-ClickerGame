package com.example.recall.fragments.work.findJob

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recall.R
import com.example.recall.fragments.work.Job
import com.example.recall.fragments.work.JobsObject

class JobListViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.jobslist_item, parent, false
    )
) {
    private var mJobIcon: ImageView? = null
    private var mJobName: TextView? = null
    private var mJobDescription: TextView? = null
    private var mApply: Button? = null
    private var mSalary: TextView? = null

    init {
        mJobIcon = itemView.findViewById(R.id.iv_jobIcon)
        mJobName = itemView.findViewById(R.id.tv_jobName)
        mJobDescription = itemView.findViewById(R.id.tv_jobDescription)
        mApply = itemView.findViewById(R.id.b_apply)
        mSalary = itemView.findViewById(R.id.tv_salary)
    }

    fun bind(job: Job) {
        mJobIcon?.setImageResource(job.iconID)
        mJobName?.text = job.name
        mJobDescription?.text = job.description
        mApply?.setOnClickListener { JobsObject.setCurrent(JobsObject.jobsMap.filterValues { it == job }.keys.first()) }
        val string = "${job.salary}$"
        mSalary?.text = string
    }

}