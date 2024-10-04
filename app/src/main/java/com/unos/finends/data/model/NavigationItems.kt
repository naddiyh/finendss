package com.unos.finends.data.model

import androidx.annotation.DrawableRes
import com.unos.finends.R

sealed class NavigationItems(
    val name: String,
    val route: String,
    @DrawableRes val icon: Int
) {
    object Home : NavigationItems("Home", "home_route", R.drawable.home)
    object History : NavigationItems("History", "history_route", R.drawable.history)
    object Statistic : NavigationItems("Statistic", "statistic_route", R.drawable.statistic)
    object Profile : NavigationItems("Profile", "profile_route", R.drawable.user)
}

val listOfNavigationItems = listOf(
    NavigationItems.Home,
    NavigationItems.History,
    NavigationItems.Statistic,
    NavigationItems.Profile
)
