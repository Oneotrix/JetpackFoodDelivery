package com.oneotrix.nti.domain.repository

import com.oneotrix.nti.domain.models.CategoryModel

interface CategoriesRepository {

    suspend fun getCategories() : List<CategoryModel>

}