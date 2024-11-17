package com.aurora.carevision.data.remote.admin.auth.datasource
import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.HospitalListResponse
import com.aurora.carevision.data.remote.admin.auth.service.AdminAuthService
import javax.inject.Inject


class DefaultAdminAuthDataSource @Inject constructor(
    private val nurseAuthService: AdminAuthService
) : AdminAuthRemoteDataSource {
    override suspend fun checkUsername(username: String): Boolean {
        return nurseAuthService.checkDuplication(username).result
    }

    override suspend fun getHospitalList(searchText: String): BaseResponse<HospitalListResponse> {
        return AdminAuthService.getHospitalList(searchText)
    }
}
