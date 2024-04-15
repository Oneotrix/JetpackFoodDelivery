package com.oneotrix.nti.domain.models

data class ProductModel(
    var id: Int,
    var categoryId: Int,
    var name: String,
    var description: String,
    var image: String,
    var priceCurrent: Int,
    var priceOld: String? = null,
    var measure: Int,
    var measureUnit: String,
    var energyPer100Grams: Double,
    var proteinsPer100Grams: Double,
    var fatsPer100Grams: Double,
    var carbohydratesPer100Grams : Double,
    var tagIds: ArrayList<String> = arrayListOf()
)
