package com.unos.finends.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseUser
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun HomeScreen (modifier: Modifier = Modifier,
                currentUser : FirebaseUser?,
                onSignOutClick: () -> Unit )
{

    val textStyle = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )

    Surface(
        modifier = modifier.fillMaxSize(),

    ){ Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        currentUser?.let { user ->
            user.photoUrl?.let{
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(it)
                        .crossfade(true)
                        .build(),
                    contentDescription = "User Photo",
                    modifier = Modifier
                        .size(140.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.size(16.dp))
            }

            user.displayName?.let { name : String ->
                Text(text= name,
                    style = textStyle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.size(16.dp))
            }
            user.email?.let { mailId : String ->
                Text(text = "Mail ID : $mailId",
                    style = textStyle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                    )
                
                Spacer(modifier = Modifier.size(16.dp))
            }
            Text(text = "UID : ${user.uid}",
            style = textStyle,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = { onSignOutClick() }) {
            Text(text = "Sign Out",
                style = textStyle.copy(
                    fontWeight = FontWeight.SemiBold
                ))

        }
        }

    }




}


