package com.unos.finends.ui.theme

import ProgressBarWithLabel
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable


fun BoxTracker (
    title: String,    // Title of the box
    totalAmount: String,    // Total amount to display
    currentAmount: String,  // Current amount to display
    progress: Float
){
    Column(modifier = Modifier
        .fillMaxHeight(0.26f)
        .border(
            width = 1.dp,
            color = Color.LightGray,
            shape = RoundedCornerShape(10.dp)
        )) {
        Column (modifier = Modifier.padding(15.dp)){
            Text(text = "$title", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(2.dp))
            ProgressBarWithLabel(progress = progress)

            Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(50.dp)){
                Column {
                    Text(text = "Total", fontSize = 12.sp)
                    Text(text = " Rp $totalAmount", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }

                Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Current", fontSize = 12.sp)
                    Text(text = " Rp $currentAmount", fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }

            }


        }

    }
}