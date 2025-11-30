package com.example.demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo.ui.components.TopAppBar

@Composable
fun MineScreen() {
    Column(modifier = Modifier) {
        TopAppBar() {
            Text("我的页面")
        }
        Text("我的页面")
    }
}

@Preview
@Composable
private fun MineScreenPreview() {
    MineScreen()
}