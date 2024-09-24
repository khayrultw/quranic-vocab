package com.khw.quranicvocab.ui.screens.practice

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.khw.quranicvocab.ui.composables.OutlineButtonQ
import com.khw.quranicvocab.ui.composables.ProgressCircleQ

@Composable
fun PracticeScreen(
    navController: NavController = rememberNavController()
) {
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var isAnswerChecked by remember { mutableStateOf(false) }
    var isAnswerCorrect by remember { mutableStateOf(false) }

    val answers = listOf("The Travelers", "The Believers", "Seek Forgiveness")
    val correctAnswer = "The Believers"

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
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "You've practiced 10 words",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProgressCircleQ(current = 10, total = 20)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Today's Target",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.weight(0.4f))

            Text(
                "المُؤمِنون",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            answers.forEach { answer ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (answer == selectedAnswer),
                            onClick = { selectedAnswer = answer }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (answer == selectedAnswer),
                        onClick = { selectedAnswer = answer },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = when {
                                isAnswerChecked && answer == correctAnswer -> Color.Green
                                isAnswerChecked && answer == selectedAnswer && !isAnswerCorrect -> Color.Red
                                else -> Color.Blue
                            }
                        )
                    )
                    Text(
                        text = answer,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(0.6f))

            OutlineButtonQ(
                onClick = {
                    isAnswerChecked = true
                    isAnswerCorrect = selectedAnswer == correctAnswer
                },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(56.dp),
                color = when {
                    !isAnswerChecked -> Color(0xFF2196F3)
                    isAnswerCorrect -> Color.Green
                    else -> Color.Red
                }

            ) {
                Text(
                    when {
                        !isAnswerChecked -> "Check"
                        isAnswerCorrect -> "Next"
                        else -> "Try Again"
                    },
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview
@Composable
fun PracticePreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        PracticeScreen(navController = rememberNavController())
    }
}

//
//@Composable
//fun PracticeScreen1(
//    navController: NavController,
//    viewModel: PracticeViewModel = hiltViewModel()
//) {
//    val state = viewModel.state.collectAsStateWithLifecycle().value
//
//    fun done() {
//
//    }
//
//    fun needPractice() {
//
//    }
//
//    fun reset() {
//
//    }
//
//    Column(
//        modifier = Modifier.fillMaxSize().padding(20.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        if (state.vocab.meanings.isNotEmpty()) {
//            TextButton(
//                onClick = { /*TODO*/ },
//                modifier = Modifier
//            ) {
//                Text(
//                    text = "You practiced ${state.doneCount} words",
//                    style = MaterialTheme.typography.titleMedium
//                )
//            }
//            ProgressCircle(progress = 0.5f)
//
//            Text(
//                "Today's Target",
//                modifier = Modifier.padding(top = 10.dp),
//                style = MaterialTheme.typography.bodyMedium
//            )
//            Spacer(modifier = Modifier.weight(0.2f))
//            Vocab(vocab = state.vocab)
//            Spacer(modifier = Modifier.weight(1f))
//            OutlinedButton(
//                modifier = Modifier
//                    .defaultMinSize(minWidth = 120.dp)
//                    .fillMaxWidth(0.6f),
//                shape = RoundedCornerShape(10.dp),
//                onClick = { done() }
//            ) {
//                Text(
//                    text = stringResource(id = R.string.check),
//                    fontWeight = FontWeight.W500
//                )
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//        } else {
//            Text(text = stringResource(id = R.string.need_practice))
//        }
//    }
//}
//
//@Composable
//fun Vocab(vocab: Vocab) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Spacer(modifier = Modifier.height(20.dp))
//        Text(
//            text = vocab.word,
//            style = MaterialTheme.typography.titleLarge,
//            fontWeight = FontWeight.W500
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(
//            text = vocab.meanings,
//            style = MaterialTheme.typography.bodyLarge,
//            fontWeight = FontWeight.W500,
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//    }
//}
//
//
//@Composable
//fun ProgressCircle(progress: Float) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.size(100.dp)
//    ) {
//        Canvas(modifier = Modifier.size(100.dp)) {
//            drawArc(
//                color = Color.LightGray,
//                startAngle = 0f,
//                sweepAngle = 360f,
//                useCenter = false,
//                style = Stroke(width = 15f, cap = StrokeCap.Round),
//                size = Size(size.width, size.height)
//            )
//            drawArc(
//                color = Color(0xFF4CAF50),
//                startAngle = -90f,
//                sweepAngle = 360f * progress,
//                useCenter = false,
//                style = Stroke(width = 15f, cap = StrokeCap.Round),
//                size = Size(size.width, size.height)
//            )
//        }
//        Text(
//            text = "10/20",
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Bold
//        )
//    }
//}
//
//@Composable
//fun Progress(modifier: Modifier) {
//    Box(
//        modifier = modifier.wrapContentSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        CircularProgressIndicator(
//            modifier = Modifier
//                .width(100.dp)
//                .height(100.dp),
//            progress = { 0.5f },
//            color = Color.Green,
//            trackColor = Color.LightGray,
//            strokeWidth = 10.dp
//        )
//        Text(text = "10/20",style = MaterialTheme.typography.bodySmall)
//    }
//}
//
