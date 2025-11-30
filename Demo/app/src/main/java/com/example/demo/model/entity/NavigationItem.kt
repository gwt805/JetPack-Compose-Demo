package com.example.demo.model.entity

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * 导航栏对象
 * @property title  导航栏的标题
 * @property icon  导航栏的图标
 */

data class NavigationItem(
    val title: String,
    val icon: ImageVector
)
