package com.example.carruselconfotoinformativa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtMost
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
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
    val descriptionImage = when (result) {
        1 -> stringResource(R.string.descripcion_primera)
        2 -> stringResource(R.string.descripcion_segunda)
        3 -> stringResource(R.string.descripcion_tercera)
        4 -> stringResource(R.string.descripcion_cuarta)
        5 -> stringResource(R.string.descripcion_quinta)
        6 -> stringResource(R.string.descripcion_sexta)
        7 -> stringResource(R.string.descripcion_septima)
        8 -> stringResource(R.string.descripcion_octava)
        9 -> stringResource(R.string.descripcion_novena)
        else -> stringResource(R.string.descripcion_decima)
    }
    val cityAndYear = when (result){
        1 -> stringResource(R.string.ciudad_primera)
        2 -> stringResource(R.string.ciudad_segunda)
        3 -> stringResource(R.string.ciudad_tercera)
        4 -> stringResource(R.string.ciudad_cuarta)
        5 -> stringResource(R.string.ciudad_quinta)
        6 -> stringResource(R.string.ciudad_sexta)
        7 -> stringResource(R.string.ciudad_septima)
        8 -> stringResource(R.string.ciudad_octava)
        9 -> stringResource(R.string.ciudad_novena)
        else -> stringResource(R.string.ciudad_decima)
    }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val buttonSize = (screenWidth / 4).coerceAtMost(50.dp)
    val imageSize = screenWidth.coerceIn(0.dp, 300.dp)

    val imageSizeModifier = Modifier
        .fillMaxWidth()
        .height(imageSize)

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(Color(0x660000FF))
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = result.toString(),
                modifier = imageSizeModifier
            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        Box(
            modifier = Modifier
                .background(Color(0x660000FF))
                .padding(16.dp)
        ) {
            Column {


                Text(
                    text = descriptionImage,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = cityAndYear,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(200.dp))
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(buttonSize),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Button(
            onClick = { result = if(result == 1) 10 else result - 1 },
            modifier = Modifier
                .weight(1f)
                .height(buttonSize)
        ) {
            Text(stringResource(R.string.Previous_Button))
        }
        Spacer(modifier = Modifier.width(150.dp))

        Button(
            onClick = { result = if(result == 10) 1 else result + 1 },
            modifier = Modifier
                .weight(1f)
                .height(buttonSize)
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