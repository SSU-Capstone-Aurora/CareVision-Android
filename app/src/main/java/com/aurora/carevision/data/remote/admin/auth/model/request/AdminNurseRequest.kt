package com.aurora.carevision.data.remote.admin.auth.model.request


data class AdminNurseRequestList(
    val requests: List<NurseRequest>,
    val requestCount: Int,
) {
    data class NurseRequest(
        val nurseId: Int,
        val name: String,
        val username: String,
        val requestTime: String
    )
}