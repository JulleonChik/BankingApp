package com.leon.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leon.bankingapp.data.Card
import com.leon.bankingapp.ui.theme.BlueEnd
import com.leon.bankingapp.ui.theme.BlueStart
import com.leon.bankingapp.ui.theme.GreenEnd
import com.leon.bankingapp.ui.theme.GreenStart
import com.leon.bankingapp.ui.theme.OrangeEnd
import com.leon.bankingapp.ui.theme.OrangeStart
import com.leon.bankingapp.ui.theme.PurpleEnd
import com.leon.bankingapp.ui.theme.PurpleStart

val cards = listOf(

    Card(
        cardType = "VISA",
        cardName = "Buisness",
        cardNumber = "4231 2345 2341 1232",
        balance = 42.056,
        color = getGradient(PurpleStart, PurpleEnd)
    ),

    Card(
        cardType = "MASTER CARD",
        cardName = "Savings",
        cardNumber = "4321 0045 0001 1224",
        balance = 2.567,
        color = getGradient(BlueStart, BlueEnd)
    ),

    Card(
        cardType = "VISA",
        cardName = "School",
        cardNumber = "4333 2356 2341 1200",
        balance = 4.006,
        color = getGradient(OrangeStart, OrangeEnd)
    ),

    Card(
        cardType = "MASTER CARD",
        cardName = "Trips",
        cardNumber = "4231 2345 2341 0003",
        balance = 10.036,
        color = getGradient(GreenStart, GreenEnd)
    ),
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}

@Preview(device = "id:pixel_6_pro")
@Composable
fun CardsSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
    index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1)
        lastItemPaddingEnd = 16.dp

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD")
        image = painterResource(id = R.drawable.ic_mastercard)

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = "$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }


}







