package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
fun ArtSpaceApp() {

    var artImage by remember { mutableStateOf(1) }
    var title by remember { mutableStateOf(1) }
    var authorAndYear by remember { mutableStateOf(1) }

    val imageResource = when(artImage) {
        1 -> R.drawable.bourgeois
        2 -> R.drawable.hockney
        3 -> R.drawable.koons
        4 -> R.drawable.imagechristina
        5 -> R.drawable.lovers
        6 -> R.drawable.memorysalvordali
        else -> R.drawable.bourgeois
    }

    val titleString = when(title) {
        1 -> R.string.TBourgeois
        2 -> R.string.THockney
        3 -> R.string.TKoons
        4 -> R.string.TWyeth
        5 -> R.string.TMagritte
        6 -> R.string.TDalí
        else -> R.string.TBourgeois
    }

    val authorAndYearString = when(authorAndYear) {
        1 -> R.string.LouiseBourgeois
        2 -> R.string.DavidHockney
        3 -> R.string.JeffKoons
        4 -> R.string.AndrewWyeth
        5 -> R.string.RenéMagritte
        6 -> R.string.SalvadorDalí
        else -> R.string.LouiseBourgeois
    }

    Column {
        ArtworkImage(
            imageResource = imageResource,
            contentDescription = titleString
        )
        ArtworkDescription(
            titleString = titleString,
            authorAndYearString = authorAndYearString
        )
        ArtworkButton(
            artImage = artImage,
            title = title,
            authorAndYear = authorAndYear,
            previousImage = {
                artImage -= 1
                title -= 1
                authorAndYear -= 1
            },
            nextImage = {
                artImage += 1
                title += 1
                authorAndYear += 1
            },
            firstImage = {
                artImage = 1
                title = 1
                authorAndYear = 1
            }
        ) {
            artImage = 6
            title = 6
            authorAndYear = 6
        }
    }
}

@Composable
fun ArtworkImage(
    @DrawableRes imageResource: Int,
    @StringRes contentDescription: Int
) {
    Image(
        painter = painterResource(imageResource),
        contentDescription = stringResource(contentDescription)
    )
}

@Composable
fun ArtworkDescription(
    @StringRes titleString: Int,
    @StringRes authorAndYearString: Int
) {
    Column {
        Text(text = stringResource(titleString))
        Text(text = stringResource(authorAndYearString))
    }
}

@Composable
fun ArtworkButton(
    artImage: Int,
    title: Int,
    authorAndYear: Int,
    previousImage: (Int) -> Unit,
    nextImage: (Int) -> Unit,
    firstImage: (Int) -> Unit,
    lastImage: (Int) -> Unit
) {
    Row {
        Button(
            onClick = {
            if (artImage != 1 && title != 1 && authorAndYear != 1) {
                previousImage(artImage)
            } else if ((artImage == 1 && title == 1 && authorAndYear == 1)) {
                lastImage(artImage)
            }
        }
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = {
                if (artImage != 6 && title != 6 && authorAndYear != 6) {
                    nextImage(artImage)
                } else if ((artImage == 6 && title == 6 && authorAndYear == 6)) {
                    firstImage(artImage)
                }
            }
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}