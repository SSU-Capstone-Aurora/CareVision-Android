package com.aurora.carevision.domain.admin.model.nurserequest

data class NurseList (
    val nurseList: List<NurseList>,
    val count : Int,
){
    data class NurseList(
        val id: String,
        val name: String,
    )
}