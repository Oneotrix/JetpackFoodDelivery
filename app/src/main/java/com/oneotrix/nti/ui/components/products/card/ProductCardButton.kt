package com.oneotrix.nti.ui.components.products.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.oneotrix.nti.R
import com.oneotrix.nti.ui.theme.buttonTextStyle
import com.oneotrix.nti.ui.theme.cardLineThroughTextStyle

@Composable
fun ProductCardButton(
    currentPrice: Int,
    oldPrice: Int?,
    selectionCount: Int,
    callbackPutInBasket: () -> Unit,
    callbackRemoveFromBasket: () -> Unit,
    ) {
    var count by rememberSaveable { mutableIntStateOf(selectionCount) }

    if (count == 0) {
        ProductButtonUnselectProducts(
            currentPrice = currentPrice,
            oldPrice = oldPrice,
            onCountChange = {
                count += it
                callbackPutInBasket.invoke()
            }
        )
    } else {
        ProductButtonSelectedProduct(count = count, onCountChange = {
            count += it
            if (it >= 0) {
                callbackPutInBasket.invoke()
            } else {
                callbackRemoveFromBasket.invoke()
            }
        })
    }
}

@Composable
fun ProductButtonUnselectProducts(currentPrice: Int, oldPrice: Int?, onCountChange: (Int) -> Unit) {
    ElevatedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onCountChange.invoke(1) },
        colors = ButtonDefaults.elevatedButtonColors(containerColor = MaterialTheme.colorScheme.background),
        shape = MaterialTheme.shapes.small,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$currentPrice ₽",
                style = buttonTextStyle,
                color = MaterialTheme.colorScheme.onSurface
            )

            if (oldPrice != null) {
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "$oldPrice ₽",
                    style = cardLineThroughTextStyle,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textDecoration = TextDecoration.LineThrough
                )
            }
        }
    }
}
@Preview(widthDp = 143, heightDp = 40)
@Composable
fun ProductButtonUnselectProductsPreview() {
    ProductButtonUnselectProducts(720,  800, {})
}


@Composable
fun ProductButtonSelectedProduct(count: Int, onCountChange: (Int) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedButton(
            modifier = Modifier.size(40.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.elevatedButtonColors(containerColor = MaterialTheme.colorScheme.background),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 14.dp),
            onClick = { onCountChange.invoke(-1) }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_remove),
                contentDescription = "remove",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Box {
            Text(
                text = "$count",
                style = buttonTextStyle
            )
        }

        ElevatedButton(
            modifier = Modifier.size(40.dp),
            shape = MaterialTheme.shapes.extraSmall,
            colors = ButtonDefaults.elevatedButtonColors(containerColor = MaterialTheme.colorScheme.background),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 14.dp),
            onClick = { onCountChange.invoke(1) }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                contentDescription = "remove",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
@Preview
@Composable
fun ProductButtonSelectedProductPreview() {
    // ProductButtonSelectedProduct(2)
}
