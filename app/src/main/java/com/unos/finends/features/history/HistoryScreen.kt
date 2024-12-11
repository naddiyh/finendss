package com.unos.finends.features.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.unos.finends.R
import com.unos.finends.components.button.Bottom
import com.unos.finends.ui.theme.YelGreen

data class HistoryItem(
    val title: String,
    val timestamp: String,
    val amount: String,
    val baseAmount: String,
    val isIncome: Boolean,
    val iconRes: Int
)

@Composable
fun HistoryScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val historyList = listOf(
        HistoryItem(
            title = "Goes to seoul",
            timestamp = "09:30 AM",
            amount = "Rp 20.000.000",
            baseAmount = "Rp 7.000.000.000",
            isIncome = true,
            iconRes = R.drawable.tes
        ),
        HistoryItem(
            title = "Mobil Hrv",
            timestamp = "10:58 AM",
            amount = "Rp 10.000.000",
            baseAmount = "Rp 50.000.000",
            isIncome = false,
            iconRes = R.drawable.tes
        )
    )
    Surface(modifier = Modifier.fillMaxSize().fillMaxHeight().background(color = Color.White).padding(top = 40.dp, bottom = 20.dp)) {
        Box(modifier = Modifier.fillMaxSize().fillMaxHeight().background(color = Color.White)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back Button",
                        modifier = Modifier
                            .size(35.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                    Text(
                        text = "Savings History",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = YelGreen,
                        modifier = Modifier.weight(0.2f),
                        textAlign = TextAlign.Center

                    )
                }

                Text(
                    text = "2 November 2023",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(historyList) { item ->
                        HistoryItemView(item)
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(vertical = 16.dp)
            ) {
                Bottom(navController = navController)
            }
        }
    }
}

@Composable
fun HistoryItemView(item: HistoryItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()

            .clip(RoundedCornerShape(12.dp))
            .shadow(5.dp, RoundedCornerShape(12.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = item.iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(24.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.baseAmount,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = item.timestamp,
                fontSize = 12.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.amount,
                color = if (item.isIncome) Color(0xFF4CAF50) else Color(0xFFF44336),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}