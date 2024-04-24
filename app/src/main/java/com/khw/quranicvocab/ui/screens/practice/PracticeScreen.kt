package com.khw.quranicvocab.ui.screens.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.khw.quranicvocab.R
import com.khw.quranicvocab.data.model.Vocab
import com.khw.quranicvocab.ui.screens.practice.viewModel.PracticeViewModel

@Composable
fun PracticeScreen(
    navController: NavController,
    viewModel: PracticeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value

    fun done() {

    }

    fun needPractice() {

    }

    fun reset() {

    }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (state.vocab.meanings.isNotEmpty()) {
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
            ) {
                Text(
                    text = "You practiced ${state.doneCount} words",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Progress(modifier = Modifier.padding(top = 10.dp))
            Text(
                "Today's Target",
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.weight(0.2f))
            Vocab(vocab = state.vocab)
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier
                    .defaultMinSize(minWidth = 120.dp)
                    .fillMaxWidth(0.6f),
                shape = RoundedCornerShape(10.dp),
                onClick = { done() }
            ) {
                Text(
                    text = stringResource(id = R.string.check),
                    fontWeight = FontWeight.W500
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
        } else {
            Text(text = stringResource(id = R.string.need_practice))
        }
    }
}

@Composable
fun Vocab(vocab: Vocab) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = vocab.word,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.W500
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = vocab.meanings,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.W500,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun Progress(modifier: Modifier) {
    Box(
        modifier = modifier.wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            progress = { 0.5f },
            color = Color.Green,
            trackColor = Color.LightGray,
            strokeWidth = 10.dp
        )
        Text(text = "10/20",style = MaterialTheme.typography.bodySmall)
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