package com.example.interviewdemo.navigation

import android.app.Activity
import androidx.navigation.Navigation
import com.example.interviewdemo.R
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(
    private val activity: Activity
) : AppNavigator {

    private val navController by lazy {
        Navigation.findNavController(activity, R.id.nav_host_fragment)
    }

    override fun navigateToTaskOne() {
       navController.navigate(R.id.TaskOneFragment)
    }


    override fun popBackStack() {
        navController.popBackStack()
    }
}