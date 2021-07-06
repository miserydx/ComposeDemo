package com.miserydx.compose58

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class StateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var s by mutableStateOf(1)
        setContent {
//            var s = 1
//            var s by mutableStateOf(1)
//            var s by remember { mutableStateOf(1) }
//            Text(
//                text = s.toString(),
//                modifier = Modifier.clickable {
//                    s++
//                }
//            )
            Content()
        }
    }
}

/**
 * Sample2
 * 1.点击第一行字更新同作用域，第二行字会受到影响
 * 2.如果不想第二行字受第一行刷新影响则把其抽成composable函数即可
 * 3.此优化前提条件是composable函数不可内联，Column内联不可以，但Surface非内联可以
 */
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
        )
        SecondText()
    }
}

@Composable
fun SecondText() {
    Text(
        text = (0..10).random().toString(),
        fontSize = 20.sp,
    )
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Button(
        onClick = { count += 1 }
    ) {
        Text(text = "Count: $count")
    }
}