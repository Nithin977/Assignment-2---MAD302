/**
 * Course Code: W2026 MAD302-01 Android Development
 * Assignment: Assignment 2
 * Name: Nithin Amin
 * Student ID: a00194322
 * Date of Submission: April 20, 2026
 *
 * Description:
 * This adapter binds product data to RecyclerView items
 * and handles item click events using lambda functions.
 */
package com.example.assignment2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.databinding.ItemProductBinding

/**
 * Adapter class for displaying products in RecyclerView.
 *
 * @param productList List of products to display
 * @param onItemClick Lambda function triggered when an item is clicked
 */
class ProductAdapter(
    private val productList: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder for product item layout.
     *
     * @param binding Binding object for item_product.xml
     */
    class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    /**
     * Creates a new ViewHolder.
     *
     * @param parent Parent ViewGroup
     * @param viewType Type of view
     * @return ProductViewHolder object
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    /**
     * Binds product data to the item view.
     *
     * @param holder Current ViewHolder
     * @param position Current item position
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.binding.tvName.text = product.name
        holder.binding.tvPrice.text = "Price: $${String.format("%.2f", product.price)}"

        // Handle item click using lambda
        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }

    /**
     * Returns total number of products.
     *
     * @return Product list size
     */
    override fun getItemCount(): Int = productList.size
}