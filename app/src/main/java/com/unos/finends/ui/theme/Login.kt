package com.unos.finends.ui.theme

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unos.finends.R
import com.unos.finends.SocialMedia


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp,),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(60.dp))
        Text (text = "Log In", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(30.dp))
        Image(painter = painterResource(id = R.drawable.login) , contentDescription = "Login Image",
            modifier = Modifier.size(150.dp))

        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {


            Text(text = "Welcome Back,", fontSize = 16.sp, fontWeight = FontWeight.Light)
        }
        Spacer(modifier= Modifier.height(10.dp))


        LoginSection()
        Spacer(modifier= Modifier.height(35.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,

            ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 0.6.dp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "or login with")
                Spacer(modifier = Modifier.width(8.dp))
                HorizontalDivider(
                    modifier = Modifier.weight(1f), thickness = 0.6.dp,
                    color = Color.Gray
                )}
            Spacer(modifier = Modifier.height(25.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                SocialMedia(icon = R.drawable.google ) {

                }
                SocialMedia(icon = R.drawable.facebook) {
                }

            }
        }

        Box(
            modifier = Modifier.fillMaxHeight(fraction = 0.6f),
            contentAlignment = Alignment.BottomCenter
        ) {


            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = YelGreen,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
                {
                    append(" Don't have an account yet? ")
                }
                withStyle(
                    style = SpanStyle(
                        color = YelGreen,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append("Sign in")
                }
            }


            )
        }
    }}

@Composable
private fun LoginSection() {
    OutlinedTextField(value = "",
        onValueChange = {},
        label = { Text(text = "Email") },
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = YelGreen
        )
    )

    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = YelGreen
        ),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.password),
                contentDescription = "Password Icon", modifier = Modifier.size(20.dp)
            )
        })
}



