package com.android.study.ui.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.study.MainViewModel

@Composable
fun Number(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val number by viewModel.numberState.collectAsState()

    Text(
        modifier = modifier,
        text = number.toString(),
        style = MaterialTheme.typography.headlineMedium
    )
}