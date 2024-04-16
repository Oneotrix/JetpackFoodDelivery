package com.oneotrix.nti.domain.repository

import com.oneotrix.nti.domain.models.ProductModel

interface ProductsRepository {

    suspend fun getProducts() : List<ProductModel>

    suspend fun getProduct(id: Int)


}