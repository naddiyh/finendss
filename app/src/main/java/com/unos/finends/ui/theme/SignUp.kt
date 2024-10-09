package com.unos.finends.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.unos.finends.R
import com.unos.finends.Screen
import com.unos.finends.SocialMedia

@Composable
fun SignUp(
    navController: NavHostController,
    modifier: Modifier = Modifier,
//    onSignInClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxSize()

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize().padding(horizontal = 20.dp, vertical = 40.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
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
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Name", fontSize = 14.sp, color = Color.LightGray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val y = size.height - strokeWidth / 2
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(2f, y),
                                end = Offset(size.width, y),
                                strokeWidth = strokeWidth
                            )
                        },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                )
                Spacer (modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Email", fontSize = 14.sp, color = Color.LightGray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val y = size.height - strokeWidth / 2
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(2f, y),
                                end = Offset(size.width, y),
                                strokeWidth = strokeWidth
                            )
                        },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent
                    ),
                )
                Spacer (modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Password", fontSize = 14.sp, color = Color.LightGray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val width = size.width
                            val height = size.height
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, height),
                                end = Offset(width, height),
                                strokeWidth = strokeWidth
                            )
                        },
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "Password Icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )
                Spacer (modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Confirm password", fontSize = 14.sp, color = Color.LightGray) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .drawBehind {
                            val strokeWidth = 1.dp.toPx()
                            val width = size.width
                            val height = size.height
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, height),
                                end = Offset(width, height),
                                strokeWidth = strokeWidth
                            )
                        },
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent
                    ),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "Password Icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                )

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
//                        onSignInClick()
                    }
                    SocialMedia(icon = R.drawable.facebook) {
//                        onSignInClick()
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row {
                    Text(
                        text = "Already have an account? ",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )

                    Text(
                        text = "Login",
                        style = TextStyle(
                            color = YelGreen,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                                navController.navigate(Screen.Login.name)
                            }
                    )
                }
            }

        }
    }
}
