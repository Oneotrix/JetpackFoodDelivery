package com.oneotrix.nti.ui.features.screens.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.ui.features.screens.view.card.ProductCard

@Composable
fun ProductsGrid(paddingValues: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = paddingValues.calculateTopPadding(),
            bottom = paddingValues.calculateBottomPadding()
        ),
        content = {
            items(20) {
                ProductCard(title = "Том Ям", description = "500 г", currentPrice = 720)
            }
        }
    )
}


@Composable
@Preview
fun ProductGridPreview() {
    ProductsGrid(PaddingValues(16.dp))
}