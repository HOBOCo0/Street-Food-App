package com.example.streetfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.streetfood.adapter.NotificationAdapter
import com.example.streetfood.databinding.FragmentNotificationBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding:FragmentNotificationBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationBottomSheetBinding.inflate(layoutInflater,container,false)

        val notifications = listOf("Your Order Has Been Successfully Completed",
            "Order has been taken by the driver", "Congrats Your Order Has been delivered")
        val notificationImage = listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.congrats)
        val adapter = NotificationAdapter(ArrayList(notifications),ArrayList(notificationImage))
        binding.notificationRecyclarView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecyclarView.adapter = adapter
        // Inflate the layout for this fragment
        return binding.root
    }


}