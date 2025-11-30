package com.example.demo.ui.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.demo.model.entity.DateType
import com.example.demo.model.entity.SwiperEntity
import com.example.demo.ui.components.Category

class MainViewModel: ViewModel() {
    // 分类数据
    val categoryies by mutableStateOf(listOf(
        Category("思想政治"),
        Category("法律法规"),
        Category("职业道德"),
        Category("诚信自律")
    ))

    // 当前分类下标
    var categoryIndex by mutableStateOf(0)
        private set

    /**
     * 更新分类下标
     */
    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }

    // 类型数据
    val types by mutableStateOf(listOf(
        DateType(title = "相关资讯", icon = Icons.Default.Description),
        DateType("视频课程", Icons.Default.SmartDisplay)
    ))

    // 当前类型下标
    var currentTypeIndex by mutableStateOf(0)
        private set
    fun updateTypeIndex(index: Int) {
        currentTypeIndex = index
    }

    // 轮播图数据
    val swiperData = listOf(
        SwiperEntity("https://img2.baidu.com/it/u=424082863,91122719&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=888"),
        SwiperEntity("https://img2.baidu.com/it/u=2066847125,2203603163&fm=253&fmt=auto&app=138&f=JPEG?w=1200&h=888"),
        SwiperEntity("https://img1.baidu.com/it/u=3406846466,349754692&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=888"),
        SwiperEntity("https://img2.baidu.com/it/u=682940730,221140209&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=888"),
        SwiperEntity("https://img2.baidu.com/it/u=3731342073,2564607660&fm=253&fmt=auto&app=120&f=JPEG?w=1200&h=888")
    )

    // 通知数据
    val notifications = listOf<String>(
        "人社部向疫情防控期",
        "湖北黄冈新冠肺炎患者治愈病例破千连续5治愈病例破千连续5",
        "安徽单日新增确诊病例首次降至个位数累计"
    )
}