package com.example.streetfood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.streetfood.databinding.ActivityItemDetailBinding

class ItemDetailActivity : AppCompatActivity() {
    private val binding: ActivityItemDetailBinding by lazy {
        ActivityItemDetailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
      val foodName = intent.getStringExtra("MenuItemName")
      val foodimage = intent.getIntExtra("MenuItemImage",0)
        binding.apply {
            detailFoodName.text = foodName.toString()
            detailFoodImage.setImageResource(foodimage)
        }
        binding.imageButtonback.setOnClickListener {
            finish()
        }

    }
}