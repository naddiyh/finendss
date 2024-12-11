package com.unos.finends.features.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ripple
import com.unos.finends.R
import com.unos.finends.ui.theme.SoftGray


@Composable
fun Notification() {
    val (isNotificationsEnabled, setNotificationsEnabled) = remember { mutableStateOf(true) }
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)){
        Text(text = "Notifications", fontSize = 14.sp, fontWeight = FontWeight.Normal
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
        , verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Push Notification",fontSize = 14.sp, fontWeight = FontWeight.Normal)
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                        onClick = { setNotificationsEnabled(!isNotificationsEnabled) }
                    )

            ) {
                Icon(
                    painter = painterResource(
                        id = if (isNotificationsEnabled) R.drawable.turnonnotif else R.drawable.turnoffnotif
                    ),
                    contentDescription = if (isNotificationsEnabled) "Disable Notifications" else "Enable Notifications",
                    tint = Color.Unspecified,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        HorizontalDivider(thickness = 0.4.dp, color = SoftGray)
        Row (   modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
            ){
        Text(text = "Goal Milestone Alerts",fontSize = 14.sp, fontWeight = FontWeight.Normal)
    }}}
}
