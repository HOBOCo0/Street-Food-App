package com.example.streetfood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.streetfood.ItemDetailActivity
import com.example.streetfood.databinding.MenuItemBinding

class MenuAdapter(private val menuItems:MutableList<String>,private val menuItemPrice:MutableList<String>,
                  private val menuItemImage:MutableList<Int>,private val requiredContext: Context):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListner :OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int {
        return menuItems.size
    }
    inner class MenuViewHolder(private val binding: MenuItemBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val adaptPos = adapterPosition
                // this code is unnecessary for now
                if (adaptPos != RecyclerView.NO_POSITION){
                    itemClickListner.onItemClick(adaptPos)
                }
                val intent = Intent(requiredContext,ItemDetailActivity::class.java)
                // to send the data with intent.
                intent.putExtra("MenuItemName", menuItems.get(adaptPos))
                intent.putExtra("MenuItemImage", menuItemImage.get(adaptPos))
                requiredContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {

            // setting the data in the list
            binding.apply {
                foodNameMenu.text = menuItems[position]
                priceMenu.text = menuItemPrice[position]
                foodImageMenu.setImageResource(menuItemImage[position])
            }

        }

    }
}
private fun OnClickListener?.onItemClick(adaptPos: Int) {

}
