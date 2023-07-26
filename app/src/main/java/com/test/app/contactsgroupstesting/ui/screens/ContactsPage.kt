package com.test.app.contactsgroupstesting.ui.screens

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
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
import kotlin.math.log

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContactsPage(viewModel: DashboardViewModel) {
    //val checkedState = mutableStateListOf<ContactsModel>()
    var checkedState = mutableListOf<ContactsModel>()
    //var checkedState by remember { mutableStateOf(false) }
    // var checkedState by remember { mutableStateListOf<Boolean>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        for ((index, contacts) in viewModel.contactsGroup1.withIndex()) {
            val checkedState = remember { mutableStateOf(false) }
            val context = LocalContext.current

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
                        //checked = contacts.isSelected,
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                            contacts.isSelected = it
                           // viewModel.falseCounter.value=0
                            if (checkedState.value) {
                                Toast
                                    .makeText(context, "isNotChecked(${viewModel.falseCounter.value})", Toast.LENGTH_SHORT)
                                    .show()
                                viewModel.falseCounter.value--
                                if(viewModel.falseCounter.value<0){
                                    viewModel.falseCounter.value=3
                                }
                            }

                            if (viewModel.falseCounter.value==0){
                                viewModel.groupsList[0].isAllSelected=true
                            }else if (viewModel.falseCounter.value<4){
                                viewModel.groupsList[0].isAllSelected=false
                            }

//                            if (viewModel.falseExistsCounter.value == 0) {
//                                viewModel.contactsGroup1[index].isSelected = it
//                            }
                        },
                    )
                }
            }
        }
        for ((index, contacts) in viewModel.contactsGroup2.withIndex()) {
            val checkedState = remember { mutableStateOf(false) }
            val context = LocalContext.current

            try {
                checkedState.value = contacts.isSelected
            } catch (e: IndexOutOfBoundsException) {
                Log.d("ContactsPage", "ContactsPage: IndexOutOfBound ")
            }


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
                        //checked = contacts.isSelected,
                        checked = checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                            contacts.isSelected = it
//                            if (viewModel.falseCounter.value == 0) {
//                                viewModel.contactsGroup1[index].isSelected = it
//                            }
                        },
                    )
                }
            }
        }
        for ((index, contacts) in viewModel.contactsGroup3.withIndex()) {
            val checkedState = remember { mutableStateOf(false) }
            val context = LocalContext.current
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
                        //checked = contacts.isSelected,
                        checked = checkedState.value,

                        onCheckedChange = {
                            checkedState.value = it
                            contacts.isSelected = it
//                            if (viewModel.falseCounter.value == 0) {
//                                viewModel.contactsGroup1[index].isSelected = it
//                            }
                        },
                    )
                }
            }
        }
    }
}


