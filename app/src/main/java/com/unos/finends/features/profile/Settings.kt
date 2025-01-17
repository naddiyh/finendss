package com.unos.finends.features.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unos.finends.ui.theme.SoftGray


@Composable
fun Settings (){



    Column(verticalArrangement = Arrangement.spacedBy(6.dp)){

        Text(text = "Settings", fontSize = 14.sp, fontWeight = FontWeight.Normal
            , modifier = Modifier.padding(horizontal = 10.dp), )
        Column( modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(15.dp),
                clip = false,
                spotColor = Color.Black.copy(alpha = 0.3f)
            )
            .background(Color.White, RoundedCornerShape(15.dp))
            .padding(horizontal = 14.dp, vertical = 10.dp)
            , verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(text = "Password Reset",fontSize = 14.sp, fontWeight = FontWeight.Normal)

            HorizontalDivider(thickness = 0.4.dp, color = SoftGray)
            Text(text = "Bank Connection",fontSize = 14.sp, fontWeight = FontWeight.Normal)
        }
    }
}