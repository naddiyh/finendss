package com.unos.finends.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.unos.finends.R
import com.unos.finends.ui.theme.YelGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSavingsScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    title: String,
    currentAmount: String,
    onSaveAmount: String
) {
    var enteredAmount by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            // Back and Title Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "back",
                        modifier = Modifier.size(35.dp),
                        tint = Color.Unspecified
                    )
                }
                Spacer(modifier = Modifier.weight(0.6f))
                Text(
                    text = "Add Savings",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = YelGreen,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Goes to seoul",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )


            OutlinedTextField(
                value = enteredAmount,
                onValueChange = { enteredAmount = it },

                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = YelGreen
                ),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 15.dp)

                    .drawBehind {
                        val strokeWidth = 2.dp.toPx() // Line thickness
                        val y = size.height - strokeWidth / 2 // Draw line at the bottom
                        drawLine(
                            color = YelGreen, // Line color changes based on focus
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = strokeWidth
                        )
                    },
                shape = RoundedCornerShape(12.dp) // Optional: Rounded corners if needed
            )
            Text(
                text = "Current Amount : ",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = YelGreen,
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(YelGreen.copy(alpha = 0.2f))
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = " Rp 50.0000",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = YelGreen,
                    textAlign = TextAlign.Center
                )
            }


            // Done Button
            Button(
                onClick = {
                    if (enteredAmount.isNotEmpty()) {

                        navController.popBackStack()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = YelGreen),
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(48.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = "Done",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }


        }
    }
}