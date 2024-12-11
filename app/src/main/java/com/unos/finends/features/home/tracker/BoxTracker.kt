package com.unos.finends.features.home.tracker

import ProgressBarWithLabel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.unos.finends.R
import com.unos.finends.features.home.AddSavingsScreen


@Composable
fun BoxTracker(
    title: String,
    totalAmount: String,
    currentAmount: String,
    progress: Float,
    imageResId: Int,
    onAddClick: () -> Unit,
    navController: NavHostController,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.3f)
            .shadow(5.dp, RoundedCornerShape(12.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                painter = painterResource(id = imageResId),
                contentDescription = null
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                ProgressBarWithLabel(progress = progress)
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(50.dp)
//                ) {
//                    Column {
//                        Text(text = "Current", fontSize = 12.sp)
//                        Text(text = "Rp $currentAmount", fontSize = 12.sp, fontWeight = FontWeight.Medium)
//                    }
//                }
            }
            Row (modifier = Modifier.fillMaxHeight(), horizontalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Image(
                    modifier = Modifier
                        .size(28.dp)
                        .padding(start = 10.dp),
                    painter = painterResource(id = R.drawable.pin) ,
                    contentDescription = null
                )
                Image(
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            navController.navigate("AddSavingsScreen/goalName/currentAmount")
                        },
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null
                )

            }
        }
    }
}
