package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.White

@Composable
fun NurseBottomBar(
    navigateToHome: () -> Unit = {},
    navigateToPatientInfo: () -> Unit = {},
    navigateToPatientRegister: () -> Unit = {},
    navigateToMyInfo: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 10.dp)
                .clickable { navigateToHome() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home_line),
                contentDescription = "Bottom Navigation Icon",
                tint = Gray500
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "홈",
                textAlign = TextAlign.Center,
                style = CVTheme.typography.captionImportance,
                color = Gray500
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { navigateToPatientInfo() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_patient_info_line),
                contentDescription = "Bottom Navigation Icon",
                tint = Gray500
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "환자 정보",
                textAlign = TextAlign.Center,
                style = CVTheme.typography.captionImportance,
                color = Gray500
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { navigateToPatientRegister() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_patient_register_line),
                contentDescription = "Bottom Navigation Icon",
                tint = Gray500
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "환자 등록",
                textAlign = TextAlign.Center,
                style = CVTheme.typography.captionImportance,
                color = Gray500
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(end = 10.dp)
                .clickable { navigateToMyInfo() }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_person_line),
                contentDescription = "Bottom Navigation Icon",
                tint = Gray500
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "내 정보",
                textAlign = TextAlign.Center,
                style = CVTheme.typography.captionImportance,
                color = Gray500
            )
        }
    }
}

@Composable
@Preview
fun NurseBottomBarPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
        ) {
            NurseBottomBar()
        }
    }
}