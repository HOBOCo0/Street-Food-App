package com.example.streetfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streetfood.databinding.NotificationItemBinding

class NotificationAdapter(private val notification: ArrayList<String>,
                          private val notificationImagee: ArrayList<Int>):RecyclerView.Adapter<NotificationAdapter.NotificationVievHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationVievHolder {
   val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationVievHolder(binding)
    }

    override fun getItemCount(): Int = notification.size


    override fun onBindViewHolder(holder: NotificationVievHolder, position: Int) {
        holder.bind(position)
    }

    inner class NotificationVievHolder(private val binding:NotificationItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                notificationText.text = notification[position]
                notificationImage.setImageResource(notificationImagee[position])
            }
        }

    }
}