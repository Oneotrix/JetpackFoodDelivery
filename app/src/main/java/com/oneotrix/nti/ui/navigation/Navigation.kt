package com.oneotrix.nti.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oneotrix.nti.ui.screens.basket.BasketScreen
import com.oneotrix.nti.ui.screens.product.ProductScreen
import com.oneotrix.nti.ui.screens.products.ProductsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NTIScreens.ProductsScreen.name
    )
    {
        composable(route = NTIScreens.ProductsScreen.name) {
            ProductsScreen(
                onProductScreen = {
                    navController.navigate(NTIScreens.ProductScreen.name)
                },
                onBasketScreen = {
                    navController.navigate(NTIScreens.BasketScreen.name)
                }
            )
        }
        composable(route = NTIScreens.ProductScreen.name) {
            ProductScreen()
        }
        composable(route = NTIScreens.BasketScreen.name) {
            BasketScreen()
        }
    }
}