package com.example.mydiary.ui.auth_screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydiary.R
import com.example.mydiary.ui.components.GoogleButton
import com.example.mydiary.ui.theme.MyDiaryTheme

/**
 * @author : Mingaleev D
 * @data : 01.11.2023
 */

@Composable
fun AuthContent(
    loadingState: Boolean,
    onButtonClicked: () -> Unit
) {
   Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Column(
          modifier = Modifier
              .weight(9f)
              .fillMaxWidth()
              .padding(all = 40.dp),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Column(
             modifier = Modifier.weight(weight = 10f),
             verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally
         ) {
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = stringResource(id = R.string.google_logo)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.auth_title),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            )
            Text(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                text = stringResource(id = R.string.auth_subtitle),
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
         }
         Column(
             modifier = Modifier.weight(weight = 2f),
             verticalArrangement = Arrangement.Bottom
         ) {
            GoogleButton(
                loadingState = loadingState,
                onClick = onButtonClicked
            )
         }
      }
   }
}

@Preview(
    name = "Ночь-Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "День-Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Composable
private fun AuthContentPreview() {
   MyDiaryTheme {
      AuthContent(
          loadingState = false,
          onButtonClicked = {}
      )
   }
}