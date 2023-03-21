package com.feri.kalkulatorcene

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun HoferButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "hofer")
        startActivity(intent)
    }

    fun MerkatorButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "merkator")
        startActivity(intent)
    }

    fun SparButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "spar")
        startActivity(intent)
    }

    fun TusButtonCalled(V : View){
        val intent = Intent(this, CalculationActivity::class.java)
        intent.putExtra("store", "tus")
        startActivity(intent)
    }
}