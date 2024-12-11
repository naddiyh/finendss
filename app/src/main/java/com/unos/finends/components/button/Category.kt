package com.unos.finends.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unos.finends.ui.theme.YelGreen

@Composable
fun Category(
    onAllClick: () -> Unit = {  },
    onHolidaysClick: () -> Unit = {  },
    onCarsClick: () -> Unit = {  }
) {
    Row(

        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ) {
        Box(
            modifier = Modifier
                .height(25.dp)
                .wrapContentWidth()
                .border(BorderStroke(0.5.dp, YelGreen), shape = RoundedCornerShape(13.dp))
                .clickable { onAllClick() }.padding(horizontal = 14.dp),
            contentAlignment = Alignment.Center
                // Adjust padding inside the box
        ) {
            Text(
                text = "All",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
        }
        Box(
            modifier = Modifier
                .height(25.dp)
                .wrapContentWidth()
                .border(BorderStroke(0.5.dp, YelGreen), shape = RoundedCornerShape(13.dp))
                .clickable { onAllClick() }.padding(horizontal = 14.dp),
            contentAlignment = Alignment.Center // Adjust padding inside the box
        ) {
            Text(
                text = "Holidays",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
        }
        Box(
            modifier = Modifier
                .height(25.dp)
                .wrapContentWidth()
                .border(BorderStroke(0.5.dp, YelGreen), shape = RoundedCornerShape(13.dp))
                .clickable { onAllClick() }.padding(horizontal = 14.dp),
            contentAlignment = Alignment.Center// Adjust padding inside the box
        ) {
            Text(
                text = "Cars",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
            )
        }
    }
    }

