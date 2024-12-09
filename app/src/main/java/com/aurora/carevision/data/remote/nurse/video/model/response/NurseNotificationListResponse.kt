package com.aurora.carevision.data.remote.nurse.video.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NurseNotificationListResponse(
    @SerialName("alarmInfoList")
    val notificationList: List<Notification>,
    @SerialName("totalCount")
    val totalCount: Int,
){
    @Serializable
    data class Notification(
        @SerialName("documentId")
        val documentId: String,
        @SerialName("inpatientWardNumber")
        val inpatientWardNumber: Int,
        @SerialName("patientRoomNumber")
        val patientRoomNumber: Int,
        @SerialName("bedNumber")
        val bedNumber: Int,
        @SerialName("patientName")
        val patientName: String,
        @SerialName("patientId")
        val patientId: Int,
        @SerialName("timeAgo")
        val timeAgo: String
    )
}


fun NurseNotificationListResponse.toDomainModel(): List<com.aurora.carevision.domain.nurse.model.notification.Notification> {
    return notificationList.map {
        com.aurora.carevision.domain.nurse.model.notification.Notification(
            documentId = it.documentId,
            patientId = it.patientId,
            patientName = it.patientName,
            inpatientWardNumber = it.inpatientWardNumber,
            patientRoomNumber = it.patientRoomNumber,
            bedNumber = it.bedNumber,
            notificationTime = it.timeAgo
        )
    }
}