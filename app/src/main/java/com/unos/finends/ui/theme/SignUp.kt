package com.unos.finends.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unos.finends.R
import com.unos.finends.SocialMedia

@Composable
fun SignUp(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier
            .fillMaxSize()

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize().padding(horizontal = 20.dp, vertical = 30.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Finends",
                    modifier = Modifier.size(25.dp)
                )
            }
            Text(
                text = "Sign In",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Column(modifier = modifier) {

                OutlinedTextField(value = "",
                    onValueChange = {},
                    label = { Text(text = "Name") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = YelGreen
                    )
                )
                OutlinedTextField(value = "",
                    onValueChange = {},
                    label = { Text(text = "Email") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = YelGreen
                    )
                )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Password") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = YelGreen
                ),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.password),
                        contentDescription = "Password Icon", modifier = Modifier.size(20.dp)
                    )
                })
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Confirm Password") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = YelGreen
                    ),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "Password Icon", modifier = Modifier.size(20.dp)
                        )
                    })

            Spacer (modifier = Modifier.height(25.dp))
            Button(onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = YelGreen,
                )
            )
            {
                Text(text = "Sign in")
            }}
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,

                ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 0.5.dp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "or sign in with", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    HorizontalDivider(
                        modifier = Modifier.weight(1f), thickness = 0.5.dp,
                        color = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(25.dp))

                Row (
                    horizontalArrangement = Arrangement.Center
                ){
                    SocialMedia(icon = R.drawable.google ) {

                    }
                    SocialMedia(icon = R.drawable.facebook) {

                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append(" Already have an account? ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = YelGreen,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    ) {
                        append("Login")
                    }
                })
            }
        }
    }
}
