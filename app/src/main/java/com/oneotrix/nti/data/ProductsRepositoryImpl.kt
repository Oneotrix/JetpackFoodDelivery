package com.oneotrix.nti.data

import android.util.Log
import com.oneotrix.nti.data.local.LocalDataSource
import com.oneotrix.nti.data.network.MapperData
import com.oneotrix.nti.data.network.NetworkDataSource
import com.oneotrix.nti.domain.models.ProductModel
import com.oneotrix.nti.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ProductsRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource
) : ProductsRepository {

    override suspend fun getProducts(): Flow<ProductModel>  {
        val products = networkDataSource.getProducts()
                .map { MapperData.mapGetProductResponse(it) }

        localDataSource.saveProducts(products)

        return flow {
            localDataSource.getProducts().collect {
                it.list.forEach { productRealm ->
                    emit(MapperData.mapProductRealm(productRealm))
                }
            }
        }
    }

    override suspend fun getProduct(id: Int) {

    }

    override suspend fun getProductsByCategory(id: Int): Flow<ProductModel> {
        return flow {
            localDataSource.getProductByCategory(id).collect {
                it.list.forEach { productRealm ->
                    Log.d("ProductsViewModel", "${productRealm.categoryId}")
                    emit(MapperData.mapProductRealm(productRealm))
                }
            }
        }
    }


}