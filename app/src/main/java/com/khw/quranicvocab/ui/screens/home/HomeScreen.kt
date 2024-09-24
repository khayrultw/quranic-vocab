package com.khw.quranicvocab.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.khw.quranicvocab.R
import com.khw.quranicvocab.ui.navigation.Screen
import com.khw.quranicvocab.ui.screens.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val learnCount = viewModel.state.collectAsStateWithLifecycle().value

    fun navigateToPractice() {
        navController.navigate(Screen.Practice.route)
    }

    fun navigateToLearn() {
        navController.navigate(Screen.Learn.route)
    }


    ConstraintLayout {
        val (header, buttons) = createRefs()

        Column(
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top, 20.dp)
                start.linkTo(parent.start, 0.dp)
                end.linkTo(parent.end, 0.dp)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Icon(Icons.Default.LocalFireDepartment, contentDescription = "Fire")
                Text(text = "20", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "You learned $learnCount words",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Column(
            modifier = Modifier
                .constrainAs(buttons) {
                    top.linkTo(header.bottom)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            VocabButton(
                title = "Learn",
                icon = R.drawable.ic_learn,
                onClick = { navigateToLearn() }
            )
            Spacer(modifier = Modifier.height(16.dp))
            VocabButton(
                title = "Practice",
                icon = R.drawable.ic_practice,
                onClick = { navigateToPractice() }
            )
            Spacer(modifier = Modifier.height(16.dp))
            VocabButton(
                title = "Review",
                icon = R.drawable.ic_review,
                onClick = { }
            )
        }
    }
}

@Composable
fun VocabButton(title: String, icon: Int, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier.defaultMinSize(minWidth = 160.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = { onClick() }
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = title.uppercase())
    }
}
