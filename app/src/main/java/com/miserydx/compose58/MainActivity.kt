package com.miserydx.compose58

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.miserydx.compose58.components.HouseList
import com.miserydx.compose58.components.StateContent
import com.miserydx.compose58.ui.theme.Compose58Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose58Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Hello()
                }
            }
        }
    }
}

@Composable
fun Hello() {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                context.startActivity(Intent(context, HouseListActivity::class.java))
            },
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(text = "Compose布局")
        }
        Button(
            onClick = {
                context.startActivity(Intent(context, AndroidMixComposeActivity::class.java))
            },
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(text = "Android混Compose")
        }
        Button(
            onClick = {
                context.startActivity(Intent(context, ComposeMixAndroidActivity::class.java))
            },
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(text = "Compose混Android")
        }
        Button(
            onClick = {
                context.startActivity(Intent(context, StateActivity::class.java))
            },
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(text = "学习状态")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose58Theme {
        Hello()
    }
}