package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Column() {
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        for (i in 1..7) {
                            Card()
                        }
                    }
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(1f))
                        Card(modifier = Modifier.size(80.dp))
                        Box(modifier = Modifier.weight(1f))
                        Card(modifier = Modifier.size(80.dp))
                        Box(modifier = Modifier.weight(1f))
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        for (i in 1..7) {
                            Card()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Card(
    modifier: Modifier = Modifier.size(width = 55.dp, height = 80.dp)
) {
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = null,
        modifier = modifier

    )
}
