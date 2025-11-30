package com.example.demo.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo.model.entity.NavigationItem

@Composable
fun MainFrame() {
    val navigationItems = listOf(
        NavigationItem(title = "学习", icon = Icons.Filled.Home),
        NavigationItem(title = "任务", icon = Icons.Filled.DateRange),
        NavigationItem(title = "我的", icon = Icons.Filled.Person),
    )
    var currentNavigationIndex by remember { mutableIntStateOf(0) }
    Scaffold(bottomBar =  {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface,
            windowInsets = NavigationBarDefaults.windowInsets,
        ) {
            navigationItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = currentNavigationIndex == index,
                    onClick = { currentNavigationIndex = index },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = null)
                    },
                    label = {Text(text = item.title)},
                    colors = NavigationBarItemColors(
                        selectedIconColor = Color(0xFF149EE7), // 只需要设置你关心的核心颜色
                        selectedTextColor = Color(0xFF149EE7),
                        unselectedIconColor = Color(0xFF999999),
                        unselectedTextColor = Color(0xFF999999),
                        disabledIconColor = Color(0xFF149EE7),
                        disabledTextColor = Color(0xFF149EE7),
                        selectedIndicatorColor = Color.Transparent
                    )
                )
            }
        }
    }){
        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (currentNavigationIndex) {
                0 -> StudyScreen()
                1 -> TaskScreen()
                2 -> MineScreen()
            }
        }
    }
}

@Preview
@Composable
private fun MainFramePreview() {
    MainFrame()
}