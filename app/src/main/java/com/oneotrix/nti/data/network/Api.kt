package com.oneotrix.nti.data.network

import com.oneotrix.nti.data.network.models.GetCategoryResponse
import com.oneotrix.nti.data.network.models.GetProductResponse
import retrofit2.http.GET

interface Api {

    @GET("Categories.json")
    suspend fun getCategories() : List<GetCategoryResponse>

    @GET("Products.json")
    suspend fun getProducts() : List<GetProductResponse>

    @GET("Tags.json")
    suspend fun getTags()

    companion object {
        const val BASE_URL = "https://anika1d.github.io/WorkTestServer/"
    }
}