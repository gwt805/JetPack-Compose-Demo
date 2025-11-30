package com.example.demo.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun ChartView(points: List<Double>, padding: Modifier) {
    // 每一行的高度
    val heightForRow = 24
    // 总行数
    val countForRow = 5
    // 小圆圈半径
    val circleRadius = 2.5
    // 每个积分的高度
    val  perY = 8
    // 画布宽度 = 屏幕宽度 - padding * 2
    val canvasWidth = LocalConfiguration.current.screenWidthDp - 8 * 2
    // 画布高度
    val canvasHeight = heightForRow * countForRow + circleRadius * 2
    // 7 平分宽度
    val averageOfWidth = canvasWidth / 7
    Canvas(
        modifier = Modifier.size(width = canvasWidth.dp, height = canvasHeight.dp)
    ) {
        // 画背景横线
        for (index in 0..countForRow) {
            val startY = (heightForRow * index + circleRadius).dp.toPx()
            drawLine(
                color = Color(0xFFEEEEEE),
                start = Offset(0f, startY),
                end = Offset(size.width, startY),
                strokeWidth = 2.5f
            )
        }
        // 画圆圈、折线
        for (index in 0 until points.count()) {
            val circleCenter = Offset(
                (averageOfWidth * index + averageOfWidth / 2).dp.toPx(),
                (heightForRow * countForRow - points[index] * perY + circleRadius).dp.toPx()
            )
            drawCircle(
                color = Color(0xFF149EE7),
                radius = circleRadius.dp.toPx(),
                center = circleCenter,
                style = Stroke(width = 5f)
            )
            if (index < points.count() - 1) {
                // 下一个点的坐标：也就是circleCenter的计算方法中 index + 1
                val nextCircleCenter = Offset(
                    (averageOfWidth * (index + 1) + averageOfWidth / 2).dp.toPx(),
                    (heightForRow * countForRow - points[index + 1] * perY + circleRadius).dp.toPx()
                )
                drawLine(
                    color = Color(0xFF149EE7),
                    start = circleCenter,
                    end = nextCircleCenter,
                    strokeWidth = 5f
                )
            }
        }
    }
}