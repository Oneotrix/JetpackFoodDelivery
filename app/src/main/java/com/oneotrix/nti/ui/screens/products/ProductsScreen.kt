package com.oneotrix.nti.ui.screens.products

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.ui.components.products.ProductBottomBar
import com.oneotrix.nti.ui.components.products.ProductTopAppBar
import com.oneotrix.nti.ui.components.products.ProductsGrid
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductsScreen(
    onProductScreen: () -> Unit,
    onBasketScreen: () -> Unit,
    viewModel: ProductsViewModel = koinViewModel()
) {

    val productState = viewModel.productsState.collectAsState()
    val basketState = viewModel.basketState.collectAsState()
    val scrollState = viewModel.scrollState.collectAsState()

    Scaffold(
        contentWindowInsets = WindowInsets(top = 16.dp) ,
        topBar = { ProductTopAppBar(isElevation = scrollState.value.scrolled) },
        content = {
            ProductsGrid(
                paddingValues = it,
                products = productState.value.products,
                callbackPutInBasket = { productId ->
                    viewModel.putProductInBasket(productId)
                },
                callbackRemoveFromBasket = { productId ->
                    viewModel.removeProductFromBasket(productId)
                },
                callbackScrollGrid = { isScrolled ->
                    viewModel.updateScrollState(isScrolled)
                },
                onProductScreen = onProductScreen
            )
        },
        bottomBar = {
            ProductBottomBar(
                currentPrice = basketState.value.totalPrice,
                onBasketScreen = onBasketScreen
            )
        }
    )
}

@Preview
@Composable
fun ProductsScreenPreview() {
    //ProductsScreen()
}