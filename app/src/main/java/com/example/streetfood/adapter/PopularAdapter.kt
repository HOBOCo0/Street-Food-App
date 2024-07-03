package com.example.streetfood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streetfood.ItemDetailActivity
import com.example.streetfood.databinding.PopularItemsBinding

class PopularAdapter(private val item:List<String>, private val image:List<Int>,
                     private val price: List<String>, private val requiredContext:Context):RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(item[position],image[position],price[position])

        holder.itemView.setOnClickListener{

            val intent = Intent(requiredContext, ItemDetailActivity::class.java)
            // to send the data with intent.
            intent.putExtra("MenuItemName", item[position])
            intent.putExtra("MenuItemImage", image[position])
            requiredContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

   inner class PopularViewHolder(private val binding:PopularItemsBinding):RecyclerView.ViewHolder(binding.root){
       fun bind(item: String, image: Int, price: String) {
        binding.foodNamePopular.text = item
           binding.pricePopular.text = price
           binding.foodImagePopular.setImageResource(image)
       }

   }
}