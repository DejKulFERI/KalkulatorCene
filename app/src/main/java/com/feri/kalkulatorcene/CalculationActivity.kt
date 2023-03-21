package com.feri.kalkulatorcene

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.util.Log
import com.feri.kalkulatorcene.databinding.ActivityCalculationBinding
import android.content.Context

class CalculationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)
        binding = ActivityCalculationBinding.inflate(layoutInflater);
        val view = binding.root
        setContentView(view)

        val storeName = getIntent().getStringExtra("store");
    }

    fun calculateButtonCalled(V : View){
        val price = Integer.parseInt(binding.editTextPrice.text.toString())
        val weight = Integer.parseInt(binding.editTextWeight.text.toString())

        val pricePerKilo = 1000 * price / weight;

        binding.textViewPerKilo.setText(pricePerKilo.toString()+"e")
    }
}