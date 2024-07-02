package com.example.streetfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streetfood.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodName:ArrayList<String>,private val buyAgainFoodprice:ArrayList<String>,
                      private val buyAgainFoodimage:ArrayList<Int>):RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = buyAgainFoodName.size
    inner class BuyAgainViewHolder(private val binding:BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                buyAgainFoodText.text = buyAgainFoodName[position]
                buyAgainFoodPrice.text = buyAgainFoodprice[position]
                buyAgainFoodImage.setImageResource(buyAgainFoodimage[position])
            }
        }
    }
}