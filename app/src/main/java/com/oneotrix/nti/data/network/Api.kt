package com.oneotrix.nti.data.network

import retrofit2.http.GET

interface Api {

    @GET("Categories.json")
    fun getCategories()

    @GET("Products.json")
    fun getProducts()

    @GET("Tags.json")
    fun getTags()

    companion object {
        const val BASE_URL = "https://anika1d.github.io/WorkTestServer/"
    }
}