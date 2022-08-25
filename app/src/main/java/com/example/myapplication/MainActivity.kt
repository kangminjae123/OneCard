package com.example.myapplication

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
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
                val player1 = Player(listOf(
                    Card(CardType.Club,2),
                    Card(CardType.Heart,3),
                    Card(CardType.Spade,4),
                ))
                val player2 = Player(listOf(
                    Card(CardType.Diamond, 6),
                    Card(CardType.Heart, 2),
                    Card(CardType.Club, 5),
                ))

                Column() {
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        for (i in 1..7) {
                            Card(R.drawable.backcard)
                        }
                    }
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(1f))
                        Card(R.drawable.ace_of_spades2, modifier = Modifier.size(80.dp))
                        Box(modifier = Modifier.weight(1f))
                        Card(R.drawable.backcard ,modifier = Modifier.size(80.dp))
                        Box(modifier = Modifier.weight(1f))
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        player2.cards.forEach { card: Card ->
                            Card(resId = card.getDrawable())
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Card(
    @DrawableRes resId: Int
    ,modifier: Modifier = Modifier.size(width = 55.dp, height = 80.dp)
) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        modifier = modifier

    )
}
