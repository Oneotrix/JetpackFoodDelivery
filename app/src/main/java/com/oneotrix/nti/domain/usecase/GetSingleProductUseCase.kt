package com.oneotrix.nti.domain.usecase

import com.oneotrix.nti.domain.repository.ProductsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class GetSingleProductUseCase(): KoinComponent {

    private val productsRepository: ProductsRepository by inject()

    suspend operator fun invoke(id: Int) = productsRepository.getProduct(id)

}