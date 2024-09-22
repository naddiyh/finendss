package com.unos.finends

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun SocialMedia(
    modifier: Modifier = Modifier,
    @DrawableRes icon : Int,
    onClick : ()-> Unit,
){
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 10.dp)

    ) {
        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier.size(25.dp))
    }

}


//fun Modifier.socialMedia() : Modifier = composed {
//
//}