package com.oneotrix.nti.ui.screens.products.models

data class ProductModel(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val currentPrice: Int = 0,
    val oldPrice: Int? = null,
    val countInBasket: Int = 0,
)