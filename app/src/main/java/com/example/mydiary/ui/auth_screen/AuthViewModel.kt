package com.example.mydiary.ui.auth_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydiary.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.GoogleAuthType
import kotlinx.coroutines.delay

/**
 * @author : Mingaleev D
 * @data : 01.11.2023
 */

class AuthViewModel : ViewModel() {

   var loadingState = mutableStateOf(false)
      private set
   var authenticated = mutableStateOf(false)
      private set

   fun setLoading(loading: Boolean) {
      loadingState.value = loading
   }

   fun signInWithMongoAtlas(
       tokenId: String,
       onSuccess: (Boolean) -> Unit,
       onError: (Exception) -> Unit
   ) {

      viewModelScope.launch {
         try {
            val result = withContext(Dispatchers.IO) {
               App.create(BuildConfig.APP_ID).login(
                  // Credentials.jwt(tokenId)
                   Credentials.google(tokenId, GoogleAuthType.ID_TOKEN)
               ).loggedIn
            }
            withContext(Dispatchers.Main) {
               onSuccess(result)
               delay(600)
               authenticated.value = true
            }
         } catch (e: Exception) {
            withContext(Dispatchers.Main) {
               onError(e)
            }
         }
      }

   }
}
