package com.test.app.contactsgroupstesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.test.app.contactsgroupstesting.ui.screens.DashboardScreen
import com.test.app.contactsgroupstesting.ui.theme.ContactsGroupsTestingTheme
import com.test.app.contactsgroupstesting.viewModels.DashboardViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewModel: DashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        setContent {
            ContactsGroupsTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashboardScreen(viewModel)
                }
            }
        }
    }
}

