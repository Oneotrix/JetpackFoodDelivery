package com.oneotrix.nti.ui.screens.basket

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel

@Composable
fun BasketScreen(
    viewModel: BasketViewModel = koinViewModel()
) {
    Scaffold(
        content = { paddings ->
            Text(
                modifier = Modifier
                    .padding(paddings)
                    .fillMaxSize(),
                text = "Basket screen"
            )
        }
    )
}

@Preview
@Composable
fun ProductScreenPreview() {
    BasketScreen()
}