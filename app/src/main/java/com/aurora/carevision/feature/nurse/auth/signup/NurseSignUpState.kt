package com.aurora.carevision.feature.nurse.auth.signup

import com.aurora.carevision.domain.nurse.model.auth.DepartmentList
import com.aurora.carevision.domain.nurse.model.auth.HospitalList

data class NurseSignUpState(
    var hospitalList: List<HospitalList.Hospital> = emptyList(),
    var departmentList: List<DepartmentList.Department> = emptyList(),
    var selectedHospitalName: String = "",
    var selectedHospitalId: Int = 0,
    var selectedDepartmentName: String = "",
    var selectedDepartmentId: Int = 0,
    val userName: String = "",
    val userId: String = "",
    val password: String = "",
    val doCheckNameDuplicate: Boolean = false,
    val nameDuplicate: Boolean = true,
)