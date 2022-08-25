package com.example.myapplication

import androidx.annotation.DrawableRes
import java.lang.IllegalArgumentException

data class Card(
    val type: CardType,
    val num: Int
){

    @DrawableRes
    fun getDrawable():Int{
        return when(type){
            CardType.Heart -> {
                when(num){
                    2 -> R.drawable.of_hearts_2
                    3 -> R.drawable.of_hearts_3
                    4 -> R.drawable.of_hearts_4
                    5 -> R.drawable.of_hearts_5
                    6 -> R.drawable.of_hearts_6
                    7 -> R.drawable.of_hearts_7
                    8 -> R.drawable.of_hearts_8
                    9 -> R.drawable.of_hearts_9
                    10 -> R.drawable.of_hearts_10
                    11 -> R.drawable.jack_of_hearts
                    12 -> R.drawable.queen_of_hearts
                    13 -> R.drawable.king_of_hearts
                    14 -> R.drawable.ace_of_hearts
                    else -> throw IllegalArgumentException()
                }
            }
            CardType.Diamond -> {
                when(num){
                    2 -> R.drawable.of_diamonds_2
                    3 -> R.drawable.of_diamonds_3
                    4 -> R.drawable.of_diamonds_4
                    5 -> R.drawable.of_diamonds_5
                    6 -> R.drawable.of_diamonds_6
                    7 -> R.drawable.of_diamonds_7
                    8 -> R.drawable.of_diamonds_8
                    9 -> R.drawable.of_diamonds_9
                    10 -> R.drawable.of_diamonds_10
                    11 -> R.drawable.jack_of_diamonds
                    12 -> R.drawable.queen_of_diamonds
                    13 -> R.drawable.king_of_diamonds
                    14 -> R.drawable.ace_of_diamonds
                    else -> throw IllegalArgumentException()
                }
            }
            CardType.Spade -> {
                when(num){
                    2 -> R.drawable.of_spades_2
                    3 -> R.drawable.of_spades_3
                    4 -> R.drawable.of_spades_4
                    5 -> R.drawable.of_spades_5
                    6 -> R.drawable.of_spades_6
                    7 -> R.drawable.of_spades_7
                    8 -> R.drawable.of_spades_8
                    9 -> R.drawable.of_spades_9
                    10 -> R.drawable.of_spades_10
                    11 -> R.drawable.jack_of_spades
                    12 -> R.drawable.queen_of_spades
                    13 -> R.drawable.king_of_spades
                    14 -> R.drawable.ace_of_spades
                    else -> throw IllegalArgumentException()
                }
            }
            CardType.Club -> {
                when(num){
                    2 -> R.drawable.of_clubs_2
                    3 -> R.drawable.of_clubs_3
                    4 -> R.drawable.of_clubs_4
                    5 -> R.drawable.of_clubs_5
                    6 -> R.drawable.of_clubs_6
                    7 -> R.drawable.of_clubs_7
                    8 -> R.drawable.of_clubs_8
                    9 -> R.drawable.of_clubs_9
                    10 -> R.drawable.of_clubs_10
                    11 -> R.drawable.jack_of_clubs
                    12 -> R.drawable.queen_of_clubs
                    13 -> R.drawable.king_of_clubs
                    14 -> R.drawable.ace_of_clubs

                    else -> throw IllegalArgumentException()
                }
            }
        }
    }
}

enum class CardType{
    Heart, Diamond, Spade, Club
}