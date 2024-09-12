package com.khw.quranicvocab.ui.screens.learn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.khw.quranicvocab.ui.composables.OutlineButtonQ
import com.khw.quranicvocab.ui.composables.PopupQ
import com.khw.quranicvocab.ui.composables.ProgressCircle

@Composable
fun LearnScreen(navController: NavController =  rememberNavController()) {

    //PopupQ(title = "", desc = "", onMoreClick = { /*TODO*/ }, onFinishClick = { /*TODO*/ })
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                "You've learned 10 words",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProgressCircle(current = 10, total = 20)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Today's Target",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                "المُؤمِنون",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "The Believers",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.weight(1f))
            OutlineButtonQ(
                modifier = Modifier.width(160.dp),
                color = Color(56, 142, 60, 255),
                onClick = { /*TODO*/ }
            )
            {
                Text("Done", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlineButtonQ(
                modifier = Modifier.width(160.dp),
                onClick = { /*TODO*/ }
            ) {
                Text("Repeat", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}