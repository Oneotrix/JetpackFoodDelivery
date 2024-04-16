package com.oneotrix.nti.ui.components.products

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.R
import com.oneotrix.nti.ui.theme.buttonTextStyle




@Composable
fun ProductBottomBar(
    currentPrice: Int,
    onBasketScreen: () -> Unit
) {
    if (currentPrice != 0) {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.background,
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.background
                ),
                shape = MaterialTheme.shapes.small,
                onClick = { onBasketScreen.invoke() }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_basket),
                    contentDescription = "icon basket",
                    tint = MaterialTheme.colorScheme.background
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "$currentPrice ₽",
                    style = buttonTextStyle
                )
            }
        }
    }

}

@Preview
@Composable
fun ProductBottomBarPreview() {
    ProductBottomBar(720, {})
}