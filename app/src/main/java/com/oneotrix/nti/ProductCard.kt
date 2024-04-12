package com.oneotrix.nti

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oneotrix.nti.ui.theme.body1TextStyle
import com.oneotrix.nti.ui.theme.buttonTextStyle
import com.oneotrix.nti.ui.theme.cardLineThroughTextStyle

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
            

            ProductButton(currentPrice = 720, oldPrice = 800)
            //ProductButtonSelectedProduct(count = 1)
        }
    }
}

@Composable
fun ProductButton(currentPrice: Int, oldPrice: Int? = null) {
    ElevatedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /*TODO*/ },
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

            when(oldPrice == null) {
                true -> {}
                false -> {
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "$oldPrice ₽",
                        style = cardLineThroughTextStyle,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textDecoration = TextDecoration.LineThrough
                    )}
            }

        }
    }
}

@Composable
fun ProductButtonSelectedProduct(count: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedButton(
            modifier = Modifier.size(40.dp),
            shape = MaterialTheme.shapes.extraSmall,
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 14.dp),
            onClick = { /*TODO*/ }
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
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 14.dp),
            onClick = { /*TODO*/ }
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
    ProductButtonSelectedProduct(2)
}


@Preview(widthDp = 168, heightDp = 290)
@Composable
fun ProductCardPreview() {
    ProductCard(title = "Том Ям", description = "500 г", currentPrice = 720)
}

@Preview(widthDp = 143, heightDp = 40)
@Composable
fun ProductButtonPreview() {
    ProductButton(720,  800)
}