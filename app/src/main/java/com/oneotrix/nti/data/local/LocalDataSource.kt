package com.oneotrix.nti.data.local

import com.oneotrix.nti.data.local.models.ProductsRealm
import com.oneotrix.nti.data.local.models.SingleProductRealm
import com.oneotrix.nti.domain.models.ProductModel
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocalDataSource : KoinComponent {

    private val realmDb: Realm by inject()

    suspend fun saveProducts(products: List<ProductModel>) = withContext(Dispatchers.IO){
        realmDb.write {
            val list = products
                .map { product -> SingleProductRealm().apply {
                    id = product.id
                    categoryId = product.categoryId
                    name = product.name
                    description = product.description
                    priceCurrent = product.priceCurrent
                    priceOld = product.priceOld
                    measure = product.measure
                    measureUnit = product.measureUnit
                    energyPer100Grams = product.energyPer100Grams
                    proteinsPer100Grams = product.proteinsPer100Grams
                    fatsPer100Grams = product.fatsPer100Grams
                    carbohydratesPer100Grams = product.carbohydratesPer100Grams
                    tagsIds = product.tagIds.toRealmList()
               } }
                .toRealmList()

            val products = ProductsRealm().apply {
                this.products = list
            }

            copyToRealm(instance = products, updatePolicy = UpdatePolicy.ALL)
        }
    }

    suspend fun getProducts() = withContext(Dispatchers.IO) {
        val allProductsQuery = realmDb.query<SingleProductRealm>()

        val allProductsFlow = allProductsQuery.asFlow()

        return@withContext allProductsFlow
    }

    suspend fun getProductByCategory(categoryId: Int) = withContext(Dispatchers.IO){
        val query = realmDb.query<SingleProductRealm>("categoryId == $categoryId")
        val productsFlow = query.find().asFlow()

        return@withContext productsFlow
    }

}