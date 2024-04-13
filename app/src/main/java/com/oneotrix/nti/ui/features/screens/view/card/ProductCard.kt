package com.oneotrix.nti.ui.features.screens.view.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
    modifier: Modifier = Modifier.size(
        width = 168.dp, height = 290.dp
    ),
    title: String,
    description: String,
    currentPrice: Int,
    previousPrice: Int? = null,
    imgUrl: String = "",
) {
    Card(
        modifier = modifier,
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
                text = description,
                style = body1TextStyle,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))


            ProductCardButton()
        }
    }
}

@Preview(widthDp = 168, heightDp = 290)
@Composable
fun ProductCardPreview() {
    ProductCard(title = "Том Ям", description = "500 г", currentPrice = 720)
}