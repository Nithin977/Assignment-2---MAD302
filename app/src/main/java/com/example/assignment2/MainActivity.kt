/**
 * Course Code: W2026 MAD302-01 Android Development
 * Assignment: Assignment 2
 * Name: Nithin Amin
 * Student ID: a00194322
 * Date of Submission: April 20, 2026
 *
 * Description:
 * This activity displays a list of products using RecyclerView.
 * When the user clicks on a product, the app navigates to DetailActivity
 * and passes the selected product data using Intent.
 */
package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productList = listOf(
            Product("Samsung Galaxy S25", 999.99, "A premium Android smartphone with a powerful camera and smooth performance."),
            Product("iPhone 17", 1199.99, "Apple smartphone with a fast processor, sleek design, and strong ecosystem support."),
            Product("Google Pixel 10", 899.99, "Google smartphone known for its camera quality and clean Android experience."),
            Product("OnePlus 14", 849.99, "A high-performance phone with fast charging and a fluid display."),
            Product("Sony WH-1000XM5", 499.99, "Wireless noise-cancelling headphones with excellent sound quality."),
            Product("iPad Air", 899.99, "A lightweight and powerful tablet ideal for study, media, and productivity.")
        )

        productAdapter = ProductAdapter(productList) { selectedProduct ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("product_data", selectedProduct)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = productAdapter
    }
}