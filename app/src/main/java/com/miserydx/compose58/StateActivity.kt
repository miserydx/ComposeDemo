package com.miserydx.compose58

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class StateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Composable
fun Content() {
    var flag by remember { mutableStateOf(1) }
    Column {
        Text(
            text = flag.toString(),
            fontSize = 20.sp,
            modifier = Modifier.clickable {
                flag++
            }
        ).also {
            Log.e("misery", "第一行字")
        }
        SecondText()
    }
}

@Composable
fun SecondText() {
    Text(
        text = "第二行字",
        fontSize = 20.sp,
    ).also {
        Log.e("misery", "第二行字")
    }
}