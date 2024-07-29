package com.leon.bankingapp.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType:String,
    val cardName:String,
    val cardNumber:String,
    val balance:Double,
    val color:Brush
)
