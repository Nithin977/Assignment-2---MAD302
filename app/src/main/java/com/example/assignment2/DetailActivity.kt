/**
 * Course Code: W2026 MAD302-01 Android Development
 * Assignment: Assignment 2
 * Name: Nithin Amin
 * Student ID: A00194322
 * Date of Submission: April 20, 2026
 *
 * Description:
 * This activity receives the selected product from MainActivity
 * and displays its name, price, and description.
 * Null safety is used when receiving the product data.
 */
package com.example.assignment2

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.databinding.ActivityDetailBinding

/**
 * Detail activity that displays full product information.
 */
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState Previously saved state of the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product: Product? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("product_data", Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("product_data") as? Product
        }

        binding.tvProductName.text = product?.name ?: "No Product Found"
        binding.tvProductPrice.text = if (product != null) {
            "Price: $${String.format("%.2f", product.price)}"
        } else {
            "Price: Not Available"
        }
        binding.tvProductDescription.text = product?.description ?: "Description not available."
    }
}