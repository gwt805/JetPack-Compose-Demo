package com.example.demo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demo.ui.components.ArticleItem
import com.example.demo.ui.components.NotificationContent
import com.example.demo.ui.components.SwiperContent
import com.example.demo.ui.components.TopAppBar
import com.example.demo.ui.components.VideoItem
import com.example.demo.ui.viewmodel.ArticleViewModel
import com.example.demo.ui.viewmodel.MainViewModel
import com.example.demo.ui.viewmodel.VideoViewModel

@Composable
fun StudyScreen(vm: MainViewModel = viewModel(), at: ArticleViewModel = viewModel(), video: VideoViewModel = viewModel()) {
    Column(modifier = Modifier) {
        // 标题栏
        TopAppBar(modifier = Modifier.padding(horizontal = 8.dp)) {
            Spacer(modifier = Modifier.width(8.dp))
            // 搜索按钮
            Surface(
                modifier = Modifier.clip(RoundedCornerShape(16.dp)).weight(1f),
                color = Color(0x33FFFFFF)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text="搜索感兴趣的咨询或课程",
                        color= Color.White,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // 学习进度
            Text(
                lineHeight = 16.sp,
                text = "学习\n进度",
                fontSize = 10.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "26%",
                fontSize = 12.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = Color.White
            )
        }
        
        // 分类标签
        TabRow(
            selectedTabIndex = vm.categoryIndex,
            containerColor = Color(0xFFF0F8FF),
            contentColor = Color(0xFF149EE7),
            indicator = {
                tapPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tapPositions[vm.categoryIndex]),
                    color = Color(0x66149EE7)
                )
            }
        ) {
            vm.categoryies.forEachIndexed{index, category ->
                Tab(
                    selected = vm.categoryIndex == index,
                    onClick = { vm.updateCategoryIndex(index) },
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666)
                ) {
                    Text(
                        text = category.title,
                        modifier = Modifier.padding(vertical = 4.dp),
                        fontSize = 14.sp
                    )
                }
            }
        }
        // 类型
        TabRow(
            selectedTabIndex = vm.currentTypeIndex,
            containerColor = Color.Transparent,
            contentColor = Color(0xFF149EE7),
            divider = {},
            indicator = {}
        ) {
            vm.types.forEachIndexed { index, dateType ->
                LeadingIconTab(
                    selected = vm.currentTypeIndex == index,
                    onClick = {vm.updateTypeIndex(index)},
                    selectedContentColor = Color(0xFF149EE7),
                    unselectedContentColor = Color(0xFF666666),
                    icon = {
                        Icon(imageVector = dateType.icon, contentDescription = null)
                    },
                    text = {
                        Text(
                            text = dateType.title,
                            modifier = Modifier.padding(vertical = 4.dp),
                            fontSize = 16.sp
                        )
                    }
                )
            }
        }
        LazyColumn() {
            // 轮播图
            item { SwiperContent(vm) }
            // 通知公告
            item { NotificationContent(vm) }

            if (vm.currentTypeIndex == 0) {
                //文章列表
                items(at.list) {
                    article ->
                    ArticleItem(article)
                }
            } else {
                // 视频列表
                items(video.list) {
                        mv ->
                    VideoItem(mv)
                }
            }
        }
    }
}

@Preview
@Composable
private fun StudyScreenPreview() {
    StudyScreen()
}