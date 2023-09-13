package com.example.codelab_android_compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab_android_compose.ui.theme.CodelabandroidcomposeTheme


@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked : ()-> Unit) {

    Column(
        verticalArrangement = Arrangement.Center,
    horizontalAlignment =  Alignment.CenterHorizontally,
    ) {
        Text(text = "Welcome to the Basics Codelab!")
        Button(modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked) {
            Text(text = "Continue")
        }
    }

}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    CodelabandroidcomposeTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}