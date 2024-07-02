package com.example.streetfood.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.streetfood.R
import com.example.streetfood.adapter.BuyAgainAdapter
import com.example.streetfood.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding:FragmentHistoryBinding
    private lateinit var  buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)

        val buyAgainFoodName = listOf("Burger","Sandwich","momo","spring roll","spring roll","spring" +
                " roll","spring roll","spring roll","Burger","Sandwich","momo","spring roll","spring roll",
            "spring roll","spring roll","spring roll"  )

        val buyAgainFoodPrice = listOf("50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs",
            "80 Rs", "80 Rs","50 Rs", "60 Rs", "120 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs", "80 Rs")

        val buyAgainFoodImage = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu4,
            R.drawable.menu6,
            R.drawable.menu6,
            R.drawable.menu6,
            R.drawable.menu6,
            R.drawable.menu6,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu4,
            R.drawable.menu6,
            R.drawable.menu6,
            R.drawable.menu6,
            R.drawable.menu6,
            R.drawable.menu6)

        buyAgainAdapter = BuyAgainAdapter(ArrayList(buyAgainFoodName),ArrayList(buyAgainFoodPrice),ArrayList(buyAgainFoodImage))
        binding.buyAgainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.buyAgainRecyclerView.adapter = buyAgainAdapter

        return binding.root
    }

    private  fun setupRecyclerView(){

    }
}