package com.khw.quranicvocab.ui.composables


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OutlineButtonQ(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(minWidth = 60.dp),
        colors = ButtonColors(
            contentColor = color,
            containerColor = Color.Unspecified,
            disabledContentColor = Color.Gray,
            disabledContainerColor = Color.Gray
        ),
        border = BorderStroke(1.dp, color),
        shape = RoundedCornerShape(10.dp),
        onClick = { onClick() },
        content = content
    )
}