package com.miserydx.compose58

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.miserydx.compose58.components.HouseList
import com.miserydx.compose58.ui.theme.Compose58Theme

/**
 * Created by miserydx on 2021/7/4.
 */
class AndroidMixComposeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_mix_compose)
        findViewById<ComposeView>(R.id.composeView).apply {
            setContent {
                HouseList()
            }
        }
    }

}