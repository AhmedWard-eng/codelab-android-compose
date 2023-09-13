package com.example.codelab_android_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab_android_compose.ui.theme.CodelabandroidcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodelabandroidcomposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp(Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen{
                shouldShowOnboarding = false
            }
        } else {
            Greetings()
        }
    }
}

@Composable
fun Greetings(modifier: Modifier = Modifier,
              names: List<String> = List(1000) { "$it" } ){
    Surface(
        modifier = modifier, color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(modifier.padding(4.dp)) {
            items(items =  names){
                Greeting(name = it)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isExpanded : Boolean by remember {
        mutableStateOf(false)
    }
    val extraPadding = if (isExpanded) 48.dp else 0.dp
    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {

        Row(modifier = modifier
            .padding(24.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier.padding(bottom = extraPadding)) {
                Text(
                    text = "Hello,"
                )
                Text(text = name)
            }
            ElevatedButton(onClick = { isExpanded = !isExpanded }) {
                Text(text = if (isExpanded)  "show less" else "Show more")
            }
        }

    }

}

//@Preview(showBackground = true, name = "Text preview", widthDp = 320)
//@Composable
//fun GreetingPreview() {
//    CodelabandroidcomposeTheme {
//        myApp()
//    }
//}

@Preview
@Composable
fun MyAppPreview() {
    CodelabandroidcomposeTheme {
        MyApp(Modifier.fillMaxSize())
    }
}


