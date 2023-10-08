package com.example.carruselconfotoinformativa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.sp
import com.example.carruselconfotoinformativa.ui.theme.CarruselConFotoInformativaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val initialResult = (1..10).random()
        setContent {
            CarruselConFotoInformativaTheme {
                CarruselWithButtonImageAndDescription(initialResult)

                }
            }
        }
    }

@Composable
fun CarruselWithButtonImageAndDescription(initialResult: Int, modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(initialResult) }
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
    val imageSizeModifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
    val descriptionImage = when (result) {
        1 -> "Primera foto"
        2 -> "Segunda foto"
        3 -> "Tercera foto"
        4 -> "Cuarta foto"
        5 -> "Quinta foto"
        6 -> "Sexta foto"
        7 -> "Septima foto"
        8 -> "Octava foto"
        9 -> "Novena foto"
        else -> "Decima foto"
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = result.toString(),
            modifier = imageSizeModifier
        )
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = descriptionImage,
            fontSize = 30.sp,
            )

        Spacer(modifier = Modifier.height(100.dp))
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Button(
            onClick = { result = if(result == 1) 10 else result - 1 },
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.Previous_Button))
        }
        Spacer(modifier = Modifier.width(100.dp))

        Button(
            onClick = { result = if(result == 10) 1 else result + 1 },
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.Next_Button))
        }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarruselConFotoInformativaApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        CarruselWithButtonImageAndDescription(initialResult = 1, modifier = Modifier
            .align(Alignment.Center)
            .padding(16.dp)
        )
    }
}