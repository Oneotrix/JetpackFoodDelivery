package com.oneotrix.nti.data.network

import com.oneotrix.nti.data.local.models.SingleProductRealm
import com.oneotrix.nti.data.local.models.ProductsRealm
import com.oneotrix.nti.data.network.models.GetCategoryResponse
import com.oneotrix.nti.data.network.models.GetProductResponse
import com.oneotrix.nti.domain.models.CategoryModel
import com.oneotrix.nti.domain.models.ProductModel

object MapperData {

    fun mapGetProductResponse(productResponse: GetProductResponse): ProductModel {
        return ProductModel(
            id = productResponse.id,
            categoryId = productResponse.category_id,
            name = productResponse.name,
            description = productResponse.description,
            priceCurrent = productResponse.price_current,
            priceOld = productResponse.price_old,
            measure = productResponse.measure,
            measureUnit = productResponse.measure_unit,
            energyPer100Grams =  productResponse.energy_per_100_grams,
            fatsPer100Grams = productResponse.fats_per_100_grams,
            proteinsPer100Grams = productResponse.proteins_per_100_grams,
            carbohydratesPer100Grams = productResponse.carbohydrates_per_100_grams,
            tagIds = productResponse.tag_ids
        )
    }

    fun mapGetCategoryResponse(categoryResponse: GetCategoryResponse) : CategoryModel {
        return CategoryModel(
            id = categoryResponse.id,
            name = categoryResponse.name
        )
    }

    fun mapProductRealm(SIngleProductRealm: SingleProductRealm): ProductModel {
        return ProductModel(
            id = SIngleProductRealm.id,
            categoryId = SIngleProductRealm.categoryId,
            name = SIngleProductRealm.name,
            description = SIngleProductRealm.description,
            priceCurrent = SIngleProductRealm.priceCurrent,
            priceOld = SIngleProductRealm.priceOld,
            measure = SIngleProductRealm.measure,
            measureUnit = SIngleProductRealm.measureUnit,
            energyPer100Grams = SIngleProductRealm.energyPer100Grams,
            proteinsPer100Grams = SIngleProductRealm.proteinsPer100Grams,
            fatsPer100Grams = SIngleProductRealm.fatsPer100Grams,
            carbohydratesPer100Grams = SIngleProductRealm.carbohydratesPer100Grams,
            tagIds = SIngleProductRealm.tagsIds
        )
    }

    fun mapProductsRealm(productsRealm: ProductsRealm): List<ProductModel> {
        val products = productsRealm.products.map { mapProductRealm(it) }

        return products
    }

}