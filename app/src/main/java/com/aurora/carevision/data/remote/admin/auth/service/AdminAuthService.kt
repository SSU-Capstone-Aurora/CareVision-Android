package com.aurora.carevision.data.remote.admin.auth.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminDepartmentListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminSignUpResponse
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminSignUpRequest
import com.aurora.carevision.data.remote.admin.auth.model.AdminHospitalListResponse
import com.aurora.carevision.data.remote.admin.auth.model.AdminLoginResponse
import com.aurora.carevision.data.remote.admin.auth.model.request.AdminLoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
interface AdminAuthService {
    // 로그인 api
    @POST("api/admin/login")
    suspend fun adminLogin(@Body adminLoginRequest: AdminLoginRequest): BaseResponse<AdminLoginResponse>
    // 회원가입
    // 닉네임 중복 확인 api
    @GET("api/admin/check-username")
    suspend fun checkDuplicationAdmin(@Query ("username") username: String): BaseResponse<Boolean>

    // 병원명 조회 api
    @GET("api/admin/hospitals")
    suspend fun getAdminHospitalList(@Query ("search") searchText: String): BaseResponse<AdminHospitalListResponse>

    // 병원 과 조회 api
    @GET("api/admin/departments")
    suspend fun getAdminDepartmentList(@Query ("hospital") hospital: String): BaseResponse<AdminDepartmentListResponse>
    // 회원가입 api
    @POST("api/admin/sign-up")
    suspend fun adminSignUp(@Body adminSignUpRequest : AdminSignUpRequest): BaseResponse<AdminSignUpResponse>

}