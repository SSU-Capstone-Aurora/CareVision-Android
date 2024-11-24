package com.aurora.carevision.feature.admin.auth.signup

import com.aurora.carevision.data.remote.admin.auth.model.AdminHospitalListResponse
import com.aurora.carevision.domain.admin.model.auth.DepartmentList
import com.aurora.carevision.domain.admin.model.auth.HospitalList

data class AdminSignUpHospitalEntryState(
    var searchQuery: String ="",
    var hospitalList: List<HospitalList.Hospital> = emptyList(),
    var departmentList: List<DepartmentList.Department> = emptyList(),
    var selectedHospitalName: String = "",
    var selectedHospitalId: Int = 0,
    var selectedDepartmentName: String = "",
    var selectedDepartmentId: Int = 0,
    val isTyping: Boolean = false,
    val isFieldVisible: Boolean = false,
    val isError: Boolean = false,
    val userName: String = "",
    val userId: String = "",
    val password: String = "",
    val nameDuplicate: Boolean = false,
    val isHospitalSelected: Boolean = false,
)