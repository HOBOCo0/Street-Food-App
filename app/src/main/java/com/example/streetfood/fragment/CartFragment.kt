package com.example.streetfood.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streetfood.PayoutActivity
import com.example.streetfood.PlaceOrderBottomSheetFragment
import com.example.streetfood.R
import com.example.streetfood.adapter.CartAdapter
import com.example.streetfood.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Burger","Sandwich","momo","spring roll","spring roll","spring" +
                " roll","spring roll","spring roll","Burger","Sandwich","momo","spring roll","spring roll","spring roll","spring roll","spring roll"  )

        val cartFoodPrice = listOf("50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs",
            "80 Rs", "80 Rs","50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs")

        val cartFoodImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu4,
            R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu1,R.drawable.menu2,
            R.drawable.menu4,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6)

        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartFoodPrice),ArrayList(cartFoodImage))
        binding.recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCart.adapter = adapter

        binding.cartProceedButton.setOnClickListener {
            val intent = Intent(requireContext(),PayoutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

}
