/**
 * Course Code: W2026 MAD302-01 Android Development
 * Assignment: Assignment 2
 * Name: Nithin Amin
 * Student ID: a00194322
 * Date of Submission: April 20, 2026
 *
 * Description:
 * This file contains the Product data class used by the application.
 */
package com.example.assignment2

import java.io.Serializable

/**
 * Data class representing a product.
 *
 * @property name Product name
 * @property price Product price
 * @property description Product description
 */
data class Product(
    val name: String,
    val price: Double,
    val description: String
) : Serializable