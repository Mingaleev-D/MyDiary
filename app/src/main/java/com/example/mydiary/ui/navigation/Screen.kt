package com.example.mydiary.ui.navigation

import com.example.mydiary.common.Constants.WRITE_SCREE_ARGUMENT_KEY

sealed class Screen(val route: String) {
   object Authentication : Screen("authentication_screen")
   object Home : Screen("home_screen")
   object Write: Screen("write_screen?$WRITE_SCREE_ARGUMENT_KEY={$WRITE_SCREE_ARGUMENT_KEY}"){
      fun passDiaryId(diaryId: String): String {
         return "write_screen?$WRITE_SCREE_ARGUMENT_KEY=$diaryId"
      }
   }
}
