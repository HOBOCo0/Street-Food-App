package com.example.streetfood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.streetfood.MenuBottomSheetFragment

import com.example.streetfood.R
import com.example.streetfood.adapter.PopularAdapter
import com.example.streetfood.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.homeMenu.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList,ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                Toast.makeText(requireContext(),"Clicked $position",Toast.LENGTH_SHORT).show()
            }

        })

        val popularFoodName = listOf("Burger","Sandwich","momo","spring roll","spring roll","spring" +
                " roll","spring roll","spring roll","Burger","Sandwich","momo","spring roll","spring roll","spring roll","spring roll","spring roll"  )

        val popularFoodPrice = listOf("50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs",
            "80 Rs", "80 Rs","50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs")

        val popularFoodImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu4,
            R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu1,R.drawable.menu2,R.drawable.menu4,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6,R.drawable.menu6)

        val adapter = PopularAdapter(popularFoodName,popularFoodImage,popularFoodPrice,requireContext())
        binding.popularRecycleView.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.popularRecycleView.adapter = adapter
    }


}