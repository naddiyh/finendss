    package com.unos.finends.features.home

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
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
    import androidx.compose.foundation.pager.rememberPagerState
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.foundation.verticalScroll
    import androidx.compose.material3.Icon
    import androidx.compose.material3.IconButton
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.draw.shadow
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.ui.zIndex
    import androidx.navigation.NavHostController
    import com.google.firebase.auth.FirebaseUser
    import coil.compose.AsyncImage
    import coil.request.ImageRequest
    import com.unos.finends.R
    import com.unos.finends.components.button.Bottom
    import com.unos.finends.components.button.Category
    import com.unos.finends.ui.theme.SoftJade
    import com.unos.finends.ui.theme.YelGreen
    import com.unos.finends.features.home.tracker.BoxTracker
    import com.unos.finends.ui.theme.White
    import com.google.accompanist.pager.*

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun HomeScreen(
        modifier: Modifier = Modifier,
        navController: NavHostController,
        currentUser: FirebaseUser?,
        onSignOutClick: () -> Unit,
    ) {
        val textStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        var showSignOutButton by remember { mutableStateOf(false) }
        Surface(
            modifier = modifier.fillMaxSize(),color = White

        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 50.dp)
                ) {
                    Column(modifier = Modifier.padding(horizontal = 25.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Logo",
                                modifier = Modifier.size(25.dp)
                            )

                            Row ( verticalAlignment = Alignment.CenterVertically,){
                                IconButton(onClick = {  }) {
                                    Icon(
                                        painter = painterResource(R.drawable.notif),
                                        contentDescription = "Notif",
                                        modifier = Modifier.size(25.dp),
                                        tint = YelGreen
                                    )
                                }

                            currentUser?.let { user ->
                                user.photoUrl?.let {
                                    AsyncImage(
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(it)
                                            .crossfade(true)
                                            .build(),
                                        contentDescription = "User Photo",
                                        modifier = Modifier
                                            .size(35.dp)
                                            .clip(RoundedCornerShape(99.dp))
                                            .clickable {
                                                showSignOutButton = !showSignOutButton
                                            },
//                                        contentScale = ContentScale.Crop
                                    )

                                }}
//                                user.displayName?.let { name ->
//                                    Text(
//                                        text = "$name",
//                                        style = textStyle,
//                                        maxLines = 1,
//                                        overflow = TextOverflow.Ellipsis,
//                                        fontSize = 16.sp,
//                                        fontWeight = FontWeight.Bold,
//                                        color = SoftJade,
//                                    )
//                                    Spacer(modifier = Modifier.size(16.dp))
//                                }
                                if (showSignOutButton){


                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(0.6f)
                                            .fillMaxHeight(0.04f)
                                            .clickable { onSignOutClick() }
                                            .shadow(
                                                elevation = 18.dp,
                                                shape = RoundedCornerShape(6.dp),
                                                clip = false,
                                                spotColor = Color.Black.copy(alpha = 0.1f)
                                            )
                                            .background(Color.White, RoundedCornerShape(6.dp)),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        Text(
                                            text = "Sign Out",
                                            style = textStyle.copy(
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Normal
                                            ),
                                            color = Color.Black
                                        )

                                }  }
                            }

                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "See your current financial situation here",
                            fontSize = 14.sp,
                            color = SoftJade
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        SavingBalanceBox()

                    }

                    // Box Tracker
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.fillMaxHeight()
                                .padding(horizontal = 24.dp)
                        ) {
                            Spacer(modifier = Modifier.height(30.dp))
                            Text(
                                text = "Bucket List",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                            Category()
                            Spacer(modifier = Modifier.height(25.dp))
                            Column(
                                modifier = Modifier
                                    .verticalScroll(rememberScrollState())
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.spacedBy(25.dp)
                            ) {
                                BoxTracker(
                                    title = "Mobil HRV",
                                    totalAmount = "500.000",
                                    currentAmount = "4.000.000",
                                    progress = 0.6f,
                                    imageResId = R.drawable.tes,
                                    onAddClick = {
                                        navController.navigate("AddSavingsScreen/HRV/4000000")
                                    },
                                    navController = navController,

                                )
                                BoxTracker(

                                    totalAmount = "3.000.000",
                                    currentAmount = "1.500.000",
                                    progress = 0.5f,
                                    imageResId = R.drawable.tes,
                                    onAddClick = {
                                        navController.navigate("AddSavingsScreen/Trip to Seoul/1500000")
                                    },
                                    navController = navController,

                                    title = "Goes to Seoul",
                                )
                                BoxTracker( totalAmount = "500.000", currentAmount = "4.000.000", progress = 0.6f, imageResId = R.drawable.tes,   onAddClick = {
                                    navController.navigate("AddSavingsScreen/Trip to Seoul/1500000")
                                }, title = "Iphone 18 Max Pro",
                                    navController = navController, )


                                BoxTracker( totalAmount = "500.000", currentAmount = "4.000.000", progress = 0.6f, imageResId = R.drawable.tes,   onAddClick = {
                                    navController.navigate("AddSavingsScreen/Trip to Seoul/1500000")
                                }, title = "Cintanya",
                                    navController = navController, )


                            }
                            Spacer(modifier = Modifier.height(25.dp))
                        }
                    }
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

//    @Composable
//    private fun Bottom(navController: NavHostController, modifier: Modifier = Modifier) {
//        Box(
//            modifier = Modifier
//                .padding(horizontal = 20.dp)
//                .zIndex(30f)
//                .clip(RoundedCornerShape(30.dp))
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(YelGreen)
//                    .clip(RoundedCornerShape(30.dp))
//                    .zIndex(30f),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                IconButton(onClick = { navController.navigate(NavigationItems.Home.route) }) {
//                    Icon(
//                        painter = painterResource(R.drawable.iconhome),
//                        contentDescription = "Home",
//                        modifier = Modifier.size(20.dp)
//                    )
//                }
//                IconButton(onClick = { navController.navigate(NavigationItems.History.route) }) {
//                    Icon(
//                        painter = painterResource(R.drawable.history),
//                        contentDescription = "History",
//                        modifier = Modifier.size(20.dp)
//                    )
//                }
//                IconButton(onClick = { navController.navigate(NavigationItems.Statistic.route) }) {
//                    Icon(
//                        painter = painterResource(R.drawable.statis),
//                        contentDescription = "Statistic",
//                        modifier = Modifier.size(20.dp)
//                    )
//                }
//
//                IconButton(onClick = { navController.navigate(NavigationItems.Profile.route) }) {
//                    Icon(
//                        painter = painterResource(R.drawable.userr),
//                        contentDescription = "Profile",
//                        modifier = Modifier.size(20.dp)
//                    )
//                }
//            }
//        }
//    }

//@Composable
//fun BottomNavigation(navController: NavHostController) {
//    TODO("Not yet implemented")
//}
//

//fun BottomBar(navController: NavHostController) {
//    val screens : ListOf(
//        BottomNavigation.Home,
//        BottomNavigation.History,
//        BottomNavigation.Settings
//    )
//}


//user.email?.let { mailId : String ->
//                Text(text = "Mail ID : $mailId",
//                    style = textStyle,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                    )
//
//                Spacer(modifier = Modifier.size(16.dp))
//            }

//        Spacer(modifier = Modifier.size(16.dp))
//        Button(onClick = { onSignOutClick() }) {
//            Text(text = "Sign Out",
//                style = textStyle.copy(
//                    fontWeight = FontWeight.SemiBold
//                ))
//
//        }
//        }


