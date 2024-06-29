package com.example.streetfood

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.streetfood.databinding.ActivityChooseLoacationBinding

/*
 this class implements the select location feature of the app
*/
class ChooseLoacation : AppCompatActivity() {
    private  val binding:ActivityChooseLoacationBinding by lazy{
        ActivityChooseLoacationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val locationListDummy = arrayOf("Delhi","Gorakhpur","Hyderabad","Bengaluru")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationListDummy)
        val autoCompleteTextView = binding.locationList
        autoCompleteTextView.setAdapter(adapter)
    }
}
