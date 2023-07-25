package com.test.app.contactsgroupstesting.ui.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.app.contactsgroupstesting.viewModels.DashboardViewModel

@Composable
fun GroupsPage(viewModel: DashboardViewModel) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        for ((index, groups) in viewModel.groupsList.withIndex()) {

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
                    Text(text = "Group: ${index + 1}", modifier = Modifier.weight(1f).align(Alignment.CenterVertically))

                    var checkedState = remember { mutableStateOf(false) }
                    checkedState.value=groups.group_list[index].isSelected
                   // checkedState.value=if (index==0) viewModel.isGroup1Selected() else if(index==1) viewModel.isGroup2Selected() else viewModel.isGroup3Selected()
                    Checkbox(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        checked =checkedState.value,
                        onCheckedChange = {
                            checkedState.value = it
                            //viewModel.group1CheckedState.add(it)
                            //groups.group_list[index].isSelected = checkedState.value

                                          },
                    )
                }
                Divider( thickness = 1.dp, color = Color.Black)

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
                        //Text(text = "${groups.isSelected}")
                    }
                }

            }


        }

    }

}




