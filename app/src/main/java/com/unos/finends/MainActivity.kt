package com.unos.finends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.unos.finends.ui.theme.BottomNavbar
import com.unos.finends.ui.theme.SignUp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginActivity()
        }
    }
}

//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            FinendsApp()
//        }
//    }
//}
//
//@Composable
//fun FinendsApp() {
//    val navController = rememberNavController()
//    LoginActivity(navController)
//}
