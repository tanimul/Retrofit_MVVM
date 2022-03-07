package com.example.mvvmarchitecture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val lists: List<Model_Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_user_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullName.text = lists[position].name
        holder.universityID.text = lists[position].universityid
        holder.courseCode.text = lists[position].coursecode
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val fullName: TextView = ItemView.findViewById(R.id.textview_list_fullName)
        val universityID: TextView = ItemView.findViewById(R.id.textview_list_universityId)
        val courseCode: TextView = ItemView.findViewById(R.id.textview_list_courseCode)
    }

}