package com.test.app.contactsgroupstesting.ui.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Square
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.unit.dp
import com.test.app.contactsgroupstesting.viewModels.DashboardViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GroupsPage(viewModel: DashboardViewModel) {

    val context= LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        for ((index, groups) in viewModel.groupsList.withIndex()) {

            val checkedState = remember { mutableStateOf(false) }

            //checkedState.value=groups.group_list[index].isSelected
            checkedState.value = groups.isAllSelected


            Card(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.LightGray),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = "Group: ${index + 1}",
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    //   if ((viewModel.falseCounter.value==0) or (viewModel.falseCounter.value==4)) {
                    if (!(groups.isIntermediate)) {//false

                        Checkbox(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            //checked = groups.group_list[index].isSelected,
                            checked = checkedState.value,
                            onCheckedChange = {
                                checkedState.value = it
                                groups.isAllSelected = it
                                viewModel.falseCounter.value = 0
                                if (index == 0) {
                                    for ((i, contacts) in viewModel.contactsGroup1.withIndex()) {
                                        groups.group_list[i].isSelected = it
                                    }
                                   // viewModel.falseCounter.value -= 1
                                } else if (index == 1) {
                                    for ((i, contacts) in viewModel.contactsGroup2.withIndex()) {
                                        groups.group_list[i].isSelected = it
                                    }
                                    //viewModel.falseCounter.value -= 1
                                } else if (index == 2) {
                                    for ((i, contacts) in viewModel.contactsGroup3.withIndex()) {
                                        groups.group_list[i].isSelected = it
                                    }
                                }
                            },
                        )//checkbox
                    } else {
                        intermediateUi(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(10.dp)
                        )
                    }


                }//row

                Divider(thickness = 1.dp, color = Color.Black)

                for ((i, group) in groups.group_list.withIndex()) {
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "${group.name}")
                            Text(text = "${group.contact_no}")
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun intermediateUi(modifier: Modifier) {
    Column {
        Icon(
            imageVector = Icons.Default.Square,
            contentDescription = null,
            modifier=modifier,
            tint = Color.Blue
        )
    }
}








