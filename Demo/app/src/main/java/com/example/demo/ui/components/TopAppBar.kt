package com.example.demo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo.ui.theme.Blue700

/**
 * @param modifier
 * @param content 标题栏内容
 * */
@Composable
fun TopAppBar(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Row(
        modifier = Modifier.background(
            Brush.horizontalGradient(listOf(
                Blue700,
                Blue700
            ))
        ).fillMaxWidth().then(modifier),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Preview
@Composable
private fun TopAppBarPreview() {
    TopAppBar {
        Text("标题")
    }
}