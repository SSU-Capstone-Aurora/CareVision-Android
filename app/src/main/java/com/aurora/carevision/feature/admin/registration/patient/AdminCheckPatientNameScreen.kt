package com.aurora.carevision.feature.admin.registration.patient


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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.Primary200
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun AdminCheckPatientNameScreen(
    navigateToCameraListInfo: () -> Unit = {},
    onClickBack: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val patientName = "오로라"

        TopAppBarLeft("환자 등록", onClick = onClickBack)

        Spacer(modifier = Modifier
            .height(24.dp)
            .weight(1f))
        Image(painter = painterResource(id = R.drawable.ic_heart), contentDescription = "Patient Registration Done", modifier = Modifier.size(170.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "$patientName 환자가 맞나요?",
            style = CVTheme.typography.headingPrimary,
            color = Gray700,
        )

        Spacer(modifier = Modifier.height(24.dp))

        CVLongButton(
            text = "맞아요",
            onClick = navigateToCameraListInfo,
            modifier = Modifier.fillMaxWidth()
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
        AdminCheckPatientNameScreen()
    }
}
