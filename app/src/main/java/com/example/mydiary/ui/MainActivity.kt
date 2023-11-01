package com.example.mydiary.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.mydiary.BuildConfig
import com.example.mydiary.ui.navigation.Screen
import com.example.mydiary.ui.navigation.SetupNavGraph
import com.example.mydiary.ui.theme.MyDiaryTheme
import io.realm.kotlin.mongodb.App

class MainActivity : ComponentActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      installSplashScreen()
      WindowCompat.setDecorFitsSystemWindows(window, false)
      setContent {
         MyDiaryTheme {
            val navController = rememberNavController()
            SetupNavGraph(
                startDestination = getStartDestination(),
                navController = navController
            )
         }
      }
   }
}

private fun getStartDestination(): String {
   val user = App.create(BuildConfig.APP_ID).currentUser
   return if (user != null && user.loggedIn) {
      Screen.Home.route
   } else {
      Screen.Authentication.route
   }
}

