package com.oneotrix.nti.ui.screens.products.models

import com.oneotrix.nti.domain.models.ProductModel

data class ProductModel(
    val id: Int = 0,
    val title: String = "",
    val measure: Int = 0,
    val measureUnit: String = "",
    val currentPrice: Int = 0,
    val oldPrice: Int? = null,
    val countInBasket: Int = 0,
) {
    companion object {
        fun map(productModel: ProductModel) : com.oneotrix.nti.ui.screens.products.models.ProductModel {
            return ProductModel(
                id = productModel.id,
                title = productModel.name,
                measure = productModel.measure,
                measureUnit = productModel.measureUnit,
                currentPrice = productModel.priceCurrent.div(100) ,
                oldPrice = productModel.priceOld?.div(100),
                countInBasket = 0
            )
        }
    }
}