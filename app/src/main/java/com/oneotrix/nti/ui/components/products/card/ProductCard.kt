package com.oneotrix.nti.ui.components.products.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.R
import com.oneotrix.nti.ui.theme.body1TextStyle

@Composable
fun ProductCard(
    id: Int,
    title: String,
    measure: Int,
    measureUnit: String,
    currentPrice: Int,
    oldPrice: Int? = null,
    selectionCount: Int,
    callbackPutInBasket: (productId: Int) -> Unit,
    callbackRemoveFromBasket: (productId: Int) -> Unit,
    onProductScreen: () -> Unit,
) {
    Card(
        modifier = Modifier.clickable { onProductScreen.invoke() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Image(
            modifier = Modifier
                .height(170.dp)
                .width((167.5).dp),
            bitmap = ImageBitmap.imageResource(R.drawable.meal),
            contentDescription = ""
        )

        Column(
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            Text(
                text = title,
                style = body1TextStyle,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "$measure $measureUnit",
                style = body1TextStyle,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))


            ProductCardButton(
                currentPrice = currentPrice,
                oldPrice = oldPrice,
                selectionCount = selectionCount,
                callbackPutInBasket = {
                    callbackPutInBasket.invoke(id)
                },
                callbackRemoveFromBasket = {
                    callbackRemoveFromBasket.invoke(id)
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

        }
    }
}

@Preview(widthDp = 168, heightDp = 400)
@Composable
fun ProductCardPreview() {
    ProductCard(
        title = "Запеченный ролл с мидией \n3 ШТ",
        measure = 500,
        measureUnit = "Г",
        currentPrice = 720,
        id = 1,
        selectionCount = 0,
        callbackRemoveFromBasket = {
        },
        callbackPutInBasket = {

        },
        onProductScreen = {

        }
    )
}