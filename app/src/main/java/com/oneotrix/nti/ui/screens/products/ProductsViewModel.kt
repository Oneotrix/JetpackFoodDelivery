package com.oneotrix.nti.ui.screens.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oneotrix.nti.domain.usecase.FetchAllProductsUseCase
import com.oneotrix.nti.domain.usecase.FilterProductsByCategoryUseCase
import com.oneotrix.nti.domain.usecase.GetAllCategoriesUseCase
import com.oneotrix.nti.domain.usecase.GetAllProductsUseCase
import com.oneotrix.nti.ui.screens.products.ProductsViewModel.UiState.BasketState
import com.oneotrix.nti.ui.screens.products.ProductsViewModel.UiState.FiltersState
import com.oneotrix.nti.ui.screens.products.ProductsViewModel.UiState.ProductsState
import com.oneotrix.nti.ui.screens.products.ProductsViewModel.UiState.ScrollState
import com.oneotrix.nti.ui.screens.products.models.FilterModel
import com.oneotrix.nti.ui.screens.products.models.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class ProductsViewModel(
) : ViewModel(), KoinComponent {

    private val fetchAllProductsUseCase: FetchAllProductsUseCase by inject()
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase by inject()
    private val filterProductsByCategoryUseCase: FilterProductsByCategoryUseCase by inject()
    private val getAllProductsUseCase : GetAllProductsUseCase by inject()

    private val _productsState = MutableStateFlow(ProductsState())
    private val _filtersState = MutableStateFlow(FiltersState())
    private val _basketState = MutableStateFlow(BasketState())
    private val _scrollState = MutableStateFlow(ScrollState())

    val productsState = _productsState.asStateFlow()
    val filtersState = _filtersState.asStateFlow()
    val basketState = _basketState.asStateFlow()
    val scrollState = _scrollState.asStateFlow()

    init {
        fetchProducts()
        fetchFilters()
    }

    fun putProductInBasket(id: Int) {
        val changePrice = _productsState.value.products
            .first { it.id == id }
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
            .first { it.id == id }
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

    fun selectFilter(id: Int) {

        var isSelected = false
        val filters = _filtersState.value.filters.map { filter ->
            if (filter.id == id) {
                isSelected = filter.isSelected.not()
                filter.copy(isSelected = filter.isSelected.not())
            }
            else filter.copy(isSelected = false)
        }

        changeFiltersState(filters)

        loadProductsBySelectedCategory(id, isSelected)

    }

    private fun changeFiltersState(filters: List<FilterModel>) {
        _filtersState.update { state ->
            state.copy(filters = filters)
        }
    }

    private fun loadProductsBySelectedCategory(id: Int, isSelected: Boolean) {
        viewModelScope.launch {
            when(isSelected) {
                true -> {
                    val products = mutableListOf<ProductModel>()

                    filterProductsByCategoryUseCase(id).collect { model ->
                        _productsState.update { state ->
                            products.add(ProductModel.map(model))

                            state.copy(products = products)
                        }
                    }
                }
                false -> {
                    val products = mutableListOf<ProductModel>()

                    getAllProductsUseCase().collect { model ->
                        _productsState.update { state ->
                            products.add(ProductModel.map(model))

                            state.copy(products = products)
                        }
                    }
                }
            }

        }
    }

    private fun fetchProducts() = viewModelScope.launch{
        val products = productsState.value.products.toMutableList()

        fetchAllProductsUseCase().collect { model ->
            _productsState.update { state ->
                products.add(ProductModel.map(model))

                state.copy(products = products)
            }
        }

    }

    private fun fetchFilters() = viewModelScope.launch {
        _filtersState.update {
            val filters = getAllCategoriesUseCase().map { model ->
                FilterModel.map(model)
            }
            it.copy(filters = filters)
        }
    }

    sealed class UiState() {
        data class ProductsState(val products: List<ProductModel> = listOf()) : UiState()
        data class FiltersState(val filters: List<FilterModel> = listOf()) : UiState()
        data class BasketState(val totalPrice: Int = 0) : UiState()
        data class ScrollState(val scrolled: Boolean = false) : UiState()
    }
}