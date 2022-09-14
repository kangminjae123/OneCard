package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                var winner: Player? by remember {
                    mutableStateOf(null)
                }
                val currentWinner = winner
                if (currentWinner == null) {
                    OneCardGameScreen(onGameOver = {
                        winner = it
                    })
                } else {
                    VictoryScreen(player = currentWinner)
                }
            }
        }
    }
}

@Composable
fun OneCardGameScreen(onGameOver: (Player) -> Unit) {
    var viewState by remember {
        mutableStateOf(OneCardViewState.createGame())
    }
    Column(Modifier.fillMaxSize()) {
        PlayerCard(player = viewState.player1, isNPC = true) {
            TODO()
        }
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f))
            CardView(Modifier.width(100.dp), viewState.openCards.last()) {
                // Nothing to do.
            }
            Box(modifier = Modifier.weight(1f))
            CardBackView(Modifier.width(100.dp)) {
                if (viewState.remainCards.isEmpty()) {
                    viewState = with(viewState) {
                        copy(
                            remainCards = openCards.subList(0, openCards.size - 1).shuffled(),
                            openCards = listOf(openCards.last())
                        )
                    }
                }

                val c = viewState.remainCards.take(1)
                viewState = viewState.copy(
                    player2 = viewState.player2.copy(
                        cards = viewState.player2.cards + c
                    ),
                    remainCards = viewState.remainCards - c
                )
                viewState = viewState.throwCardByNPC()
                if (viewState.player1.cards.isEmpty()) {
                    // 컴퓨터 승리 ㅠㅠ
                    onGameOver(viewState.player1)
                }

            }
            Box(modifier = Modifier.weight(1f))
        }
        PlayerCard(player = viewState.player2, isNPC = false) {
            val state = viewState.throwCard(it)
            if (state != null) { // 카드 제출한 경우
                viewState = state
                if (viewState.player2.cards.isEmpty()) {
                    // 플레이어 승리!!!!!
                    onGameOver(viewState.player2)
                } else {
                    viewState = viewState.throwCardByNPC()
                    if (viewState.player1.cards.isEmpty()) {
                        // 컴퓨터 승리 ㅠㅠ
                        onGameOver(viewState.player1)
                    }
                }
            } else {
                // Nothing to do.
            }
        }
    }
}

@Composable
fun PlayerCard(player: Player, isNPC: Boolean, onClick: (Card) -> Unit) {
    BoxWithConstraints(Modifier.fillMaxWidth()) {
        val cardWidth = maxWidth / 7
        val cards = player.cards.windowed(7, 7, partialWindows = true)
        Column {
            cards.forEach {
                Row {
                    it.forEach { card: Card ->
                        if (isNPC) {
                            CardBackView(Modifier.width(cardWidth)) {}
                        } else {
                            CardView(Modifier.width(cardWidth), card, onClick)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardView(modifier: Modifier = Modifier, card: Card, onClick: (Card) -> Unit) {
    Image(
        painter = painterResource(id = card.getDrawable()),
        contentDescription = null,
        modifier = modifier.clickable {
            Log.i("OneCard", "Clicked card type = ${card.type}, num ${card.num}")
            onClick(card)
        },
        contentScale = ContentScale.Fit
    )
}

@Composable
fun CardBackView(modifier: Modifier, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.backcard),
        contentDescription = null,
        modifier = modifier.clickable {
                onClick()
            },
        contentScale = ContentScale.Fit
    )
}
