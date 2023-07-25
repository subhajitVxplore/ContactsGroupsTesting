package com.test.app.contactsgroupstesting.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.test.app.contactsgroupstesting.viewModels.DashboardViewModel

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel
) {
    //var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Contacts", "Groups")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = viewModel.tabIndex.value) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = viewModel.tabIndex.value == index,
                    onClick = { viewModel.tabIndex.value = index },
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Contacts, contentDescription = null)
                            1 -> Icon(imageVector = Icons.Default.Group, contentDescription = null)
                        }
                    }
                )
            }
        }
        when (viewModel.tabIndex.value) {
            0 -> ContactsPage(viewModel)
            1 -> GroupsPage(viewModel)
        }
    }
}






