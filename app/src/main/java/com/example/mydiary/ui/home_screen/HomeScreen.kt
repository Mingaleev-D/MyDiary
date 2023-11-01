package com.example.mydiary.ui.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.example.mydiary.BuildConfig
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author : Mingaleev D
 * @data : 01.11.2023
 */

@Composable
fun HomeScreen() {

   val scope = rememberCoroutineScope()

   Column {
      Text(text = "Home screen")

      Button(onClick = {
         scope.launch(Dispatchers.IO) {
            App.create(BuildConfig.APP_ID).currentUser?.logOut()
         }
      }) {
         Text(text = "Logount")
      }
   }

}