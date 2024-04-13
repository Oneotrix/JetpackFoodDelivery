package com.oneotrix.nti.ui.features.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.ui.features.screens.view.ProductBottomBar
import com.oneotrix.nti.ui.features.screens.view.ProductTopAppBar
import com.oneotrix.nti.ui.features.screens.view.ProductsGrid

@Composable
fun ProductsScreen() {
    Scaffold(
        contentWindowInsets = WindowInsets(top = 16.dp) ,
        topBar = { ProductTopAppBar() },
        content = {
            ProductsGrid(paddingValues = it)
        },
        bottomBar = {
            ProductBottomBar()
        }
    )
}

@Preview
@Composable
fun ProductsScreenPreview() {
    ProductsScreen()
}
