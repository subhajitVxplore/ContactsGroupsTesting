package com.test.app.contactsgroupstesting.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.app.contactsgroupstesting.models.ContactsModel
import com.test.app.contactsgroupstesting.models.GroupsModel
import kotlinx.coroutines.launch


class DashboardViewModel : ViewModel() {

    var contactsList = mutableStateListOf<ContactsModel>()
    var contactsGroup1 = mutableStateListOf<ContactsModel>()
    var contactsGroup2 = mutableStateListOf<ContactsModel>()
    var contactsGroup3 = mutableStateListOf<ContactsModel>()
    var groupsList = mutableStateListOf<GroupsModel>()
    var tabIndex = mutableStateOf(0)
    val tabs = mutableStateListOf("Contacts", "Groups")
    var falseCounter= mutableStateOf(3)
    var mutableValue= mutableStateOf(0)


    init {
        demoContactList()
        demoGroupList()
    }

    fun demoContactList()= viewModelScope.launch {

        contactsGroup1.add(ContactsModel(1, "Sayna", "8282811678", false))
        contactsGroup1.add(ContactsModel(2, "Puja", "9876543210", false))
        contactsGroup1.add(ContactsModel(3, "Rimi", "9123456780", false))
        contactsGroup1.add(ContactsModel(4, "Abhisek", "8123456790", false))
        contactsList += (contactsGroup1)

        contactsGroup2.add(ContactsModel(5, "Rohan", "7891234560", false))
        contactsGroup2.add(ContactsModel(6, "Habibur", "9087654321", false))
        contactsGroup2.add(ContactsModel(7, "Ranojoy", "9543216780", false))
        contactsGroup2.add(ContactsModel(8, "Ankita", "9321456780", false))
        contactsList += (contactsGroup2)

        contactsGroup3.add(ContactsModel(9, "Puravi", "8976512340", false))
        contactsGroup3.add(ContactsModel(10, "Aryan", "7098654321", false))
        contactsGroup3.add(ContactsModel(11, "Ayushi", "7123409856", false))
        contactsGroup3.add(ContactsModel(12, "Avik", "8009812345", false))
        contactsList += (contactsGroup3)

    }

    fun demoGroupList()= viewModelScope.launch {
        groupsList.add(GroupsModel(contactsGroup1,false))
        groupsList.add(GroupsModel(contactsGroup2,false))
        groupsList.add(GroupsModel(contactsGroup3,false))
    }



}