package com.unos.finends.features.bucket


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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.unos.finends.R
import com.unos.finends.components.button.Bottom
import com.unos.finends.components.button.Category
import com.unos.finends.features.bucket.addBucket.AddNewGoal
import com.unos.finends.ui.theme.White
import com.unos.finends.ui.theme.YelGreen
import java.util.Locale.Category

@Composable
fun BucketScreen ( modifier: Modifier = Modifier,
                    navController: NavHostController){
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
        Box(modifier = Modifier.fillMaxSize()){

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 60.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Bucket List",
                            fontSize = 18.sp,
                            color = YelGreen,
                        )
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Category()
                       NewGoalBucket(navController = navController)
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    BoxBucketList(navController = navController)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .zIndex(40f)
                    .padding(vertical = 30.dp),
            ) {
                Bottom(navController = navController)
            }
        }

    }
}

//@Composable
//private fun Bottom(navController: NavHostController, modifier: Modifier = Modifier) {
//    Box(
//        modifier = Modifier
//            .padding(horizontal = 20.dp)
//            .zIndex(30f)
//            .clip(RoundedCornerShape(30.dp))
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(YelGreen)
//                .clip(RoundedCornerShape(30.dp))
//                .zIndex(30f),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            IconButton(onClick = { navController.navigate(NavigationItems.Home.route) }) {
//                Icon(
//                    painter = painterResource(R.drawable.iconhome),
//                    contentDescription = "Home",
//                    modifier = Modifier.size(20.dp)
//                )
//            }
//            IconButton(onClick = { navController.navigate(NavigationItems.History.route) }) {
//                Icon(
//                    painter = painterResource(R.drawable.history),
//                    contentDescription = "History",
//                    modifier = Modifier.size(20.dp)
//                )
//            }
//            IconButton(onClick = { navController.navigate(NavigationItems.Statistic.route) }) {
//                Icon(
//                    painter = painterResource(R.drawable.statis),
//                    contentDescription = "Statistic",
//                    modifier = Modifier.size(20.dp)
//                )
//            }
//
//            IconButton(onClick = { navController.navigate(NavigationItems.Profile.route) }) {
//                Icon(
//                    painter = painterResource(R.drawable.userr),
//                    contentDescription = "Profile",
//                    modifier = Modifier.size(20.dp)
//                )
//            }
//        }
//    }
//}
