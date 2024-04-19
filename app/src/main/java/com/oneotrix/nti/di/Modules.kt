package com.oneotrix.nti.di

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.oneotrix.nti.data.CategoriesRepositoryImpl
import com.oneotrix.nti.data.ProductsRepositoryImpl
import com.oneotrix.nti.data.TagsRepositoryImpl
import com.oneotrix.nti.data.local.LocalDataSource
import com.oneotrix.nti.data.local.models.ProductsRealm
import com.oneotrix.nti.data.local.models.SingleProductRealm
import com.oneotrix.nti.data.network.Api
import com.oneotrix.nti.data.network.NetworkDataSource
import com.oneotrix.nti.domain.repository.CategoriesRepository
import com.oneotrix.nti.domain.repository.ProductsRepository
import com.oneotrix.nti.domain.repository.TagsRepository
import com.oneotrix.nti.domain.usecase.DeleteProductFromBasketUseCase
import com.oneotrix.nti.domain.usecase.FetchAllProductsUseCase
import com.oneotrix.nti.domain.usecase.FilterProductsByCategoryUseCase
import com.oneotrix.nti.domain.usecase.GetAllCategoriesUseCase
import com.oneotrix.nti.domain.usecase.GetAllProductsUseCase
import com.oneotrix.nti.domain.usecase.GetSingleProductUseCase
import com.oneotrix.nti.domain.usecase.PutProductInBasketUseCase
import com.oneotrix.nti.ui.screens.basket.BasketViewModel
import com.oneotrix.nti.ui.screens.product.ProductViewModel
import com.oneotrix.nti.ui.screens.products.ProductsViewModel
import io.realm.kotlin.Configuration
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit


val appModule = module {

    single<ProductsRepository>{ ProductsRepositoryImpl(get(), get()) }
    single<CategoriesRepository>{ CategoriesRepositoryImpl(get()) }
    single<TagsRepository>{ TagsRepositoryImpl() }

    single { NetworkDataSource() }
    single { LocalDataSource() }

    factory { FetchAllProductsUseCase() }
    factory { GetAllProductsUseCase() }
    factory { GetAllCategoriesUseCase() }
    factory { GetSingleProductUseCase() }
    factory { DeleteProductFromBasketUseCase() }
    factory { PutProductInBasketUseCase() }
    factory { FilterProductsByCategoryUseCase() }

    viewModel { ProductsViewModel() }
    viewModel { ProductViewModel() }
    viewModel { BasketViewModel() }
}

val networkModule = module {

    single <Api> {
        get<Retrofit>().create(Api::class.java)
    }

    single<Retrofit>{
        Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(get())
            .client(get())
            .build()
    }

    single<OkHttpClient>{
        OkHttpClient.Builder()
            .addInterceptor(interceptor = get<Interceptor>())
            .build()
    }

    single<Interceptor>{
        HttpLoggingInterceptor { message -> Log.d("OkHttp", message) }
            .apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    single<Converter.Factory>{
        get<Json>().asConverterFactory(contentType = get())
    }

    factory<MediaType>{ "application/json".toMediaType() }

    factory<Json>{ Json }

}

val dbModule = module {
    single<Configuration> {
        RealmConfiguration.create(schema = setOf(
            ProductsRealm::class,
            SingleProductRealm::class
        )
        )
    }

    single<Realm>{ Realm.open(get()) }
}






