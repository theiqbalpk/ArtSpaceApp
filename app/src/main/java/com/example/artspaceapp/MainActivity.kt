package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtImageWithTitle(
    imageResource: Int,
    textResource: String,
    titleResource: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .height(350.dp)
                .width(300.dp)
                .shadow(elevation = 4.dp, shape = RectangleShape)
                .padding(20.dp)
        )
        Card(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 100.dp)
                .shadow(elevation = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                ) {
                    Text(
                        text = titleResource,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = textResource,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                0.dp,
                alignment = Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .padding(bottom = 30.dp)
        ) {
            Button(
                onClick = {  },
                modifier = Modifier
                    .padding(start = 50.dp, end = 50.dp)
            ) {
                Text(
                    text = "Previous"
                )
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .padding(start = 50.dp, end = 50.dp)
            ) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var result by remember { mutableStateOf(0) }

    when(result) {
        1 -> ArtImageWithTitle(
            imageResource = R.drawable.bourgeois,
            textResource = stringResource(id = R.string.LouiseBourgeois),
            titleResource = stringResource(id = R.string.TBourgeois)
        )
        2-> ArtImageWithTitle(
            imageResource = R.drawable.hockney,
            textResource = stringResource(id = R.string.DavidHockney),
            titleResource = stringResource(id = R.string.THockney)
        )
        3 -> ArtImageWithTitle(
            imageResource = R.drawable.koons,
            textResource = stringResource(id = R.string.JeffKoons),
            titleResource = stringResource(id = R.string.TKoons)
        )
        4 -> ArtImageWithTitle(
            imageResource = R.drawable.imagechristina,
            textResource = stringResource(id = R.string.AndrewWyeth),
            titleResource = stringResource(id = R.string.TWyeth)
        )
        5 -> ArtImageWithTitle(
            imageResource = R.drawable.lovers,
            textResource = stringResource(id = R.string.RenéMagritte),
            titleResource = stringResource(id = R.string.TMagritte)
        )
        else -> ArtImageWithTitle(
            imageResource = R.drawable.memorysalvordali,
            textResource = stringResource(id = R.string.SalvadorDalí),
            titleResource = stringResource(id = R.string.TDalí)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}