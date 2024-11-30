package com.aurora.carevision.feature.nurse.patient.registration.barcode.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.Primary200
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft
import com.aurora.carevision.feature.nurse.patient.registration.barcode.SelfRegistrationViewModel

@Composable
fun CheckPatientNameScreen(
    navigateToCameraListInfo: () -> Unit = {},
    onClickBack: () -> Unit = {},
    viewModel: SelfRegistrationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        TopAppBarLeft("환자 등록", onClick = onClickBack)

        Spacer(modifier = Modifier
            .height(24.dp)
            .weight(1f))
        Image(painter = painterResource(id = R.drawable.img_patient_register_done), contentDescription = "Patient Registration Done", modifier = Modifier.size(170.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = if(state.patientNameValidation) "${state.patientName} 환자가 맞나요?" else "해당하는 환자가 없습니다.",
            style = CVTheme.typography.headingPrimary,
            color = Gray700,
        )

        Spacer(modifier = Modifier.height(24.dp))

        CVLongButton(
            text = "맞아요",
            onClick = {
                navigateToCameraListInfo()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = state.enabledNextButton
        )
        Spacer(modifier = Modifier.height(16.dp))
        CVLongButton(
            text = "아니에요",
            onClick = onClickBack,
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Primary200,
            textColor = Primary700
        )

        Spacer(modifier = Modifier
            .height(24.dp)
            .weight(1f))
    }
}

@Composable
@Preview
fun CheckPatientNameScreenPreview(){
    CVTheme{
        CheckPatientNameScreen()
    }
}

