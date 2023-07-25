package com.test.app.contactsgroupstesting.models

import androidx.compose.runtime.snapshots.SnapshotStateList

data class GroupsModel(
    var group_list: List<ContactsModel>,
    //var group_list: List<SnapshotStateList<ContactsModel>>,
)