package com.aurora.carevision.domain.admin.model.nurserequest

data class NurseRequestList(
    val requests: List<NurseRequest>,
    val requestCount: Int
) {
    data class NurseRequest(
        val nurseId: Int,
        val name: String,
        val username: String,
        val requestTime: String
    )
}
