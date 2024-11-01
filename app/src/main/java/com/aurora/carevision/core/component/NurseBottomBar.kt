package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.White

@Composable
fun NurseBottomBar(
    navigateToHome: () -> Unit = {},
    navigateToPatientInfo: () -> Unit = {},
    navigateToPatientRegister: () -> Unit = {},
    navigateToMyInfo: () -> Unit = {},
) {
    val selectedItem = remember { mutableStateOf("home") }  // 현재 선택된 아이템 상태

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomNavItem(
            icon = R.drawable.ic_home_line,
            label = "홈",
            isSelected = selectedItem.value == "home",
            onClick = {
                selectedItem.value = "home"
                navigateToHome()
            }
        )

        BottomNavItem(
            icon = R.drawable.ic_patient_info_line,
            label = "환자 정보",
            isSelected = selectedItem.value == "patient_info",
            onClick = {
                selectedItem.value = "patient_info"
                navigateToPatientInfo()
            }
        )

        BottomNavItem(
            icon = R.drawable.ic_patient_register_line,
            label = "환자 등록",
            isSelected = selectedItem.value == "patient_register",
            onClick = {
                selectedItem.value = "patient_register"
                navigateToPatientRegister()
            }
        )

        BottomNavItem(
            icon = R.drawable.ic_person_line,
            label = "내 정보",
            isSelected = selectedItem.value == "my_info",
            onClick = {
                selectedItem.value = "my_info"
                navigateToMyInfo()
            }
        )
    }
}

@Composable
fun BottomNavItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "$label Icon",
            tint = if (isSelected) Primary600 else Gray500
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = label,
            textAlign = TextAlign.Center,
            style = CVTheme.typography.captionImportance,
            color = if (isSelected) Primary600 else Gray500
        )
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
