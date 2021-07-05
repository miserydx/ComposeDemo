package com.miserydx.compose58.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/**
 * Created by miserydx on 2021/7/3.
 */
@Composable
fun StateContent(){
    val nums by mutableStateOf(mutableListOf(1,2,3))
    var flag by mutableStateOf(1)
    Column() {
        Text(flag.toString(), Modifier.clickable { flag++ })
    }
}