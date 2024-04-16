package com.oneotrix.nti.domain.models


data class ProductModel(
    var id: Int,
    var categoryId: Int,
    var name: String,
    var description: String,
    var priceCurrent: Int,
    var priceOld: Int? = null,
    var measure: Int,
    var measureUnit: String,
    var energyPer100Grams: Double,
    var proteinsPer100Grams: Double,
    var fatsPer100Grams: Double,
    var carbohydratesPer100Grams : Double,
    var tagIds: List<Int> = listOf()
)
