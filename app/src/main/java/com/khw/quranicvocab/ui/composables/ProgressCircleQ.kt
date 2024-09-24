package com.khw.quranicvocab.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun ProgressCircleQ(
    current: Int,
    total: Int
) {
    val progress: Float = 1.0f * current / total
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(90.dp)
    ) {
        Canvas(modifier = Modifier.size(90.dp)) {
            drawArc(
                color = Color.LightGray,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 15f, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
            drawArc(
                color = Color(0xFF4CAF50),
                startAngle = -90f,
                sweepAngle = 360f * progress,
                useCenter = false,
                style = Stroke(width = 15f, cap = StrokeCap.Round),
                size = Size(size.width, size.height)
            )
        }
        Text(
            text = "$current/$total",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}