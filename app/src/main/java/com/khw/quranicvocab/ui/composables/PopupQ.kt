package com.khw.quranicvocab.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun PopupQ(
    title: String,
    desc: String,
    onMoreClick: () -> Unit,
    onFinishClick: () -> Unit,
    onDismiss: () -> Unit = {}
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .width(300.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Great!, you've learned",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "10 extra word today",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlineButtonQ(
                    color = Color(56, 142, 60, 255),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                    onClick = { /*TODO*/ }) {
                    Text("Learn 10 More", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlineButtonQ(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
                    onClick = { /*TODO*/ }) {
                    Text("Finish", fontSize = 16.sp)
                }
            }
        }
    }
}