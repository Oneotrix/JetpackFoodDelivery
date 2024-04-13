package com.oneotrix.nti.ui.features.screens.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.ui.theme.buttonTextStyle

@Composable
fun ProductBottomBar() {
    var productsInBasket by rememberSaveable { mutableStateOf(0) }

    if (productsInBasket != 0) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp, bottom = 12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.background
                ),
                shape = MaterialTheme.shapes.small,
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "2 160",
                    style = buttonTextStyle
                )
            }
        }
    }

}
@Preview
@Composable
fun ProductBottomBarPreview() {
    ProductBottomBar()
}