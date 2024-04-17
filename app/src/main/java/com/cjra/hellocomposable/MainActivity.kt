package com.cjra.hellocomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

val colorList = listOf(
    Color.Red,
    Color.Yellow,
    Color.Black,
    Color.Cyan,
    Color.DarkGray,
    Color.Magenta,
    Color.Green
)

const val buttonName = "I like"

@Preview(showBackground = true)
@Composable
fun Content() {
    var likes by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = 5.dp)
    ) {
        TextComposable(text = "Welcome")
        SpaceComposable()
        TextComposable(text = "Jetpack")
        SpaceComposable()
        TextComposable(text = "Compose")
        SpaceComposable()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(colorList) { item ->
                Circle(color = item)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        SpaceComposable()
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                likes++
            }) {
                Text(text = buttonName)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Result(likes = likes)
        }
    }
}

@Composable
fun Result(likes: Int) {
    Text(
        text = likes.toString(),
        fontWeight = FontWeight.Bold,
        fontSize = 50.sp
    )
}

@Composable
fun SpaceComposable() {
    Spacer(modifier = Modifier.height(5.dp))
}

@Composable
fun Circle(color: Color) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(color = color, CircleShape)
    )
}

@Composable
fun TextComposable(text: String) {
    Text(
        text = text,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .clickable {
                println("Hello Jetpack")
            }
    )
}