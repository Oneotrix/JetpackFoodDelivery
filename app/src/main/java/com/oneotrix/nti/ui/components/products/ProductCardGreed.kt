package com.oneotrix.nti.ui.components.products

import android.util.Log
import android.webkit.ValueCallback
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.ui.components.products.card.ProductCard
import com.oneotrix.nti.ui.screens.products.models.ProductModel

@Composable
fun ProductsGrid(
    paddingValues: PaddingValues,
    products: List<ProductModel>,
    callbackPutInBasket: (productId: Int) -> Unit,
    callbackRemoveFromBasket: (productId: Int) -> Unit,
    callbackScrollGrid: (Boolean) -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier.nestedScroll(object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                Log.d("LazyVerticalGrid", "${available.getDistance()}")
                if (available.y < 0) {
                    callbackScrollGrid.invoke(true)
                } else {
                    if (available.getDistance() == 0f) {
                        callbackScrollGrid.invoke(false)
                    }
                }
                return super.onPreScroll(available, source)
            }
        }),
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
            items(products) {
                ProductCard(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    currentPrice = it.currentPrice,
                    oldPrice = it.oldPrice,
                    selectionCount = it.countInBasket,
                    callbackPutInBasket = callbackPutInBasket,
                    callbackRemoveFromBasket = callbackRemoveFromBasket,
                )
            }
        }
    )
}


@Composable
@Preview
fun ProductGridPreview() {
   // ProductsGrid(PaddingValues(16.dp))
}