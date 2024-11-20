package com.aurora.carevision.feature.nurse.auth.signup

import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse
import com.aurora.carevision.domain.nurse.model.auth.Department
import com.aurora.carevision.domain.nurse.model.auth.HospitalList

data class NurseSignUpState(
    var hospitalList: List<HospitalList.Hospital> = emptyList(),
    val departmentList: List<Department> = emptyList(),
    val selectedHospitalName: String = "",
    val selectedDepartment: String = "",
    val userName: String = "",
    val userId: String = "",
    val password: String = "",
    val doCheckNameDuplicate: Boolean = false,
    val nameDuplicate: Boolean = true,
)