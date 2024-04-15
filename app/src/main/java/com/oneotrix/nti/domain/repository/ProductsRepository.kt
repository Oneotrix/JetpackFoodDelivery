package com.oneotrix.nti.domain.repository

interface ProductsRepository {

    fun getProducts()

    fun getProduct(id: Int)


}