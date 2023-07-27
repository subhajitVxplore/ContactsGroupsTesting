package com.test.app.contactsgroupstesting.models

data class GroupsModel(
    var group_list: List<ContactsModel>,
    var isAllSelected: Boolean,
    var isIntermediate: Boolean
)