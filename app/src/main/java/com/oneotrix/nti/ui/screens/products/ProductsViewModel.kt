package com.oneotrix.nti.ui.screens.products

import android.util.Log
import androidx.lifecycle.ViewModel
import com.oneotrix.nti.mock.Data
import com.oneotrix.nti.ui.screens.products.ProductsViewModel.UiState.*
import com.oneotrix.nti.ui.screens.products.models.FilterModel
import com.oneotrix.nti.ui.screens.products.models.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.time.Duration.Companion.nanoseconds


class ProductsViewModel() : ViewModel() {

    private val _productsState = MutableStateFlow(ProductsState())
    private val _filtersState = MutableStateFlow(FiltersState())
    private val _basketState = MutableStateFlow(BasketState())
    private val _scrollState = MutableStateFlow(ScrollState())

    val productsState = _productsState.asStateFlow()
    val filtersState = _filtersState.asStateFlow()
    val basketState = _basketState.asStateFlow()
    val scrollState = _scrollState.asStateFlow()


    fun putProductInBasket(id: Int) {
        val changePrice = _productsState.value.products
            .filter { it.id == id}
            .first()
            .currentPrice


        val newProductsList = _productsState.value.products
            .toMutableList()


        newProductsList.map { if (it.id == id) {
                val newCount = it.countInBasket + 1
                it.copy(countInBasket = newCount)
            }}

        _productsState.update {
            it.copy(products = newProductsList)
        }


        updateBasketState(changePrice)
    }

    fun removeProductFromBasket(id: Int) {

        val changePrice = _productsState.value.products
            .filter { it.id == id}
            .first()
            .currentPrice * -1

        val newProductsList = _productsState.value.products
            .toMutableList()


        newProductsList.map { if (it.id == id) {
            val newCount = it.countInBasket - 1
            it.copy(countInBasket = newCount)
        }}

        _productsState.update {
            it.copy(products = newProductsList)
        }

        updateBasketState(changePrice)
    }

    fun updateScrollState(isScrolled: Boolean) {
        _scrollState.update {
            it.copy(scrolled = isScrolled)
        }
    }

    private fun updateBasketState(price: Int) {
        _basketState.update {
            val newPrice = it.totalPrice + price
            it.copy(totalPrice = newPrice)
        }
    }

    sealed class UiState() {
        data class ProductsState(val products: List<ProductModel> = Data.Products) : UiState()
        data class FiltersState(val products: List<FilterModel> = listOf()) : UiState()
        data class BasketState(val totalPrice: Int = 0) : UiState()
        data class ScrollState(val scrolled: Boolean = false) : UiState()
    }
}