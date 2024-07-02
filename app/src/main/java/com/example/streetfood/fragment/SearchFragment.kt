package com.example.streetfood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streetfood.R
import com.example.streetfood.adapter.MenuAdapter
import com.example.streetfood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
   private lateinit var binding:FragmentSearchBinding

   private lateinit var adapter : MenuAdapter
    private val originalMenuFoodName = listOf("Burger","Sandwich","momo","spring roll","spring roll","spring" +
            " roll","spring roll","spring roll","Burger","Sandwich","momo","spring roll","spring roll",
        "spring roll","spring roll","spring roll"  )
   private val originalMenuFoodPrice = listOf("50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs",
        "80 Rs", "80 Rs","50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs")

   private val originalMenuFoodImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu4,
        R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,
        R.drawable.menu1,R.drawable.menu2,R.drawable.menu4,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,
        R.drawable.menu6,R.drawable.menu6)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuFoodPrice = mutableListOf<String>()
    private val filteredMenuFoodImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuFoodPrice,filteredMenuFoodImage)
        binding.recyclerViewMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMenu.adapter = adapter

        // setup search view
        setupSearchView()
        //Show all menu Items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuFoodPrice.addAll(originalMenuFoodPrice)
        filteredMenuFoodImage.addAll(originalMenuFoodImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMeenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMeenuItems(newText)
                return true
            }

        })
    }

    private fun filterMeenuItems(query: String?) {
        filteredMenuFoodName.clear()
        filteredMenuFoodPrice.clear()
        filteredMenuFoodImage.clear()

        originalMenuFoodName.forEachIndexed{index, foodName ->
            if(foodName.contains(query.toString(),ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuFoodPrice.add(originalMenuFoodPrice[index])
                filteredMenuFoodImage.add(originalMenuFoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


}