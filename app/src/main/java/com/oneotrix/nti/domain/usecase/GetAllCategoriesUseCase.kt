package com.oneotrix.nti.domain.usecase

import com.oneotrix.nti.domain.repository.CategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllCategoriesUseCase : KoinComponent {

    private val categoriesRepository: CategoriesRepository by inject()

    suspend operator fun invoke() = withContext(Dispatchers.Default) {
        categoriesRepository.getCategories()
    }

}