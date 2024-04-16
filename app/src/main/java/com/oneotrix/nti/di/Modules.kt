package com.oneotrix.nti.di

import com.oneotrix.nti.data.ProductsRepositoryImpl
import com.oneotrix.nti.domain.repository.ProductsRepository
import com.oneotrix.nti.domain.usecase.GetAllProductsUseCase
import com.oneotrix.nti.ui.screens.basket.BasketViewModel
import com.oneotrix.nti.ui.screens.product.ProductViewModel
import com.oneotrix.nti.ui.screens.products.ProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel { ProductsViewModel(get()) }
    viewModel { ProductViewModel() }
    viewModel { BasketViewModel() }


}

val useCaseModule = module {
    factory { GetAllProductsUseCase(
        productsRepository = get()
    ) }
}

val repositoryModule = module {
    single<ProductsRepository>{ ProductsRepositoryImpl() }
}


