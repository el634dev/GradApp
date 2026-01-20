package com.example.gradapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
    Text(
        text = "Graduation Announcement",
        textAlign = TextAlign.Center,
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 50.sp,
        color = Color.Red,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GradAppPreview() {
    GradAppTheme {
        GradScreen()
    }
}