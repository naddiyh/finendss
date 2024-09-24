package com.unos.finends.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
fun Login(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 45.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo Finends" ,
        modifier = Modifier.size(25.dp))
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp,),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(40.dp))

        Text (text = "Log In", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(30.dp))
        Image(painter = painterResource(id = R.drawable.login) , contentDescription = "Login Image",
            modifier = Modifier.size(150.dp))

        Spacer(modifier = Modifier.height(50.dp))
//
//        Row(modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Start) {
//            Text(text = "Welcome Back,", fontSize = 16.sp, fontWeight = FontWeight.Light)
//        }
//        Spacer(modifier= Modifier.height(10.dp))


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
                    thickness = 0.5.dp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "or login with", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(8.dp))
                HorizontalDivider(
                    modifier = Modifier.weight(1f), thickness = 0.5.dp,
                    color = Color.Gray
                )}
            Spacer(modifier = Modifier.height(25.dp))
            Row (

                horizontalArrangement = Arrangement.Center
            ){
                SocialMedia(icon = R.drawable.google ) {
                    onSignInClick()
                }
                SocialMedia(icon = R.drawable.facebook) {
                    onSignInClick()
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxHeight(fraction = 0.3f),
            contentAlignment = Alignment.BottomCenter
        ) {

            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
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
        shape = RoundedCornerShape(12.dp),
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
        Text(text = "Login")

    }
}




