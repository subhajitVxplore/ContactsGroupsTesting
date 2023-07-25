package com.test.app.contactsgroupstesting.viewModels

import android.service.autofill.Validators.and
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.test.app.contactsgroupstesting.models.ContactsModel
import com.test.app.contactsgroupstesting.models.GroupsModel


class DashboardViewModel : ViewModel() {

    var demoText = mutableStateOf("demoText")

    var contactsList = mutableStateListOf<ContactsModel>()
    var contactsGroup1 = mutableStateListOf<ContactsModel>()
    var contactsCheckedStatus= mutableStateOf(false)
    var contactsGroup2 = mutableStateListOf<ContactsModel>()
    var contactsGroup3 = mutableStateListOf<ContactsModel>()
    var groupsList = mutableStateListOf<GroupsModel>()

    //var contactCheckedStatus = mutableStateListOf<Boolean>()
    //var contactCheckedStatus:List<Boolean> = listOf(false)

    // var contactCheckedStatus = mutableStateListOf<Boolean>()
 //   var contactCheckedStatus: SnapshotStateList<Boolean>? = null
    var tabIndex = mutableStateOf(0)



    init {
        demoContactList()
        demoGroupList()
    }

    fun demoContactList() {

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

    fun demoGroupList() {
        groupsList.add(GroupsModel(contactsGroup1))
        groupsList.add(GroupsModel(contactsGroup2))
        groupsList.add(GroupsModel(contactsGroup3))

    }

//    fun storeContactCheckedStatus(status:Boolean){
//        contactCheckedStatus.add(status)
//    }


    fun isGroup1Selected(): Boolean {
        for ((index, contacts) in contactsGroup1.withIndex()) {
            if ((contacts.id == (index+1)) and(contacts.isSelected)) {
                    return true
            }

        }
        return false
    }

     fun isGroup2Selected(): Boolean {
        for ((index, contacts) in contactsGroup2.withIndex()) {
            if (contacts.isSelected) {
                return true
            }
        }
        return false
    }

     fun isGroup3Selected(): Boolean {
        for ((index, contacts) in contactsGroup3.withIndex()) {
            if (contacts.isSelected) {
                return true
            }
        }
        return false
    }




}