package com.feri.kalkulatorcene

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun HoferButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "Hofer")
        startActivity(intent)
    }

    fun MercatorButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "Mercator")
        startActivity(intent)
    }

    fun SparButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "Spar")
        startActivity(intent)
    }

    fun TusButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "Tus")
        startActivity(intent)
    }
}