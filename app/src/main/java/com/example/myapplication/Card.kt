package com.example.myapplication

import androidx.annotation.DrawableRes

val cardDeck: List<Card> = CardType.values().map { cardType ->
    CardNumber.values().map { cardNumber ->
        Card(cardType, cardNumber)
    }
}.flatten()

enum class CardNumber {
    Num2, Num3, Num4, Num5,
    Num6, Num7, Num8, Num9,
    Num10, Jack, Queen, King, Ace
}

data class Card(
    val type: CardType,
    val num: CardNumber
) {

    @DrawableRes
    fun getDrawable(): Int {
        return when (type) {

            CardType.Heart -> {
                when (num) {
                    CardNumber.Num2 -> R.drawable.of_hearts_2
                    CardNumber.Num3 -> R.drawable.of_hearts_3
                    CardNumber.Num4 -> R.drawable.of_hearts_4
                    CardNumber.Num5 -> R.drawable.of_hearts_5
                    CardNumber.Num6 -> R.drawable.of_hearts_6
                    CardNumber.Num7 -> R.drawable.of_hearts_7
                    CardNumber.Num8 -> R.drawable.of_hearts_8
                    CardNumber.Num9 -> R.drawable.of_hearts_9
                    CardNumber.Num10 -> R.drawable.of_hearts_10
                    CardNumber.Jack -> R.drawable.jack_of_hearts2
                    CardNumber.Queen -> R.drawable.queen_of_hearts2
                    CardNumber.King -> R.drawable.king_of_hearts2
                    CardNumber.Ace -> R.drawable.ace_of_hearts
                }
            }
            CardType.Diamond -> {
                when (num) {
                    CardNumber.Num2 -> R.drawable.of_diamonds_2
                    CardNumber.Num3 -> R.drawable.of_diamonds_3
                    CardNumber.Num4 -> R.drawable.of_diamonds_4
                    CardNumber.Num5 -> R.drawable.of_diamonds_5
                    CardNumber.Num6 -> R.drawable.of_diamonds_6
                    CardNumber.Num7 -> R.drawable.of_diamonds_7
                    CardNumber.Num8 -> R.drawable.of_diamonds_8
                    CardNumber.Num9 -> R.drawable.of_diamonds_9
                    CardNumber.Num10 -> R.drawable.of_diamonds_10
                    CardNumber.Jack -> R.drawable.jack_of_diamonds2
                    CardNumber.Queen -> R.drawable.queen_of_diamonds2
                    CardNumber.King -> R.drawable.king_of_diamonds2
                    CardNumber.Ace -> R.drawable.ace_of_diamonds
                }
            }
            CardType.Spade -> {
                when (num) {
                    CardNumber.Num2 -> R.drawable.of_spades_2
                    CardNumber.Num3 -> R.drawable.of_spades_3
                    CardNumber.Num4 -> R.drawable.of_spades_4
                    CardNumber.Num5 -> R.drawable.of_spades_5
                    CardNumber.Num6 -> R.drawable.of_spades_6
                    CardNumber.Num7 -> R.drawable.of_spades_7
                    CardNumber.Num8 -> R.drawable.of_spades_8
                    CardNumber.Num9 -> R.drawable.of_spades_9
                    CardNumber.Num10 -> R.drawable.of_spades_10
                    CardNumber.Jack -> R.drawable.jack_of_spades2
                    CardNumber.Queen -> R.drawable.queen_of_spades2
                    CardNumber.King -> R.drawable.king_of_spades2
                    CardNumber.Ace -> R.drawable.ace_of_spades
                }
            }
            CardType.Club -> {
                when (num) {
                    CardNumber.Num2 -> R.drawable.of_clubs_2
                    CardNumber.Num3 -> R.drawable.of_clubs_3
                    CardNumber.Num4 -> R.drawable.of_clubs_4
                    CardNumber.Num5 -> R.drawable.of_clubs_5
                    CardNumber.Num6 -> R.drawable.of_clubs_6
                    CardNumber.Num7 -> R.drawable.of_clubs_7
                    CardNumber.Num8 -> R.drawable.of_clubs_8
                    CardNumber.Num9 -> R.drawable.of_clubs_9
                    CardNumber.Num10 -> R.drawable.of_clubs_10
                    CardNumber.Jack -> R.drawable.jack_of_clubs2
                    CardNumber.Queen -> R.drawable.queen_of_clubs2
                    CardNumber.King -> R.drawable.king_of_clubs2
                    CardNumber.Ace -> R.drawable.ace_of_clubs
                }
            }
        }
    }

}


enum class CardType {
    Heart, Diamond, Spade, Club
}

