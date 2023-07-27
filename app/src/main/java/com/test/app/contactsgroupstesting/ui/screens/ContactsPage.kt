package com.test.app.contactsgroupstesting.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.test.app.contactsgroupstesting.models.ContactsModel
import com.test.app.contactsgroupstesting.viewModels.DashboardViewModel
import java.lang.IndexOutOfBoundsException
import java.time.LocalDate
import kotlin.math.log

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContactsPage(viewModel: DashboardViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        for ((index, groups) in viewModel.groupsList.withIndex()) {
            val context = LocalContext.current
            val currentDate=LocalDate.now()

            for ((i, contacts) in groups.group_list.withIndex()) {
                val checkedState = remember { mutableStateOf(false) }
                checkedState.value = contacts.isSelected
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
                            .padding(10.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "${contacts.name}")
                            Text(text = "${contacts.contact_no}")
                        }
                        Checkbox(
                            modifier = Modifier.align(Alignment.CenterVertically),
                            checked = checkedState.value,
                            onCheckedChange = {
                                checkedState.value = it
                                contacts.isSelected = it

                                if (checkedState.value) {
                                    viewModel.falseCounter.value--
                                    viewModel.groupsList[index].isIntermediate = true
                                } else {
                                    viewModel.falseCounter.value++
                                    viewModel.groupsList[index].isIntermediate = false
                                }

                                if (viewModel.falseCounter.value < 0) {
                                    viewModel.falseCounter.value = 3
                                    viewModel.groupsList[index].isIntermediate = true
                                } else if (viewModel.falseCounter.value == 0) {
                                    viewModel.groupsList[index].isAllSelected = true
                                    viewModel.groupsList[index].isIntermediate = false
                                } else if (viewModel.falseCounter.value < 4) {
                                    viewModel.groupsList[index].isAllSelected = false
                                    viewModel.groupsList[index].isIntermediate = true
                                } else if (viewModel.falseCounter.value == 4) {
                                    viewModel.groupsList[index].isAllSelected = false
                                }

                            },
                        )
                    }
                }
            }
        }
//        for ((index, contacts) in viewModel.contactsGroup1.withIndex()) {
//            val checkedState = remember { mutableStateOf(false) }
//            val context = LocalContext.current
//
//            checkedState.value = contacts.isSelected
//
//            Card(
//                modifier = Modifier
//                    .padding(15.dp)
//                    .fillMaxWidth()
//                    .wrapContentHeight(),
//
//                shape = RoundedCornerShape(8.dp),
//                border = BorderStroke(1.dp, Color.LightGray),
//                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                ) {
//                    Column(modifier = Modifier.weight(1f)) {
//                        Text(text = "${contacts.name}")
//                        Text(text = "${contacts.contact_no}")
//                    }
//                    Checkbox(
//                        modifier = Modifier.align(Alignment.CenterVertically),
//                        checked = checkedState.value,
//                       // enabled = false,
//                        onCheckedChange = {
//                            checkedState.value = it
//                            contacts.isSelected = it
//                           // viewModel. contactsGroup2[3].isSelected
//                            if (checkedState.value) {
//                                // Toast.makeText(context, "isNotChecked(${viewModel.falseCounter.value-1})", Toast.LENGTH_SHORT).show()
//                                viewModel.falseCounter.value--
//                                viewModel.groupsList[0].isIntermediate = true
//                                viewModel.group1CheckedState()
//                            } else {
//                                viewModel.falseCounter.value++
//                                viewModel.groupsList[0].isIntermediate = false
//                                viewModel.group1CheckedState()
//                            }
//
//                        },
//                    )
//                }
//            }
//        }
//        for ((index, contacts) in viewModel.contactsGroup2.withIndex()) {
//            val checkedState = remember { mutableStateOf(false) }
//            val context = LocalContext.current
//
//            checkedState.value = contacts.isSelected
//           // if (contacts.id != 4)
//
//            Card(
//                modifier = Modifier
//                    .padding(15.dp)
//                    .fillMaxWidth()
//                    .wrapContentHeight(),
//                shape = RoundedCornerShape(8.dp),
//                border = BorderStroke(1.dp, Color.LightGray),
//                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                ) {
//                    Column(modifier = Modifier.weight(1f)) {
//                        Text(text = "${contacts.name}")
//                        Text(text = "${contacts.contact_no}")
//                    }
//                    Checkbox(
//                        modifier = Modifier.align(Alignment.CenterVertically),
//                        //checked = contacts.isSelected,
//                        checked = checkedState.value,
//                        onCheckedChange = {
//                            checkedState.value = it
//                            contacts.isSelected = it
//
//                            if (checkedState.value) {
//                                // Toast.makeText(context, "isNotChecked(${viewModel.falseCounter.value-1})", Toast.LENGTH_SHORT).show()
//                                viewModel.falseCounter.value--
//                                viewModel.groupsList[1].isIntermediate = true
//                                viewModel.group2CheckedState()
//                            } else {
//                                viewModel.falseCounter.value++
//                                viewModel.groupsList[1].isIntermediate = false
//                                viewModel.group2CheckedState()
//                            }
//                        },
//                    )
//                }
//            }
//        }
//        for ((index, contacts) in viewModel.contactsGroup3.withIndex()) {
//            val checkedState = remember { mutableStateOf(false) }
//            val context = LocalContext.current
//            checkedState.value = contacts.isSelected
//
//            Card(
//                modifier = Modifier
//                    .padding(15.dp)
//                    .fillMaxWidth()
//                    .wrapContentHeight(),
//                shape = RoundedCornerShape(8.dp),
//                border = BorderStroke(1.dp, Color.LightGray),
//                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                ) {
//                    Column(modifier = Modifier.weight(1f)) {
//                        Text(text = "${contacts.name}")
//                        Text(text = "${contacts.contact_no}")
//                    }
//                    Checkbox(
//                        modifier = Modifier.align(Alignment.CenterVertically),
//                        checked = checkedState.value,
//                        onCheckedChange = {
//                            checkedState.value = it
//                            contacts.isSelected = it
//
//                            if (checkedState.value) {
//                                // Toast.makeText(context, "isNotChecked(${viewModel.falseCounter.value-1})", Toast.LENGTH_SHORT).show()
//                                viewModel.falseCounter.value--
//                                viewModel.groupsList[2].isIntermediate = true
//                                viewModel.group3CheckedState()
//                            } else {
//                                viewModel.falseCounter.value++
//                                viewModel.groupsList[2].isIntermediate = false
//                                viewModel.group3CheckedState()
//                            }
//                        },
//                    )
//                }
//            }
//        }
    }
}



