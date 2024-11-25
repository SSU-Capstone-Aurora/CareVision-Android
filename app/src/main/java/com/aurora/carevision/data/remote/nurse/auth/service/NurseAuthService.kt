package com.aurora.carevision.data.remote.nurse.auth.service

import com.aurora.carevision.core.network.response.BaseResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseDepartmentListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseHospitalListResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseLoginResponse
import com.aurora.carevision.data.remote.nurse.auth.model.NurseSignUpResponse
import com.aurora.carevision.data.remote.nurse.auth.model.request.NurseLoginRequest
import com.aurora.carevision.data.remote.nurse.auth.model.request.NurseSignUpRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NurseAuthService {
    // 닉네임 중복 확인 api
    @GET("api/check-username")
    suspend fun checkDuplication(@Query ("username") username: String): BaseResponse<Boolean>

    // 회원가입 api
    // 병원리스트 조회 api
    @GET("api/hospitals")
    suspend fun getNurseHospitalList(): BaseResponse<NurseHospitalListResponse>

    // 병원 과 조회 api
    @GET("api/hospitals/departments")
    suspend fun getHospitalDepartmentList(@Query ("hospitalId") hospitalId: Int): BaseResponse<NurseDepartmentListResponse>

    // 회원가입 api
    @POST("api/sign-up")
    suspend fun nurseSignUp(@Body nurseSignUpRequest : NurseSignUpRequest): BaseResponse<NurseSignUpResponse>

    @POST("api/login")
    suspend fun nurseLogin(@Body nurseLoginRequest : NurseLoginRequest): BaseResponse<NurseLoginResponse>
}