package com.test.app.contactsgroupstesting.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.unit.dp
import com.test.app.contactsgroupstesting.viewModels.DashboardViewModel

@Composable
fun ContactsPage(viewModel: DashboardViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        for ((index, contacts) in viewModel.contactsList.withIndex()) {
            val checkedState = remember { mutableStateOf(false) }



            val context = LocalContext.current
            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                contacts.isSelected.toString(),
                                Toast.LENGTH_SHORT
                            )
                            .show()
                        // }
                    },
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = "${contacts.name}")
                        Text(text = "${contacts.contact_no}")
                    }
                    //Text(text = "${groups.isSelected}")
                    Checkbox(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        checked = contacts.isSelected,
                        onCheckedChange = {
                            contacts.isSelected = it

                        },
                    )
                }
            }
           // LaunchedEffect(contacts.isSelected) { contacts.isSelected}
           // LaunchedEffect(viewModel.contactsList) { viewModel.contactsList}
        }
    }
    //LaunchedEffect(true){viewModel.contactsCheckedStatus.value}
    LaunchedEffect(viewModel.contactsList.size) {
        viewModel.contactsList.toMutableList()

    }
}