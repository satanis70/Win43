package com.example.win43.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.win43.R
import com.example.win43.retrofit.ApiInterface
import com.example.win43.ui.theme.TextAppNameColor
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.UUID

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadBackGroundImage(resources)
            val context = this
            LaunchedEffect(key1 = true) {
                OneSignal.initWithContext(context, "714b9f14-381d-4fc4-a93c-28d480557381")
                CoroutineScope(Dispatchers.IO).launch {
                    OneSignal.Notifications.requestPermission(true)
                    launch(Dispatchers.Main) {
                        val intent = Intent(this@SplashScreenActivity, ViewActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

private fun getUrl(resources: Resources) {
    val currentDevice = Build.MANUFACTURER + Build.MODEL
    val currentLocale = resources.configuration.locales.get(0).toString()
    val currentId = UUID.randomUUID().toString()
    val retrofit = Retrofit.Builder()
        .baseUrl("http://49.12.202.175/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    CoroutineScope(Dispatchers.IO).launch{
        val callApi = retrofit.create(ApiInterface::class.java)
        launch(Dispatchers.Main) {
            
        }
    }


}

@Composable
fun LoadBackGroundImage(resources: Resources) {
    Image(
        painter = rememberAsyncImagePainter("http://49.12.202.175/win43/backgroundimg.png"),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = resources.getString(R.string.app_name),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 36.sp,
            color = TextAppNameColor
        )
        LinearProgressIndicator()
    }
}
