package com.oneotrix.nti.ui.screens.products

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oneotrix.nti.ui.components.products.ProductBottomBar
import com.oneotrix.nti.ui.components.products.ProductTopAppBar
import com.oneotrix.nti.ui.components.products.ProductsGrid

@Composable
fun ProductsScreen(
    productsViewModel: ProductsViewModel = viewModel()
) {

    val productState = productsViewModel.productsState.collectAsState()
    val basketState = productsViewModel.basketState.collectAsState()
    val scrollState = productsViewModel.scrollState.collectAsState()

    Scaffold(
        contentWindowInsets = WindowInsets(top = 16.dp) ,
        topBar = { ProductTopAppBar(isElevation = scrollState.value.scrolled) },
        content = {
            ProductsGrid(
                paddingValues = it,
                products = productState.value.products,
                callbackPutInBasket = { productId ->
                    productsViewModel.putProductInBasket(productId)
                },
                callbackRemoveFromBasket = { productId ->
                    productsViewModel.removeProductFromBasket(productId)
                },
                callbackScrollGrid = { isScrolled ->
                    productsViewModel.updateScrollState(isScrolled)
                }
            )
        },
        bottomBar = {
            ProductBottomBar(basketState.value.totalPrice)
        }
    )
}

@Preview
@Composable
fun ProductsScreenPreview() {
    ProductsScreen()
}