package com.unos.finends.features.bucket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore
import com.unos.finends.R
import com.unos.finends.data.model.GoalsData
import com.unos.finends.ui.theme.YelGreen


@Composable
fun BoxBucketList(navController: NavController, ) {
    val goalList = remember { mutableStateListOf<GoalsData>() }
    val firestore = FirebaseFirestore.getInstance()
    val isLoading = remember { mutableStateOf(true) }

    firestore.collection("goals").addSnapshotListener { snapshot, exception ->
        if (exception != null) {
            println("Error getting goals: ${exception.message}")
            isLoading.value = false
            return@addSnapshotListener
        }

        snapshot?.let {
            println("Snapshot received: ${it.documents.size} documents")

            val goals = it.documents.mapNotNull { doc ->
                try {
                    val goal = doc.toObject(GoalsData::class.java)
                    println("Fetched goal: $goal")
                    goal
                } catch (e: Exception) {
                    println("Error parsing document: ${e.message}")
                    null
                }
            }

            println("Total goals fetched: ${goals.size}")
            goalList.clear()
            goalList.addAll(goals)
        }
        isLoading.value = false
    }
    if (isLoading.value) {
        Text("Loading goals...", color = Color.Gray, fontSize = 14.sp)
    } else if (goalList.isEmpty()) {
        Text("No goals available.", color = Color.Gray, fontSize = 14.sp)
    } else {
        goalList.forEach { goal ->
            BoxGoalList(goal = goal, navController = navController)
        }
    }

}

@Composable
fun BoxGoalList(goal: GoalsData,navController: NavController  ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .shadow(5.dp, RoundedCornerShape(12.dp))
                .background(Color.White, RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                val imageResource = runCatching {
                    painterResource(id = R.drawable.tes)
                }.getOrNull() ?: painterResource(id = R.drawable.tes)

                Image(
                    painter = imageResource,
                    contentDescription = "Goal Image",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.fillMaxHeight()) {
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        goal.title?.let {
                            Text(
                                text = it,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.edit),
                            contentDescription = "Edit",
                            modifier = Modifier
                                .size(20.dp)
//                                .clickable {
//                                    navController.navigate("edit_goal/${goal.id}")
//
//                                }
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row() {


                        Image(
                            painter = painterResource(id = R.drawable.flag),
                            contentDescription = "Edit",
                            modifier = Modifier
                                .size(10.dp)
//                                .clickable {
//                                    navController.navigate("edit_goal/${goal.id}")
//
//                                }
                        )
                        Text(
                            text = "Rp ${goal.goalAmount}",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )}
                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){


                        Image(
                            painter = painterResource(id = R.drawable.flag),
                            contentDescription = "Edit",
                            modifier = Modifier
                                .size(10.dp)
//                                .clickable {
//                                    navController.navigate("edit_goal/${goal.id}")
//
//                                }
                        )
                            Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = " Rp ${goal.goalAmount}",
                            fontSize = 12.sp,
                            color = Color.Gray
                        )}
                    }
                    goal.type?.let {
                        Text(
                            text = it,
                            lineHeight = 20.sp,
                            fontSize = 12.sp,
                            color = YelGreen
                        )
                    }
                    goal.frequency?.let {
                        Text(
                            text = it,
                            lineHeight = 20.sp,
                            fontSize = 12.sp,
                            color = Color.LightGray
                        )
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
    }


