package com.example.streetfood

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.streetfood.databinding.ActivityPayoutBinding

class PayoutActivity : AppCompatActivity() {

    private val binding: ActivityPayoutBinding by lazy {
        ActivityPayoutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.placeOrderButton.setOnClickListener {
            val bottomSheetDialog = PlaceOrderBottomSheetFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }

    }
}