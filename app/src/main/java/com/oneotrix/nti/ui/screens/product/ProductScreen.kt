package com.oneotrix.nti.ui.screens.product

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductScreen(
    viewModel: ProductViewModel = koinViewModel()
) {
    Scaffold(
        content = { paddings ->
            Text(
                modifier = Modifier
                    .padding(paddings)
                    .fillMaxSize(),
                text = "Product screen"
            )
        }
    )
}

@Preview
@Composable
fun ProductScreenPreview() {
    ProductScreen()
}