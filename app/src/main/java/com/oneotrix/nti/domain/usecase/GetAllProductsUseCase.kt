package com.oneotrix.nti.domain.usecase

import com.oneotrix.nti.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetAllProductsUseCase : KoinComponent {

        private val productsRepository: ProductsRepository by inject()

        suspend operator fun invoke() = withContext(Dispatchers.Default) {
                productsRepository.getProducts()
        }

}