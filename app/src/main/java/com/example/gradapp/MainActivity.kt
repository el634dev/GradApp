package com.example.gradapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gradapp.ui.theme.GradAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GradAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GradScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GradScreen(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(true)}
    val color = if (isChecked) Color(color = 0xff00ff00) else Color.Transparent

    Column(
        modifier = Modifier.fillMaxHeight().background(color),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Text(
            text = "Graduation Announcement",
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            color = Color.Red,
            modifier = modifier
        )
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            }
        )
        Image(
            painter = painterResource(id = R.drawable.grad_cap),
            contentDescription = "Graduation Cap",
            alpha = 0.3f
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon (
                imageVector = Icons.Filled.Info,
                contentDescription = "Information",
                tint = Color.Gray,
                modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)
            )
            Text (
                text = "May 14 - Ganus Hall - 2:00pm",
                fontSize = 20.sp
            )
        }
        Rsvp()
    }
}

@Composable
fun Rsvp(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(true)}
    val message = if (isChecked) "I'll be there!" else "Sorry I can't be there."

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
            }
        )
        Text(
            text = message,
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GradAppPreview() {
    GradAppTheme {
        GradScreen()
    }
}