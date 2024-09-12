package com.khw.quranicvocab.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController


@Composable
fun ProfileScreen(
    navController: NavController = rememberNavController()
) {
    var isEditMode by remember { mutableStateOf(false) }
    var learnWords by remember { mutableStateOf("20") }
    var practiceWords by remember { mutableStateOf("20") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2196F3)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        // Profile Picture
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.White, CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name and Email
        Text(
            "Md Khayrul Islam",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            "khayrul@gmail.com",
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Daily Target Card
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
//            backgroundColor = Color.White
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Daily Target", fontWeight = FontWeight.Bold)
                    IconButton(onClick = { isEditMode = !isEditMode }) {
                        Icon(
                            if (isEditMode) Icons.Default.Lock else Icons.Default.Edit,
                            contentDescription = if (isEditMode) "Save" else "Edit"
                        )
                    }
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                Text("Learn")
                if (isEditMode) {
                    TextField(
                        value = learnWords,
                        onValueChange = { learnWords = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Text("$learnWords Words", fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Practice")
                if (isEditMode) {
                    TextField(
                        value = practiceWords,
                        onValueChange = { practiceWords = it },
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    Text("$practiceWords Words", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    ProfileScreen()
}


@Composable
fun ProfileScreen1(
    navController: NavController,
) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.Person,
            "Person",
            Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Signup with google")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.Face, "Google")
        }
    }
}