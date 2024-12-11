package com.unos.finends.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.unos.finends.R
import com.unos.finends.core.navigation.NavigationItems
import com.unos.finends.ui.theme.YelGreen

@Composable
 fun Bottom(navController: NavHostController, modifier: Modifier = Modifier) {

    val currentRoute = navController.currentBackStackEntry?.destination?.route
     Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .zIndex(30f)
            .clip(RoundedCornerShape(30.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(YelGreen)
                .clip(RoundedCornerShape(30.dp))
                .zIndex(30f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Box ( modifier = Modifier.fillMaxWidth(0.1f)
            ){

                Column {

                }
            IconButton(onClick = { navController.navigate(NavigationItems.Home.route) }) {
                Icon(
                    painter = painterResource(R.drawable.iconhome),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentRoute == NavigationItems.Home.route) Color.White  else Color.White.copy(alpha = 0.5f)
                )
            }

                if (currentRoute == NavigationItems.Home.route) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 7.dp),
                        thickness = 1.dp,
                        color = Color.White
                    )
                }


            }

            Box(modifier = Modifier.fillMaxWidth(0.1f) ){
            IconButton(onClick = { navController.navigate(NavigationItems.History.route) }) {
                Icon(
                    painter = painterResource(R.drawable.history),
                    contentDescription = "History",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentRoute == NavigationItems.History.route) Color.White  else Color.White.copy(alpha = 0.5f)
                )
            }
                if (currentRoute == NavigationItems.History.route) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 7.dp),
                        thickness = 1.dp,
                        color = Color.White
                    )
                }
            }

            Box(modifier = Modifier.fillMaxWidth(0.1f)){

            IconButton(onClick = { navController.navigate(NavigationItems.Bucket.route) }) {
                Icon(
                    painter = painterResource(R.drawable.statis),
                    contentDescription = "Bucket List",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentRoute == NavigationItems.Bucket.route) Color.White  else Color.White.copy(alpha = 0.5f)
                )
            }

                if (currentRoute == NavigationItems.Bucket.route) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 7.dp),
                        thickness = 1.dp,
                        color = Color.White
                    )
                }
            }
            Box(modifier = Modifier.fillMaxWidth(0.1f)){
            IconButton(onClick = { navController.navigate(NavigationItems.Profile.route) }) {
                Icon(
                    painter = painterResource(R.drawable.userr),
                    contentDescription = "Profile",
                    modifier = Modifier.size(24.dp),
                    tint = if (currentRoute == NavigationItems.Profile.route) Color.White  else Color.White.copy(alpha = 0.5f)
                )
            }
                if (currentRoute == NavigationItems.Profile.route) {
                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 7.dp),
                        thickness = 1.dp,
                        color = Color.White
                    )
                }
            }
        }
    }
}
