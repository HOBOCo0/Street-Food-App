package com.example.streetfood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streetfood.adapter.MenuAdapter
import com.example.streetfood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/*
   This fragment implements bottom sheet for menu items
*/

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    // creating binding object for the fragment
    private lateinit var binding:FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        binding.backButtonMenuBottomSheet.setOnClickListener {
            dismiss()
        }
        val menuFoodName = listOf("Burger","Sandwich","momo","spring roll","spring roll","spring" +
                " roll","spring roll","spring roll","Burger","Sandwich","momo","spring roll","spring roll",
            "spring roll","spring roll","spring roll"  )

        val menuFoodPrice = listOf("50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs",
            "80 Rs", "80 Rs","50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs")

        val menuFoodImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu4,
            R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,
            R.drawable.menu1,R.drawable.menu2,R.drawable.menu4,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,
            R.drawable.menu6,R.drawable.menu6)

        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuFoodPrice),ArrayList(menuFoodImage),requireContext())
        binding.recyclerViewMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMenu.adapter = adapter

        return binding.root
    }

}