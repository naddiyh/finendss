package com.unos.finends.features.bucket

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.unos.finends.R
import com.unos.finends.ui.theme.YelGreen

@Composable
fun NewGoalBucket(navController : NavController) {
    Box(
        modifier = Modifier
            .height(25.dp)
            .wrapContentWidth()

            .clip(RoundedCornerShape(10.dp))
            .background(color = YelGreen)
            .clickable { navController.navigate("AddNewGoal") },
        contentAlignment = Alignment.Center

    ) {  Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
        ,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.add),
            contentDescription = "Add Icon",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
        Text(text = "New Goal", fontSize = 12.sp, color = Color.White)
    }
    }
}
