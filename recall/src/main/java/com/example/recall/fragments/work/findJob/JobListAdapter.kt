package com.example.recall.fragments.work.findJob

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recall.fragments.work.Job

class JobListAdapter(val jobs: Map<String, Job>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int = jobs.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}