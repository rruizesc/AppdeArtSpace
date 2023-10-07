package com.example.carruselconfotoinformativa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carruselconfotoinformativa.ui.theme.CarruselConFotoInformativaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarruselConFotoInformativaTheme {
                CarruselConFotoInformativaApp()
                var result = (1..10).random();
                }
            }
        }
    }

@Composable
fun CarruselWithButtonImageAndDescription(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.foto_1
        2 -> R.drawable.foto_2
        3 -> R.drawable.foto_3
        4 -> R.drawable.foto_4
        5 -> R.drawable.foto_5
        6 -> R.drawable.foto_6
        7 -> R.drawable.foto_7
        8 -> R.drawable.foto_8
        9 -> R.drawable.foto_9
        else -> R.drawable.foto_10
    }
    val DescriptionImage = when (result) {
        1 -> ""
        2 -> ""
        3 -> ""
        4 -> ""
        5 -> ""
        6 -> ""
        7 -> ""
        8 -> ""
        9 -> ""
        else -> ""
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = DescriptionImage)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result=result ++ }) {
            Text(stringResource(R.string.app_name))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result=result -- }) {
            Text(stringResource(R.string.app_name))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarruselConFotoInformativaApp() {
    CarruselWithButtonImageAndDescription(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))


}