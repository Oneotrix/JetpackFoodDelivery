package com.oneotrix.nti.domain.usecase

import android.util.Log
import com.oneotrix.nti.domain.repository.ProductsRepository

class GetAllProductsUseCase(productsRepository: ProductsRepository) {
        init {
            Log.d("UseCase", "GetAllProductsUseCase init")
        }
}