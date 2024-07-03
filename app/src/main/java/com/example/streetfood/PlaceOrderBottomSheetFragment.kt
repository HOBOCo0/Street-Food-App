package com.example.streetfood

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.streetfood.databinding.FragmentPlaceOrderBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PlaceOrderBottomSheetFragment :BottomSheetDialogFragment() {
    private lateinit var binding:FragmentPlaceOrderBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlaceOrderBottomSheetBinding.inflate(layoutInflater,container,false)
        binding.goHomeButton.setOnClickListener {
            val intent = Intent(requireContext(),MainActivity2::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}