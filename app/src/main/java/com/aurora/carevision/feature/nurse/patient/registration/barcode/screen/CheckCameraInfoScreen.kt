package com.aurora.carevision.feature.nurse.patient.registration.barcode.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.nurse.patient.registration.barcode.SelfRegistrationSideEffect
import com.aurora.carevision.feature.nurse.patient.registration.barcode.SelfRegistrationViewModel

@Composable
fun CheckCameraInfoRoute(
    navigateToDone: () -> Unit = {},
    onClickBack: () -> Unit = {},
    viewModel: SelfRegistrationViewModel = viewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect.collect {
            when(it){
                SelfRegistrationSideEffect.PostNewPatientSuccess -> {
                    navigateToDone()
                }
                SelfRegistrationSideEffect.PostNewPatientFailure -> {
                    Toast.makeText(context, "환자 등록에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }
    }

    CheckCameraInfoScreen(
        onClickBack = onClickBack,
        postNewPatient = {
            viewModel.postNewPatient()
        },
        patientName = state.patientName,
        selectedInpatientWardNumber = state.selectedInpatientWardNumber,
        selectedPatientRoomNumber = state.selectedPatientRoomNumber,
        selectedBedNumber = state.selectedBedNumber,
        selectedCameraCode = state.selectedCameraCode
    )
}

@Composable
fun CheckCameraInfoScreen(
    onClickBack: () -> Unit = {},
    postNewPatient: () -> Unit = {},
    patientName: String = "",
    selectedInpatientWardNumber: Int = 0,
    selectedPatientRoomNumber: Int = 0,
    selectedBedNumber: Int = 0,
    selectedCameraCode: String = ""
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Gray100),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){

        TopAppBarLeft("환자 등록", onClick = onClickBack)

        Spacer(modifier = Modifier
            .height(28.dp)
            .weight(0.5f))

        Text(
            text = "등록할 환자의\n정보를 확인해주세요",
            style = CVTheme.typography.headingPrimary,
            color = Gray700,
            modifier = Modifier
                .padding(start = 24.dp, bottom = 24.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(White)
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "환자명",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                )

                Text(
                    text = "${patientName}",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray600,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "베드 정보",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                )

                Text(
                    text = "${selectedInpatientWardNumber}동 ${selectedPatientRoomNumber}호 ${selectedBedNumber}베드",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray600,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "카메라",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                    modifier = Modifier
                )

                Text(
                    text = "${selectedCameraCode}",
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray600,
                    modifier = Modifier
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        CVLongButton(
            text = "확인",
            onClick = {
                postNewPatient()
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .height(28.dp)
            .weight(1f))
    }
}

@Composable
@Preview
fun CheckCameraInfoScreenPreview(){
    CVTheme{
        CheckCameraInfoScreen(
            onClickBack = {},
            postNewPatient = {},
            patientName = "김철수",
            selectedInpatientWardNumber = 1,
            selectedPatientRoomNumber = 101,
            selectedBedNumber = 1,
            selectedCameraCode = "CAM001"
        )
    }
}

