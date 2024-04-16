package com.oneotrix.nti.data

import com.oneotrix.nti.data.network.MapperResponse
import com.oneotrix.nti.data.network.NetworkDataSource
import com.oneotrix.nti.domain.models.CategoryModel
import com.oneotrix.nti.domain.repository.CategoriesRepository

class CategoriesRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : CategoriesRepository {
    override suspend fun getCategories(): List<CategoryModel> {
        return networkDataSource.getCategories()
            .map { MapperResponse.mapGetCategoryResponse(it) }
    }
}