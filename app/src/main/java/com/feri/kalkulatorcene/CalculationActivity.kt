package com.feri.kalkulatorcene

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.feri.kalkulatorcene.databinding.ActivityCalculationBinding

class CalculationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculationBinding
    lateinit var app: MyApplication

    var storeName: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)
        binding = ActivityCalculationBinding.inflate(layoutInflater);
        val view = binding.root
        setContentView(view)

        app = application as MyApplication

        storeName = getIntent().getStringExtra("store");
        if (storeName == "Hofer")
            binding.imgStore.setImageResource(R.drawable.hofer)
        else if (storeName == "Mercator")
            binding.imgStore.setImageResource(R.drawable.mercator)
        else if (storeName == "Spar")
            binding.imgStore.setImageResource(R.drawable.spar)
        else if (storeName == "Tus")
            binding.imgStore.setImageResource(R.drawable.tus)
        else
            binding.imgStore.setImageResource(R.drawable.ic_baseline_store_24)

        val recyclerview = binding.recyclerView

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ArticlesViewModel>()

        for (i in 0..app.articleList.size - 1) {
            if (app.articleList[i].storeName == "Hofer")
                data.add(
                    ArticlesViewModel(
                        R.drawable.hofer,
                        app.articleList[i].name,
                        app.articleList[i].price
                    )
                )
            else if (app.articleList[i].storeName == "Mercator")
                data.add(
                    ArticlesViewModel(
                        R.drawable.mercator,
                        app.articleList[i].name,
                        app.articleList[i].price
                    )
                )
            else if (app.articleList[i].storeName == "Tus")
                data.add(
                    ArticlesViewModel(
                        R.drawable.tus,
                        app.articleList[i].name,
                        app.articleList[i].price
                    )
                )
            else if (app.articleList[i].storeName == "Spar")
                data.add(
                    ArticlesViewModel(
                        R.drawable.spar,
                        app.articleList[i].name,
                        app.articleList[i].price
                    )
                )
            else
                data.add(
                    ArticlesViewModel(
                        R.drawable.ic_baseline_store_24,
                        app.articleList[i].name,
                        app.articleList[i].price
                    )
                )
        }

        val adapter = ArticlesAdapter(data)

        recyclerview.adapter = adapter
    }

    fun calculateButtonCalled(V: View) {
        val name = binding.editTextProductName.text.toString()
        val price = binding.editTextPrice.text.toString().toDouble()
        val weight = binding.editTextWeight.text.toString().toDouble()

        val pricePerKilo = 1000 * price / weight

        binding.textViewPerKilo.setText(pricePerKilo.toString() + " €")

        app.articleList.add(0, Article(name, pricePerKilo, storeName.toString()))
        app.saveToFile()

        binding.editTextPrice.text.clear()
        binding.editTextWeight.text.clear()
        binding.editTextProductName.text.clear()
        //binding.textViewPerKilo.text = ""
        recreate()
    }
}