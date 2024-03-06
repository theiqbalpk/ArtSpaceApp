package com.example.artspaceapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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
fun ArtSpaceApp() {
    val config = LocalConfiguration.current
    when (config.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            ArtSpaceAppDisplayLandscape()
        }
        else -> {
            ArtSpaceAppDisplayPortrait()
        }
    }
}

@Composable
fun ArtSpaceAppDisplayPortrait() {

    var artImage by remember { mutableIntStateOf(1) }
    var title by remember { mutableIntStateOf(1) }
    var authorAndYear by remember { mutableIntStateOf(1) }

    val imageResource = when(artImage) {
        1 -> R.drawable.first
        2 -> R.drawable.second
        3 -> R.drawable.third
        4 -> R.drawable.fourth
        5 -> R.drawable.fifth
        6 -> R.drawable.sixth
        else -> R.drawable.first
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
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(15.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.65F)
                .fillMaxWidth(1F)
                .border(BorderStroke(3.dp, SolidColor(Color.White)), RectangleShape)
                .shadow(15.dp, RectangleShape)
                .align(alignment = Alignment.CenterHorizontally),
            shape = RoundedCornerShape(5.dp),
            shadowElevation = 10.dp
        ) {
            ArtworkImage(
                imageResource = imageResource,
                contentDescription = titleString
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        ArtworkDescription(
            titleString = titleString,
            authorAndYearString = authorAndYearString
        )
        Spacer(modifier = Modifier.height(20.dp))
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
fun ArtSpaceAppDisplayLandscape() {

    var artImage by remember { mutableIntStateOf(1) }
    var title by remember { mutableIntStateOf(1) }
    var authorAndYear by remember { mutableIntStateOf(1) }

    val imageResource = when (artImage) {
        1 -> R.drawable.first
        2 -> R.drawable.second
        3 -> R.drawable.third
        4 -> R.drawable.fourth
        5 -> R.drawable.fifth
        6 -> R.drawable.sixth
        else -> R.drawable.first
    }

    val titleString = when (title) {
        1 -> R.string.TBourgeois
        2 -> R.string.THockney
        3 -> R.string.TKoons
        4 -> R.string.TWyeth
        5 -> R.string.TMagritte
        6 -> R.string.TDalí
        else -> R.string.TBourgeois
    }

    val authorAndYearString = when (authorAndYear) {
        1 -> R.string.LouiseBourgeois
        2 -> R.string.DavidHockney
        3 -> R.string.JeffKoons
        4 -> R.string.AndrewWyeth
        5 -> R.string.RenéMagritte
        6 -> R.string.SalvadorDalí
        else -> R.string.LouiseBourgeois
    }
    Row(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(0.35f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Surface(
                modifier = Modifier
                    .fillMaxHeight(0.65F)
                    .fillMaxWidth(1F)
                    .border(BorderStroke(3.dp, SolidColor(Color.White)), RectangleShape)
                    .shadow(15.dp, RectangleShape)
                    .align(alignment = Alignment.CenterHorizontally),
                shape = RoundedCornerShape(5.dp),
                shadowElevation = 10.dp
            ) {
                ArtworkImage(
                    imageResource = imageResource,
                    contentDescription = titleString
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            ArtworkDescription(
                titleString = titleString,
                authorAndYearString = authorAndYearString
            )
            Spacer(modifier = Modifier.height(20.dp))
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
}

@Composable
fun ArtworkImage(
    @DrawableRes imageResource: Int,
    @StringRes contentDescription: Int,
) {
    Image(
        painter = painterResource(imageResource),
        contentDescription = stringResource(contentDescription),
        contentScale = ContentScale.Crop,
        modifier = Modifier.padding(35.dp)
    )
}

@Composable
fun ArtworkDescription(
    @StringRes titleString: Int,
    @StringRes authorAndYearString: Int
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0xFFECEBF4)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(titleString),
                fontSize = 24.sp
                )
            
            val authorAndYearText = stringResource(authorAndYearString)

            val startIndex = authorAndYearText.indexOf('(')
            val endIndex = authorAndYearText.indexOf(')')

            val author = authorAndYearText.substring(0, startIndex).trim()
            val year = authorAndYearText.substring(startIndex + 1, endIndex)

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(author)
                    }
                    append(" ($year)")
                },
                fontSize = 14.sp
            )
        }
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
    lastImage: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
            if (artImage != 1 && title != 1 && authorAndYear != 1) {
                previousImage(artImage)
            } else if ((artImage == 1 && title == 1 && authorAndYear == 1)) {
                lastImage(artImage)
            }
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color(73, 93, 146)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                text = "Previous",
                color = Color.White
            )
        }
        Button(
            onClick = {
                if (artImage != 6 && title != 6 && authorAndYear != 6) {
                    nextImage(artImage)
                } else if ((artImage == 6 && title == 6 && authorAndYear == 6)) {
                    firstImage(artImage)
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(73, 93, 146)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                text = "Next",
                color = Color.White
            )
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