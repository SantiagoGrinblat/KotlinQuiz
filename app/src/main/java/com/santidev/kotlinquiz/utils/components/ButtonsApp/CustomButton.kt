package com.santidev.kotlinquiz.utils.components.ButtonsApp

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.santidev.kotlinquiz.R
import com.santidev.kotlinquiz.data.LoginViewModel

@Composable
fun CustomButton(modifier: Modifier, viewmodel: LoginViewModel = viewModel()) {
  val navController = rememberNavController()
  
  val token = "588666420377-dsrnd9o17f2ukbq6vim66toeoimeqlif.apps.googleusercontent.com"
  val context = LocalContext.current
  
  val launcher = rememberLauncherForActivityResult(
    contract = ActivityResultContracts.StartActivityForResult()
  ) { result ->
    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
    try {
      val account = task.getResult(ApiException::class.java)
      val credential = GoogleAuthProvider.getCredential(account.idToken, null)
      viewmodel.signInWhitGoogleCredential(credential) {
        navController.popBackStack()
      }
    } catch (e: Exception){
      Log.d("KotlinQuizLogin", "Login Failed With Google")
    }
  }
  
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(48.dp)
      .clickable{
        val options = GoogleSignInOptions.Builder(
          GoogleSignInOptions.DEFAULT_SIGN_IN
        )
          .requestIdToken(token)
          .requestEmail()
          .build()
        val googleSignInClient = GoogleSignIn.getClient(context, options)
        launcher.launch(googleSignInClient.signInIntent)
      }
      .padding(horizontal = 32.dp)
      .background(
        Color.White,
        shape = RoundedCornerShape(16.dp)
      )
      .border(2.dp, Color(0xFF362348), RoundedCornerShape(16.dp)),
    contentAlignment = Alignment.CenterStart,
  ) {
    Image(
      painter = painterResource(id = R.drawable.logogoogle),
      contentDescription = "Google Login Button",
      modifier = Modifier
        .padding(start = 16.dp)
        .size(28.dp)
    )
    Text(
      text = "Continue with Google",
      fontWeight = FontWeight.Bold,
      color = Color.Black,
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center,
    )
  }
}
