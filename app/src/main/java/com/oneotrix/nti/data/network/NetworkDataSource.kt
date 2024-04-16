package com.oneotrix.nti.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NetworkDataSource() : KoinComponent {

    private val api: Api by inject()

    suspend fun getProducts() = withContext(Dispatchers.IO) {
        val data = api.getProducts()

        return@withContext data
    }

    suspend fun getCategories() = withContext(Dispatchers.Default) {
        val data = api.getCategories()

        return@withContext data
    }


}