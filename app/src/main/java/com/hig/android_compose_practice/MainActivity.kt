package com.hig.android_compose_practice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hig.android_compose_practice.ui.theme.Android_compose_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_compose_practiceTheme {

                RowAndColumn()
            }
        }
    }
}

@Composable
fun RowAndColumn() {
    Column {
        FirstRow()
        SecondRow()
    }
}

@Composable
fun FirstRow() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(Alignment.Top)
        .background(Color.Cyan)
    ) {
        FirstRowFirstColumn()
        FirstRowSecondColumn()
    }
}

@Composable
fun FirstRowFirstColumn() {
    val lContext = LocalContext.current

    Column(
        Modifier
            .width(IntrinsicSize.Max)
            .clickable {
                Toast
                    .makeText(lContext, "Column is clicked.", Toast.LENGTH_SHORT)
                    .show()
            }
            .background(Color.Red),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "First Row First Column First View", color = Color.Blue)
        Spacer(
            modifier = Modifier
                .fillMaxWidth(1.0f)
                .background(Color.Yellow)
                .height(50.dp)
        )
        Text(text = "First Row First Column Third View", color = Color.DarkGray)
        Button(
            shape = MaterialTheme.shapes.medium,
            onClick = {
                Toast.makeText(lContext, "Button is clicked", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Button")
        }
    }
}

@Composable
fun FirstRowSecondColumn() {
    Column(modifier = Modifier
        .width(IntrinsicSize.Max)
    ) {
        Text("Second Col")
    }
}

@Composable
fun SecondRow() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(Alignment.Top)
        .background(Color.Magenta)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
        ) {
            Text("Second Row")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Android_compose_practiceTheme {
        RowAndColumn()
    }
}