package com.test.app.contactsgroupstesting.ui.screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.material.icons.filled.RemoveDone
import androidx.compose.material.icons.filled.RemoveFromQueue
import androidx.compose.material.icons.filled.RemoveModerator
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.test.app.contactsgroupstesting.viewModels.DashboardViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RangePlusMinusPage(viewModel: DashboardViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val context = LocalContext.current
        Card(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(50.dp),
            //.wrapContentHeight()
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                // Text(text = "+",modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Remove, contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {

                                if (viewModel.mutableValue.value<=0){
                                    Toast
                                        .makeText(
                                            context,
                                            "less than Zero not allowed",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()

                                }else{
                                    viewModel.mutableValue.value--
                                }

                            },
                        )

                )
                Divider(
                    color = Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Text(text = "${viewModel.mutableValue.value}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                //Text(text = "${mutableValue.value}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Divider(
                    color = Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .clickable(
                            //enabled = viewModel.mutableValue.value < 10,
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {
                                if (viewModel.mutableValue.value>=10){
                                    Toast
                                        .makeText(
                                            context,
                                            "greater than Ten not allowed",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }else{
                                    viewModel.mutableValue.value++
                                }
                            },
                        )
                )

            }
        }

    }
}