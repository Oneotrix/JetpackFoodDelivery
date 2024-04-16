package com.oneotrix.nti.data

import com.oneotrix.nti.data.network.MapperResponse
import com.oneotrix.nti.data.network.NetworkDataSource
import com.oneotrix.nti.domain.models.ProductModel
import com.oneotrix.nti.domain.repository.ProductsRepository


class ProductsRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : ProductsRepository {

    override suspend fun getProducts(): List<ProductModel> {
        return networkDataSource.getProducts()
            .map { MapperResponse.mapGetProductResponse(it) }
    }

    override suspend fun getProduct(id: Int) {

    }
}