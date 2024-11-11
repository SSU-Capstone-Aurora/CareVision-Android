package com.aurora.carevision.feature.admin.auth.signup

data class AdminSignUpHospitalEntryState(
    val hospitalName: String = "",
    val isTyping: Boolean = false,
    val isFieldVisible: Boolean = false,
    val selectedItem: String = "",
    val searchResults: List<String> = emptyList(),
    val isError: Boolean = false,
    val department: String = "",
    val userName: String = "",
    val userId: String = "",
    val password: String = "",
    val nameDuplicate: Boolean = false,
)