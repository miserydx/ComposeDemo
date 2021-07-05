package com.miserydx.compose58

import android.os.Bundle
import android.view.View
import android.widget.TextView
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
import androidx.compose.ui.viewinterop.AndroidView
import com.miserydx.compose58.components.HouseList
import com.miserydx.compose58.ui.theme.Compose58Theme

/**
 * Created by miserydx on 2021/7/4.
 */
class ComposeMixAndroidActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "我是 Compose Text")
                AndroidView({
                    TextView(this@ComposeMixAndroidActivity)
                }) {
                    it.text = "我是 Android TextView"
                }
            }
        }
    }

}