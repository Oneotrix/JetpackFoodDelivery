package com.oneotrix.nti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.oneotrix.nti.ui.navigation.Navigation
import com.oneotrix.nti.ui.theme.NTITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NTITheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}


