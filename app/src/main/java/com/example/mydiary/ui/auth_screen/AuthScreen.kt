package com.example.mydiary.ui.auth_screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.mydiary.BuildConfig
import com.example.mydiary.R
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarState
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle

/**
 * @author : Mingaleev D
 * @data : 01.11.2023
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    authenticated: Boolean,
    loadingState: Boolean,
    oneTapState: OneTapSignInState,
    messageBarState: MessageBarState,
    onButtonClicked: () -> Unit,
    onTokenIdReceived: (String) -> Unit,
    onDialogDismissed: (String) -> Unit,
    navigateToHome: () -> Unit
) {

   val stringResAuthSuccess = stringResource(id = R.string.successfully_authenticated)

   Scaffold() {
      ContentWithMessageBar(messageBarState = messageBarState) {
         AuthContent(
             loadingState = loadingState,
             onButtonClicked = onButtonClicked
         )
      }
   }

   OneTapSignInWithGoogle(
       state = oneTapState,
       clientId = BuildConfig.CLIENT_ID,
       onTokenIdReceived = { tokenId ->
          Log.d("Auth", "AuthScreen: $tokenId")
          onTokenIdReceived(tokenId)

       },
       onDialogDismissed = { message ->
          Log.d("Auth", "AuthScreen: $message")
          onDialogDismissed(message)
       }
   )

   LaunchedEffect(key1 = authenticated) {
      if (authenticated) {
         navigateToHome()
      }
   }
}
