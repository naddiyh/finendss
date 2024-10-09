    package com.unos.finends.ui.theme

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.RowScope
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxHeight
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.rememberScrollState
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.foundation.verticalScroll
    import androidx.compose.material3.Button
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
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
    import androidx.compose.ui.text.style.TextOverflow
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavController
    import androidx.navigation.NavDestination
    import androidx.navigation.NavDestination.Companion.hierarchy
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.currentBackStackEntryAsState
    import androidx.navigation.compose.rememberNavController
    import com.google.firebase.auth.FirebaseUser
    import coil.compose.AsyncImage
    import coil.request.ImageRequest
    import com.unos.finends.R
    import com.unos.finends.auth
    import com.unos.finends.data.model.NavigationItems

    @Composable
    fun HomeScreen (modifier: Modifier = Modifier,
                    currentUser : FirebaseUser?,
                    onSignOutClick: () -> Unit )
    {
        val navController = rememberNavController()

        val textStyle = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        Surface(
            modifier = modifier
                .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth(1f)
                    .fillMaxWidth(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                    ) {

                    //display user
                    Column( modifier=Modifier.padding(horizontal = 25.dp, vertical = 50.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        currentUser?.let { user ->
                            user.photoUrl?.let {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(it)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "User Photo",
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(RoundedCornerShape(99.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Spacer(modifier = Modifier.size(16.dp))
                            }

                            user.displayName?.let { name: String ->
                                Text(
                                    text = "Hello, $name!",
                                    style = textStyle,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = SoftJade,
                                )
                                Spacer(modifier = Modifier.size(16.dp))
                            }
                        }

                    Button(onClick = { onSignOutClick() }) {
                        Text(text = "Sign Out",
                            style = textStyle.copy( fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ))
                    }

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "See your current financial situation here",
                        fontSize = 14.sp,
                        color = SoftJade
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Current Balance ",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "Rp 20.000.000,00",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = SoftJade,
                            )}
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxHeight(1f)
                            .fillMaxWidth(1f)
                            .clip(
                                RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
                            )
                            .shadow(
                                elevation = 20.dp,
                                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp),
                                clip = false
                            )
                            .background(color = Color.White)

                    ) {
                       Column(
                           modifier = Modifier
                               .padding(horizontal = 20.dp),

                       ) {
                           Spacer(modifier = Modifier.height(30.dp))
                           Text(text = "Tracker", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                           Spacer(modifier = Modifier.height(25.dp))
                           Column(
                               modifier = Modifier
                                   .verticalScroll(rememberScrollState())
                                   .fillMaxHeight(),
                               verticalArrangement = Arrangement.spacedBy(12.dp)
                           ) {
                               BoxTracker(title = "HRV", totalAmount = "500.000", currentAmount = "4.000.000", progress = 0.6f)
                               BoxTracker(title = "Savings", totalAmount = "3.000.000", currentAmount = "1.500.000", progress = 0.5f)
                               BoxTracker(title = "Investments", totalAmount = "10.000.000", currentAmount = "7.500.000", progress = 0.75f)
                               BoxTracker(title = "Expenses", totalAmount = "2.000.000", currentAmount = "500.000", progress = 0.25f)
                               Spacer(modifier = Modifier.height(25.dp))
                           }}
                    }


                }
            }

        }}







//@Composable
//fun BottomNavigation(navController: NavHostController) {
//    TODO("Not yet implemented")
//}
//
//@Composable
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


