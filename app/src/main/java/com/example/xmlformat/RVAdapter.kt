package com.example.xmlformat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_item.view.*

class RVAdapter(private var students: List<StudentDetails>) : RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val student = students[position]

        holder.itemView.apply {

            tvName.text = student.name
            tvGrade.text = student.grade.toString()


        }
    }

    override fun getItemCount() = students.size

    fun update(students: List<StudentDetails>){
        this.students = students
        notifyDataSetChanged()
    }
}