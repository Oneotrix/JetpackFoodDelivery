package com.oneotrix.nti.domain.repository

import com.oneotrix.nti.domain.models.ProductModel
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun fetchProducts() : Flow<ProductModel>
    suspend fun getProducts() : Flow<ProductModel>
    suspend fun getProduct(id: Int)
    suspend fun getProductsByCategory(id: Int) : Flow<ProductModel>

}